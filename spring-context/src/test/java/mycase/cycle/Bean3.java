package mycase.cycle;

import java.util.*;

public class Bean3 {

	Bean1 bean1;

	Date date;

	public void str() {
		bean1.str();
	}

	public Bean1 getBean1() {
		return bean1;
	}

	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
