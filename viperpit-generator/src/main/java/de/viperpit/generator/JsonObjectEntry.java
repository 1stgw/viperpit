package de.viperpit.generator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

@Data
@SuppressWarnings("all")
public class JsonObjectEntry {
	public static Iterable<JsonObjectEntry> getJsonEntries(final ClassDeclaration clazz) {
		try {
			final String string = IterableExtensions.head(clazz.getAnnotations()).getValue("value").toString();
			boolean _startsWith = string.trim().startsWith("{");
			boolean _not = (!_startsWith);
			if (_not) {
				final InputStream in = new URL(string).openStream();
				try {
					JsonParser _jsonParser = new JsonParser();
					InputStreamReader _inputStreamReader = new InputStreamReader(in);
					final JsonElement jsonElement = _jsonParser.parse(_inputStreamReader);
					JsonObject _xifexpression = null;
					boolean _isJsonArray = jsonElement.isJsonArray();
					if (_isJsonArray) {
						JsonElement _get = jsonElement.getAsJsonArray().get(0);
						_xifexpression = ((JsonObject) _get);
					} else {
						_xifexpression = jsonElement.getAsJsonObject();
					}
					final JsonObject jsonObject = _xifexpression;
					return JsonObjectEntry.getEntries(jsonObject, clazz.getCompilationUnit());
				} finally {
					in.close();
				}
			}
			JsonElement _parse = new JsonParser().parse(string);
			return JsonObjectEntry.getEntries(((JsonObject) _parse), clazz.getCompilationUnit());
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	private static Iterable<JsonObjectEntry> getEntries(final JsonElement e, final CompilationUnit unit) {
		Iterable<JsonObjectEntry> _switchResult = null;
		boolean _matched = false;
		if (e instanceof JsonObject) {
			_matched = true;
			final Function1<Map.Entry<String, JsonElement>, JsonObjectEntry> _function = new Function1<Map.Entry<String, JsonElement>, JsonObjectEntry>() {
				public JsonObjectEntry apply(final Map.Entry<String, JsonElement> it) {
					return new JsonObjectEntry(unit, it);
				}
			};
			_switchResult = IterableExtensions.<Map.Entry<String, JsonElement>, JsonObjectEntry>map(
					((JsonObject) e).entrySet(), _function);
		}
		if (!_matched) {
			_switchResult = Collections
					.<JsonObjectEntry>unmodifiableList(CollectionLiterals.<JsonObjectEntry>newArrayList());
		}
		return _switchResult;
	}

	private final CompilationUnit unit;

	private final Map.Entry<String, JsonElement> entry;

	public String getKey() {
		return this.entry.getKey();
	}

	public JsonElement getValue() {
		return this.entry.getValue();
	}

	public boolean isArray() {
		JsonElement _value = this.entry.getValue();
		return (_value instanceof JsonArray);
	}

	public boolean isJsonObject() {
		JsonObject _jsonObject = this.getJsonObject();
		return (_jsonObject != null);
	}

	private JsonObject getJsonObject() {
		JsonElement value = this.entry.getValue();
		boolean _isArray = this.isArray();
		if (_isArray) {
			value = IterableExtensions.<JsonElement>head(((JsonArray) value));
		}
		if ((value instanceof JsonObject)) {
			return ((JsonObject) value);
		}
		return null;
	}

	public String getPropertyName() {
		final String result = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, this.entry.getKey().replace(" ", "_"));
		boolean _isArray = this.isArray();
		if (_isArray) {
			String _xifexpression = null;
			boolean _endsWith = result.endsWith("s");
			if (_endsWith) {
				_xifexpression = result;
			} else {
				_xifexpression = (result + "s");
			}
			return _xifexpression;
		}
		String _xifexpression_1 = null;
		boolean _equals = Objects.equal(result, "class");
		if (_equals) {
			_xifexpression_1 = "clazz";
		} else {
			_xifexpression_1 = result;
		}
		return _xifexpression_1;
	}

	public String getClassName() {
		boolean _isJsonObject = this.isJsonObject();
		if (_isJsonObject) {
			final String simpleName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL,
					this.entry.getKey().replace(" ", "_"));
			String _xifexpression = null;
			String _packageName = this.unit.getPackageName();
			boolean _tripleNotEquals = (_packageName != null);
			if (_tripleNotEquals) {
				String _packageName_1 = this.unit.getPackageName();
				String _plus = (_packageName_1 + ".");
				_xifexpression = (_plus + simpleName);
			} else {
				_xifexpression = simpleName;
			}
			return _xifexpression;
		}
		return null;
	}

