package eventBus.first;

import com.google.common.eventbus.Subscribe;

/**
 *
 * DESCRIPTION：
 *
 * @author zhangyang 2018/8/17 11:06
 */
public class DataObserver1 {

	@Subscribe
	public void func(String msg){
		System.out.println("String msg:"+ msg);
	}
}
