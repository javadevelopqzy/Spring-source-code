package mycase.lifecycle;

import org.springframework.context.*;

public class LifeCycleImpl implements SmartLifecycle {

	@Override
	public void start() {
		System.out.println("容器启动了");
	}

	@Override
	public void stop() {
		System.out.println("容器关闭了");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
