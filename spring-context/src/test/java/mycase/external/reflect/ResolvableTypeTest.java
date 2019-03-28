package mycase.external.reflect;

import java.util.*;

import org.springframework.core.*;

public class ResolvableTypeTest {

	public HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws NoSuchFieldException {
		// 获取类的属性，并包装到ResolvableType中
		ResolvableType resolvableType = ResolvableType.forField(ResolvableTypeTest.class.getField("map"));
		// 获取属性的父类
		System.out.println("map属性的父类是：" + resolvableType.getSuperType());
		// 转换为map类型，如果没有实现Map则会返回null
		System.out.println(resolvableType.asMap().getRawClass());
		// 获取到第一个泛型
		System.out.println("第一个泛型是：" + resolvableType.getGeneric(0));
		// 获取到第二个泛型
		System.out.println("第二个泛型是：" + resolvableType.getGeneric(1));
		// 获取所有的泛型
		System.out.println(resolvableType.getGenerics());
		// 解析出泛型实际的类型
		System.out.println(resolvableType.resolveGeneric(1));
	}
}
