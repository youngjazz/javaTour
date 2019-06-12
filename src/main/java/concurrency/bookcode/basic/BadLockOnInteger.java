package concurrency.bookcode.basic;


import org.junit.Test;

/**
 * DESCRIPTION：错误的加锁
 *
 * 之所以会出问题，是因为多个线程间，并不能够看到同一个对象（因为count对象一直在变）
 * 因此两个线程每次加锁可能都加在不同的对象实例上，从而导致对临界区代码的控制出了问题
 * synchronized (count)给为synchronized (instance)即可
 * @author zhangyang 2017/12/10 09:52
 */
public class BadLockOnInteger implements Runnable {
	
	public static Integer count = 0;
	static BadLockOnInteger instance = new BadLockOnInteger();
	
	@Override
	public void run() {
		for (int i1 = 0; i1 < 10000000; i1++) {
			synchronized (count){
				count++;
			}
		}
	}
	
	@Test
	public void test1() throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(count);
	}
	
	@Test
	public void test2() throws InterruptedException {
		Thread t1 = new Thread(new BadLockOnInteger());
		Thread t2 = new Thread(new BadLockOnInteger());
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(count);
	}
}
