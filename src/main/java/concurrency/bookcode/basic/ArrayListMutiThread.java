package concurrency.bookcode.basic;


import java.util.ArrayList;

/**
 * DESCRIPTION：并发下的ArrayList
 *
 * @author zhangyang 2017/12/9 21:18
 */
public class ArrayListMutiThread {
	static ArrayList<Integer> al = new ArrayList<Integer>(10);
	
	public static class AddThread implements Runnable{
		
		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				al.add(i);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AddThread());;
		Thread t2 = new Thread(new AddThread());
		
		t2.start();
		t1.start();
		t1.join();
		t2.join();
		
		System.out.println(al.size());
	}
}
