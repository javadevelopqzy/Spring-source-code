package mycase.aop.cglib;

import java.lang.reflect.*;

import org.springframework.cglib.proxy.*;

import mycase.aop.*;

public class CglibProxyFactory implements MethodInterceptor {

	private Class target;

	public CglibProxyFactory(Class target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("调用目标方法了，现在是前置处理");
		Object invoke = methodProxy.invokeSuper(o, objects);
		System.out.println("调用目标方法了，现在是后置处理");
		return null;
	}

	public Object getProxyInstance() {
		Enhancer e = new Enhancer();
		e.setSuperclass(target);
		e.setCallback(this);
		return e.create();
	}

	public static void main(String[] args) {
		CglibProxyFactory proxyClass = new CglibProxyFactory(AopTestBean.class);
		AopTestBean proxyInstance = (AopTestBean) proxyClass.getProxyInstance();
		proxyInstance.test();
	}
}
