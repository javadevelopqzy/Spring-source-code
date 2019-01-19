package mycase.property.edit;

import java.lang.reflect.*;

import org.springframework.beans.*;
import org.springframework.core.*;

public class DateTypeConverter implements TypeConverter {

	@Override
	public <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException {
		return null;
	}

	@Override
	public <T> T convertIfNecessary(Object value, Class<T> requiredType, MethodParameter methodParam) throws TypeMismatchException {
		return null;
	}

	@Override
	public <T> T convertIfNecessary(Object value, Class<T> requiredType, Field field) throws TypeMismatchException {
		return null;
	}
}
