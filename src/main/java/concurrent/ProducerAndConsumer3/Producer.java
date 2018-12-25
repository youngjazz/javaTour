package concurrent.ProducerAndConsumer3;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DESCRIPTION：
 *
 * @author zhangyang 2018/4/24 09:06
 */
public class Producer  {
	private final RingBuffer<PCData> ringBuffer;
	
	public Producer(RingBuffer<PCData> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void pushData(ByteBuffer bb){
		long sequence = ringBuffer.next();
		try {
			PCData event = ringBuffer.get(sequence);
			event.set(bb.getLong(0));
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
