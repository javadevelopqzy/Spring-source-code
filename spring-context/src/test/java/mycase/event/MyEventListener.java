package mycase.event;

import org.springframework.context.*;

public class MyEventListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof MyEvent) {
			System.out.println(((MyEvent) event).getMsg());
		}
	}

}
