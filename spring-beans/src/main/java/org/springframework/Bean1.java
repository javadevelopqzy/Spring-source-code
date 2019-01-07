package org.springframework;

public class Bean1 {

	Bean2 bean2;

	public void str() {
		System.out.println("str1");
	}

	public Bean2 getBean2() {
		return bean2;
	}

	public void setBean2(Bean2 bean2) {
		this.bean2 = bean2;
	}
}
