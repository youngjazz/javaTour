package concurrency.bookcode.basic;

/**
 * DESCRIPTION：volatile可以保证可见性和有序性，但不能保证原子性
 *
 * @author zhangyang 2017/11/26 22:18
 */
public class VolatileDemo {
	static volatile int i = 0;

	public static class PlusTask implements Runnable{

		@Override
		public void run() {
			for (int k = 0; k < 10000; k++){
				i++;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i =0;i<10;i++) {
			threads[i] = new Thread(new PlusTask());
			threads[i].start();
		}

		for (int i =0;i<10;i++) {
			threads[i].join();
		}

		System.out.println(i);
	}
}
