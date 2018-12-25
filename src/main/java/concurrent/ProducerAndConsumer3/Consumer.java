package concurrent.ProducerAndConsumer3;

import com.lmax.disruptor.WorkHandler;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/24 09:16
 */
public class Consumer  implements WorkHandler<PCData> {
	
	@Override
	public void onEvent(PCData event) throws Exception {
		System.out.println(Thread.currentThread().getId() + ":Event: --"+event.get()*event.get() + "--");
	}
	
	
}
