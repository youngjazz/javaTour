package disruptorFramework.base;


import com.lmax.disruptor.EventHandler;

/**
 * 类LongEventHandler的实现描述：TODO
 *
 * @author leon 2017/9/24 09:49
 */
public class LongEventHandler implements EventHandler<LongEvent> {

	@Override
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println(event.getValue());
	}
}
