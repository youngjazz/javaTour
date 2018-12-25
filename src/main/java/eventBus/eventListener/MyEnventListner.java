package eventBus.eventListener;

/**
 *
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/8/17 14:29
 */
public class MyEnventListner {
	private String lastestMsg = "";

	public void listen(MyEvent event){
		lastestMsg = event.getMsg();
		System.out.println("Message:"+lastestMsg);
	}

	public String getLastestMsg() {
		return lastestMsg;
	}
}
