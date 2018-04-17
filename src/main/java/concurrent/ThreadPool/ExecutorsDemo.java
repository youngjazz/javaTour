package concurrent.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyang on 2017/9/5.
 */
public class ExecutorsDemo {

	public static void main(String[] args) {

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
		Temp command = new Temp();
		ScheduledFuture<?> scheduledFuture = scheduledThreadPool.scheduleAtFixedRate(command, 3, 1, TimeUnit.SECONDS);
		try {
			Thread.sleep(20000);
			scheduledThreadPool.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class Temp extends Thread{
	@Override
	public void run() {
		System.out.println("run");
	}
}