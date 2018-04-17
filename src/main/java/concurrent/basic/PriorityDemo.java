package concurrent.basic;

import com.sun.tools.internal.xjc.reader.xmlschema.BindRed;

import java.io.BufferedReader;

/**
 * DESCRIPTION：线程优先级
 * 线程的优先级并不能保证优先级高的一定先执行
 *
 * @author zhangyang 2017/12/3 20:35
 */
public class PriorityDemo {

	static int maxCount = 10000000;

	public static class HighPriority extends Thread{
		static int count = 0;

		@Override
		public void run() {
			while(true){
				synchronized (PriorityDemo.class){
					count++;
					if(count > maxCount){
						System.out.println("HeighPriority is complete");
						break;
					}
				}
			}
		}
	}

	public static class LowPriority extends Thread{
		static int count = 0;

		@Override
		public void run() {
			while (true){
				synchronized (PriorityDemo.class){
					count++;
					if(count > maxCount){
						System.out.println("LowPriority is complete");
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread high = new HighPriority();
		Thread low = new LowPriority();

		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);

		high.start();
		low.start();
	}
}
