package mycase.aop;

import org.springframework.aop.framework.*;

public class AopExposeProxyTestBean {

	public void test() {
		// expose-proxy=true
		// 让test2也继续代理
		((AopExposeProxyTestBean) AopContext.currentProxy()).test2();
		System.out.println("test");
	}

	public void test2() {
		System.out.println("test2");
	}
}
