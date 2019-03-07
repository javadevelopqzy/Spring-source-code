package mycase.aop.jdk;

public class JdkDynamicProxy implements DynamicProxyinterface {

	@Override
	public void test() {
		System.out.println("执行test");
	}
}
