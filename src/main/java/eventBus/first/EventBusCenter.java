package eventBus.first;

import com.google.common.eventbus.EventBus;

/**
 *
 * DESCRIPTION：
 *
 * @author zhangyang 2018/8/17 10:53
 */
public class EventBusCenter {
	private static EventBus eventBus = new EventBus();

	private EventBusCenter(){

	}

	public static EventBus getInstance(){
		return eventBus;
	}

	public static void register(Object object){
		eventBus.register(object);
	}

	public static void unRegister(Object object){
		eventBus.unregister(object);
	}

	public static void post(Object object){
		eventBus.post(object);
	}
}
