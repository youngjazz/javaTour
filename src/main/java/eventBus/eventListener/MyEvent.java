package eventBus.eventListener;

/**
 *
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/8/17 14:27
 */
public class MyEvent {
	private String key;
	private String msg;

	public MyEvent(String key) {
		this.key = key;
		System.out.println("Event message"+msg);
	}

	public String getMsg(){
		return msg;
	}
}
