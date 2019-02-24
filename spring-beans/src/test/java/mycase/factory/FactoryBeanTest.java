package mycase.factory;

public class FactoryBeanTest {

	String abc;

	public FactoryBeanTest(Object abc) {
	}

	public FactoryBeanTest(String abc) {
		System.out.println(abc);
	}

	public FactoryBeanTest(String abc, Integer a) {

	}

	public FactoryBeanTest(String abc, Integer a, Double qwe) {

	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}
}
