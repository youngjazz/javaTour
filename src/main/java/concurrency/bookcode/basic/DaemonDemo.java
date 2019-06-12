package concurrency.bookcode.basic;

/**
 * DESCRIPTION：守护线程
 *
 * t.setDaemon(true);将线程t设置为守护线程，必须在调用start（）之前，否则就会被当成一个用户线程，这里就永远停不下来了
 *
 * @author zhangyang 2017/12/3 20:23
 */
public class DaemonDemo {
	public static class DaemonT extends Thread{
		@Override
		public void run() {
			while(true){
				System.out.println("I'am alive");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new DaemonT();
		t.setDaemon(true);
		t.start();

		Thread.sleep(2000);
	}
}
