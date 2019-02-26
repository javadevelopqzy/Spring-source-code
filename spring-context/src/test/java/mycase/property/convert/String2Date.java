package mycase.property.convert;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class String2Date implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if (source.equals("2018-01-05")){
			return new Date();
		}
		return null;
	}
}