	public TypeReference getComponentType(@Extension final TransformationContext ctx) {
		TypeReference _xblockexpression = null;
		{
			JsonElement _xifexpression = null;
			JsonElement _value = this.entry.getValue();
			if ((_value instanceof JsonArray)) {
				JsonElement _value_1 = this.entry.getValue();
				_xifexpression = IterableExtensions.<JsonElement>head(((JsonArray) _value_1));
			} else {
				_xifexpression = this.entry.getValue();
			}
			final JsonElement v = _xifexpression;
			TypeReference _switchResult = null;
			boolean _matched = false;
			if (v instanceof JsonPrimitive) {
				_matched = true;
				TypeReference _xifexpression_1 = null;
				boolean _isBoolean = ((JsonPrimitive) v).isBoolean();
				if (_isBoolean) {
					_xifexpression_1 = ctx.newTypeReference(Boolean.class);
				} else {
					TypeReference _xifexpression_2 = null;
					boolean _isNumber = ((JsonPrimitive) v).isNumber();
					if (_isNumber) {
						_xifexpression_2 = ctx.newTypeReference(Long.class);
					} else {
						TypeReference _xifexpression_3 = null;
						boolean _isString = ((JsonPrimitive) v).isString();
						if (_isString) {
							_xifexpression_3 = ctx.getString();
						}
						_xifexpression_2 = _xifexpression_3;
					}
					_xifexpression_1 = _xifexpression_2;
				}
				_switchResult = _xifexpression_1;
			}
			if (!_matched) {
				if (v instanceof JsonObject) {
					_matched = true;
					_switchResult = ctx.newTypeReference(ctx.findClass(this.getClassName()));
				}
			}
			_xblockexpression = _switchResult;
		}
		return _xblockexpression;
	}

	public Iterable<JsonObjectEntry> getChildEntries() {
		boolean _isJsonObject = this.isJsonObject();
		if (_isJsonObject) {
			return JsonObjectEntry.getEntries(this.getJsonObject(), this.unit);
		}
		return Collections.<JsonObjectEntry>unmodifiableList(CollectionLiterals.<JsonObjectEntry>newArrayList());
	}

	public JsonObjectEntry(final CompilationUnit unit, final Map.Entry<String, JsonElement> entry) {
		super();
		this.unit = unit;
		this.entry = entry;
	}

	@Override
	@Pure
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.unit == null) ? 0 : this.unit.hashCode());
		return prime * result + ((this.entry == null) ? 0 : this.entry.hashCode());
	}

	@Override
	@Pure
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JsonObjectEntry other = (JsonObjectEntry) obj;
		if (this.unit == null) {
			if (other.unit != null)
				return false;
		} else if (!this.unit.equals(other.unit))
			return false;
		if (this.entry == null) {
			if (other.entry != null)
				return false;
		} else if (!this.entry.equals(other.entry))
			return false;
		return true;
	}

	@Override
	@Pure
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("unit", this.unit);
		b.add("entry", this.entry);
		return b.toString();
	}

	@Pure
	public CompilationUnit getUnit() {
		return this.unit;
	}

	@Pure
	public Map.Entry<String, JsonElement> getEntry() {
		return this.entry;
	}
}
