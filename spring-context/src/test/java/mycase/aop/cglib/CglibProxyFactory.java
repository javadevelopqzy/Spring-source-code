package mycase.aop.cglib;

import java.lang.reflect.*;

import org.springframework.cglib.proxy.*;

public class CglibProxyFactory implements MethodInterceptor {

	private Class target;

	public CglibProxyFactory(Class target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("调用目标方法了，现在是前置处理");
		// 这里直接调invoke会死循环，因为o是代理对象
		// 内部会获取MethodInterceptor属性继续调用intercept，造成死循环
		Object invoke = methodProxy.invokeSuper(o, objects);
		System.out.println("调用目标方法了，现在是后置处理");
		return invoke;
	}

	public Object getProxyInstance() {
		Enhancer e = new Enhancer();
		e.setSuperclass(target);
		e.setCallback(this);
		return e.create();
	}

	public static void main(String[] args) {
		CglibProxyFactory proxyClass = new CglibProxyFactory(CglibBean.class);
		CglibBean proxyInstance = (CglibBean) proxyClass.getProxyInstance();
		proxyInstance.test();
	}
}
