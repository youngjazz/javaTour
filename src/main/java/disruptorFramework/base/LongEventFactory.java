package disruptorFramework.base;

import com.lmax.disruptor.EventFactory;

/**
 * 类LongEventFactocry的实现描述：
 * 需要让disruptor 为我们创建事件，我们同时还声明了一个eventFacroty来实例化Event对象
 *
 * @author leon 2017/9/24 09:23
 */
public class LongEventFactory implements EventFactory{
	@Override
	public Object newInstance() {
		return new LongEvent();
	}
}
