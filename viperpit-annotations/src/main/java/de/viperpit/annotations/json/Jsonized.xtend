package de.viperpit.annotations.json

import com.google.common.base.CaseFormat
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonPrimitive
import com.google.gson.internal.Streams
import com.google.gson.stream.JsonWriter
import java.io.InputStreamReader
import java.io.StringWriter
import java.net.URL
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference

import static extension de.viperpit.annotations.json.JsonObjectEntry.getJsonEntries

@Active(JsonizedProcessor)
annotation Jsonized {
	String value
}

@Data class JsonObjectEntry {

	def static Iterable<JsonObjectEntry> getJsonEntries(ClassDeclaration clazz) {
		val string = clazz.annotations.head.getValue('value').toString
		if (!string.trim.startsWith("{")) {
			val in = new URL(string).openStream;
			try {
				val jsonElement = new JsonParser().parse(new InputStreamReader(in))
				val jsonObject = if (jsonElement.jsonArray) {
						jsonElement.asJsonArray.get(0) as JsonObject
					} else {
						jsonElement.asJsonObject
					}
				return jsonObject.getEntries(clazz.compilationUnit)
			} finally {
				in.close
			}
		}
		return (new JsonParser().parse(string) as JsonObject).getEntries(clazz.compilationUnit)
	}

	private static def Iterable<JsonObjectEntry> getEntries(JsonElement e, CompilationUnit unit) {
		switch e {
			JsonObject: {
				e.entrySet.map[new JsonObjectEntry(unit, it)]
			}
			default:
				#[]
		}
	}

	CompilationUnit unit
	Map.Entry<String, JsonElement> entry

	def String getKey() {
		return entry.key
	}

	def JsonElement getValue() {
		return entry.value
	}

	def boolean isArray() {
		entry.value instanceof JsonArray
	}

	def boolean isJsonObject() {
		return getJsonObject !== null
	}

	private def getJsonObject() {
		var value = entry.value
		if (isArray)
			value = (value as JsonArray).head
		if (value instanceof JsonObject) {
			return value
		}
		return null
	}

	def getPropertyName() {
		val result = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, entry.key.replace(' ', '_'))
		if (isArray) {
			return if (result.endsWith('s')) result else result + 's'
		}
		return if (result == 'class') {
			'clazz'
		} else {
			result
		}
	}

	def getClassName() {
		if (isJsonObject) {
			val simpleName = CaseFormat::LOWER_CAMEL.to(CaseFormat::UPPER_CAMEL, entry.key.replace(' ', '_'))
			return if (unit.packageName !== null)
				unit.packageName + "." + simpleName
			else
				simpleName
		}
		return null
	}

	def TypeReference getComponentType(extension TransformationContext ctx) {
		val v = if (entry.value instanceof JsonArray) {
				(entry.value as JsonArray).head
			} else {
				entry.value
			}
		switch v {
			JsonPrimitive: {
				if (v.isBoolean)
					newTypeReference(Boolean)
				else if (v.isNumber)
					newTypeReference(Long)
				else if (v.isString)
					string
			}
			JsonObject: {
				findClass(className).newTypeReference
			}
		}
	}

	def Iterable<JsonObjectEntry> getChildEntries() {
		if (isJsonObject) {
			return getEntries(getJsonObject, unit)
		}
		return #[]
	}

}

abstract class AbstractJsonized {

	@Accessors protected JsonObject delegate = new JsonObject

	def protected Object wrap(JsonElement element, Class<?> containerType) {
		switch element {
			JsonPrimitive: {
				if (element.boolean)
					element.asBoolean
				else if (element.isNumber)
					element.asNumber.longValue
				else if (element.string)
					element.asString
			}
			JsonArray: {
				element.map[wrap(it, containerType)].toList
			}
			JsonObject: {
				val jsonized = containerType.getConstructor().newInstance as AbstractJsonized
				jsonized.delegate = element
				return jsonized
			}
			default:
				null
		}
	}

	def protected JsonElement unWrap(Object element, Class<?> containerType) {
		switch element {
			Boolean: {
				new JsonPrimitive(element)
			}
			Number: {
				new JsonPrimitive(element)
			}
			String: {
				new JsonPrimitive(element)
			}
			AbstractJsonized: {
				element.delegate
			}
			List<?>: {
				val result = new JsonArray
				element.forEach [
					result.add(unWrap(it, containerType))
				]
				result
			}
			default:
				JsonNull.INSTANCE
		}
	}

	override toString() {
		val stringWriter = new StringWriter()
		val jsonWriter = new JsonWriter(stringWriter) => [
			indent = '  '
			lenient = true
			serializeNulls = false
		]
		Streams.write(delegate, jsonWriter)
		return stringWriter.toString
	}

}

class JsonizedProcessor extends AbstractClassProcessor {

	override doRegisterGlobals(ClassDeclaration annotatedClass, RegisterGlobalsContext context) {
		registerClassNamesRecursively(annotatedClass.jsonEntries, context)
	}

	private def void registerClassNamesRecursively(Iterable<JsonObjectEntry> json, RegisterGlobalsContext context) {
		for (jsonEntry : json) {
			if (jsonEntry.isJsonObject) {
				context.registerClass(jsonEntry.className)
				registerClassNamesRecursively(jsonEntry.childEntries, context)
			}
		}
	}

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		enhanceClassesRecursively(annotatedClass, annotatedClass.jsonEntries, context)
		annotatedClass.addConstructor [
			addParameter('delegate', newTypeReference(JsonElement))
			body = ['''setDelegate((com.google.gson.JsonObject)delegate);''']
		]
	}

	def void enhanceClassesRecursively(MutableClassDeclaration clazz, Iterable<? extends JsonObjectEntry> entries, extension TransformationContext context) {
		clazz.extendedClass = newTypeReference(AbstractJsonized)
		for (entry : entries) {
			val type = entry.getComponentType(context)
			val realType = if (entry.isArray) getList(type) else type
			clazz.addMethod("get" + entry.propertyName.toFirstUpper) [
				returnType = realType
				body = [
					'''
						return («realType») wrap(delegate.get("«entry.key»"), «toJavaCode(type)».class);
					'''
				]
			]
			clazz.addMethod("set" + entry.propertyName.toFirstUpper) [
				addParameter(entry.propertyName, realType)
				returnType = primitiveVoid
				body = [
					'''
						delegate.add("«entry.key»", unWrap(«entry.propertyName», «toJavaCode(type)».class));
					'''
				]
			]
			if (entry.isJsonObject) {
				enhanceClassesRecursively(findClass(entry.className), entry.childEntries, context)
			}
		}
	}

}
