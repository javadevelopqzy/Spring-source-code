package mycase.bean_factory.processor.property;

import java.util.*;

public class PropertyBean {

	private String id;

	public PropertyBean() {
		id = UUID.randomUUID().toString();
	}

	public void display() {
		System.out.println(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
