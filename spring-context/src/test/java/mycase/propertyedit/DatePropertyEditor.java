package mycase.propertyedit;

import java.beans.*;
import java.text.*;

public class DatePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setValue(simpleDateFormat.parse(text));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
