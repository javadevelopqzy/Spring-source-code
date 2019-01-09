package mycase.cycle;

public class Bean2 {

	Bean3 bean3;

	public void str() {
		bean3.str();
	}

	public Bean3 getBean3() {
		return bean3;
	}

	public void setBean3(Bean3 bean3) {
		this.bean3 = bean3;
	}
}
