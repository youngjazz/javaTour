package concurrency.bookcode.basic;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/23 22:22
 */
public class JoinMain {

	public volatile static int i = 0 ;

	public static class AddThread extends Thread{
		@Override
		public void run() {
			for(i=0;i<10000000;i++);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		AddThread at = new AddThread();
		at.setName("zy");
		at.start();
		at.join();
		System.out.println(i);
	}
}
