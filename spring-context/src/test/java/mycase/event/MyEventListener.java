package mycase.event;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.*;

public class MyEventListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(@NotNull ApplicationEvent event) {
		if (event instanceof MyEvent) {
			System.out.println("收到消息：" + ((MyEvent) event).getMsg());
			System.out.println("收到对象：" + event.getSource());
		}
	}

}
