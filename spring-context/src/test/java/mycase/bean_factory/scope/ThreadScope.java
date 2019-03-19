package mycase.bean_factory.scope;

import java.util.*;

import org.jetbrains.annotations.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.*;

public class ThreadScope implements Scope {

	private ThreadLocal<Map<String, Object>> current = new ThreadLocal<>();

	@NotNull
	@Override
	public Object get(@NotNull String name, @NotNull ObjectFactory<?> objectFactory) {
		Map<String, Object> map = current.get();
		System.out.println(Thread.currentThread().getName() + "获取bean，map=" + map);
		Object bean;
		if (map == null) {
			map = new HashMap<>();
			bean = objectFactory.getObject();
			map.put(name, bean);
			current.set(map);
		} else {
			bean = map.get(name);
		}
		return bean;
	}

	@Override
	public Object remove(String name) {
		return current.get().remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {

	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return null;
	}
}
