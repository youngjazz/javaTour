package disruptorFramework.base;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * 类LongEventProducer的实现描述：
 *
 * @author leon 2017/9/24 18:49
 */
public class LongEventProducer {
	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	/**
	 * onData用来发布事件，每调用一次就发布一次事件
	 * 它的参数会用过事件传递给消费者
	 * @param bb
	 */
	public void onData(ByteBuffer bb){

		//1.可以吧ringbuffer看做一个事件队列，那么next就是得到下面一个事件槽
		long sequence = ringBuffer.next();
		try {
			//2.用上面的索引取出一个空的事件用于填充（获取该序号对应的事件对象）
			LongEvent event = ringBuffer.get(sequence);
			//3. 获取要通过事件传递的业务数据
			event.setValue(bb.getLong(0));
		} finally {
			//4.发布事件
			//注意，包含在finnally中确保一定调用（如果某个请求的sequence未被提交，将会阻塞后续的发布操作获取其他producer）
			ringBuffer.publish(sequence);
		}

	}
}
