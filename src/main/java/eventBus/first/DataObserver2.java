package eventBus.first;

import com.google.common.eventbus.Subscribe;

/**
 *
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/8/17 11:14
 */
public class DataObserver2 {

	@Subscribe
	public void func(Integer msg){
		System.out.println(msg);
	}
}
