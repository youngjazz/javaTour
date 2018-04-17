package concurrent.basic;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/26 22:27
 */
public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread{
		@Override
		public void run() {
			while (!ready);
			System.out.println(number);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread reader = new ReaderThread();
		reader.setName("readerThread");
		reader.start();

		Thread.sleep(1000);
		number = 42;
		ready = true;
		Thread.sleep(3000);
	}
}
