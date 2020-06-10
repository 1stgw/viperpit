package de.viperpit.generator;

import java.io.StringWriter;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;

@SuppressWarnings("all")
public abstract class AbstractJsonized {
	@Accessors
	protected JsonObject delegate = new JsonObject();

	protected Object wrap(final JsonElement element, final Class<?> containerType) {
		try {
			Object _switchResult = null;
			boolean _matched = false;
			if (element instanceof JsonPrimitive) {
				_matched = true;
				Object _xifexpression = null;
				boolean _isBoolean = ((JsonPrimitive) element).isBoolean();
				if (_isBoolean) {
					_xifexpression = Boolean.valueOf(((JsonPrimitive) element).getAsBoolean());
				} else {
					Object _xifexpression_1 = null;
					boolean _isNumber = ((JsonPrimitive) element).isNumber();
					if (_isNumber) {
						_xifexpression_1 = Long.valueOf(((JsonPrimitive) element).getAsNumber().longValue());
					} else {
						String _xifexpression_2 = null;
						boolean _isString = ((JsonPrimitive) element).isString();
						if (_isString) {
							_xifexpression_2 = ((JsonPrimitive) element).getAsString();
						}
						_xifexpression_1 = _xifexpression_2;
					}
					_xifexpression = _xifexpression_1;
				}
				_switchResult = _xifexpression;
			}
			if (!_matched) {
				if (element instanceof JsonArray) {
					_matched = true;
					final Function1<JsonElement, Object> _function = new Function1<JsonElement, Object>() {
						public Object apply(final JsonElement it) {
							return AbstractJsonized.this.wrap(it, containerType);
						}
					};
					_switchResult = IterableExtensions.<Object>toList(
							IterableExtensions.<JsonElement, Object>map(((Iterable<JsonElement>) element), _function));
				}
			}
			if (!_matched) {
				if (element instanceof JsonObject) {
					_matched = true;
					Object _newInstance = containerType.getConstructor().newInstance();
					final AbstractJsonized jsonized = ((AbstractJsonized) _newInstance);
					jsonized.delegate = ((JsonObject) element);
					return jsonized;
				}
			}
			if (!_matched) {
				_switchResult = null;
			}
			return _switchResult;
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	protected JsonElement unWrap(final Object element, final Class<?> containerType) {
		JsonElement _switchResult = null;
		boolean _matched = false;
		if (element instanceof Boolean) {
			_matched = true;
			_switchResult = new JsonPrimitive(((Boolean) element));
		}
		if (!_matched) {
			if (element instanceof Number) {
				_matched = true;
				_switchResult = new JsonPrimitive(((Number) element));
			}
		}
		if (!_matched) {
			if (element instanceof String) {
				_matched = true;
				_switchResult = new JsonPrimitive(((String) element));
			}
		}
		if (!_matched) {
			if (element instanceof AbstractJsonized) {
				_matched = true;
				_switchResult = ((AbstractJsonized) element).delegate;
			}
		}
		if (!_matched) {
			if (element instanceof List) {
				_matched = true;
				JsonArray _xblockexpression = null;
				{
					final JsonArray result = new JsonArray();
					final Consumer<Object> _function = new Consumer<Object>() {
						public void accept(final Object it) {
							result.add(AbstractJsonized.this.unWrap(it, containerType));
						}
					};
					((List<?>) element).forEach(_function);
					_xblockexpression = result;
				}
				_switchResult = _xblockexpression;
			}
		}
		if (!_matched) {
			_switchResult = JsonNull.INSTANCE;
		}
		return _switchResult;
	}

	public String toString() {
		try {
			final StringWriter stringWriter = new StringWriter();
			JsonWriter _jsonWriter = new JsonWriter(stringWriter);
			final Procedure1<JsonWriter> _function = new Procedure1<JsonWriter>() {
				public void apply(final JsonWriter it) {
					it.setIndent("  ");
					it.setLenient(true);
					it.setSerializeNulls(false);
				}
			};
			final JsonWriter jsonWriter = ObjectExtensions.<JsonWriter>operator_doubleArrow(_jsonWriter, _function);
			Streams.write(this.delegate, jsonWriter);
			return stringWriter.toString();
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	@Pure
	public JsonObject getDelegate() {
		return this.delegate;
	}

	public void setDelegate(final JsonObject delegate) {
		this.delegate = delegate;
	}
}
