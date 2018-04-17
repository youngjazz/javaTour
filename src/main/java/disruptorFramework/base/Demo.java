package disruptorFramework.base;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * 类FirstDemo的实现描述：disruptor并发框架demo
 *
 * @author zhangyang 2017/9/24 09:13
 */
public class Demo {
    public static void main(String[] args) {
		//创建缓冲池
		ExecutorService executor = Executors.newCachedThreadPool();
		//创建工厂
		LongEventFactory factory = new LongEventFactory();
		//创建bufferSize，也就是RingBuffer大小，必须是2的N次方
		int ringBufferSize = 1024 * 1024;
		
		
		
		//创建disruptor
		//ProducerType指定单个还是多个生产者
		//WaitStrategy：指定等待策略，是生产和消费的策略
		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory,ringBufferSize,executor, ProducerType.SINGLE,new YieldingWaitStrategy());

		//连接消费事件方法
		disruptor.handleEventsWith(new LongEventHandler());

		//启动
		disruptor.start();

		//Disruptor的事件发布是一个两阶段提交的过程
		//使用该方法获取具体存放数据的容器RingBuffer（环形结构）

		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

		LongEventProducer producer = new LongEventProducer(ringBuffer);

		ByteBuffer byteBuffer = ByteBuffer.allocate(8);
		for (long l = 0; l<1000;l++){
			byteBuffer.putLong(0,l);
			producer.onData(byteBuffer);
		}

		disruptor.shutdown();//关闭 disruptor,方法会阻塞，直到所有的时间得到处理
		executor.shutdown();//关闭disruptor使用的线程池；如果需要的话，必须手动关闭，disruptor在shutdown时不会自动关闭；

	}

}
