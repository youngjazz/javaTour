package concurrent.ProducerAndConsumer3;

import com.lmax.disruptor.EventFactory;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/25 09:50
 */
public class PCDataFactory implements EventFactory<PCData> {
	@Override
	public PCData newInstance() {
		return new PCData();
	}
}
