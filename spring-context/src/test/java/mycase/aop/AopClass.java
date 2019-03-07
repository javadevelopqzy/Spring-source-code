package mycase.aop;

import org.aspectj.lang.annotation.*;

@Aspect
public class AopClass {

	@Pointcut("execution(* mycase.aop.*.*.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void before() {
		System.out.println("before");
	}

	@After("pointCut()")
	public void after() {
		System.out.println("after");
	}
}
