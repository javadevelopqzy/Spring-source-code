package mycase.bean_factory.scope;

import java.util.*;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.*;

public class ThreadScope implements Scope {

	ThreadLocal<Map> current = new ThreadLocal<>();

	ThreadScopeBean threadScopeBean;

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map map = current.get();
		if (map == null) {
			current.set(map = new HashMap<>());
		} else {
		}
		return threadScopeBean;
	}

	@Override
	public Object remove(String name) {
		return null;
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
