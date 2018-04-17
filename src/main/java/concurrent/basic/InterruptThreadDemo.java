package concurrent.basic;

/**
 * DESCRIPTION：中断线程
 * interrupt只是打中断状态，但这里这个中断不会发生任何作用
 *
 * @author zhangyang 2017/11/19 21:47
 */
public class InterruptThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 =new Thread(){
			@Override
			public void run() {
				while(true){
					System.out.println("111");
					Thread.yield();
				}
			}
		};

		t1.start();
		Thread.sleep(200);
		t1.interrupt();
	}
}
