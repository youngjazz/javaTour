package concurrent.basic;

/**
 * DESCRIPTION：
 * 实际这里的break才是真正中断代码
 *
 * @author zhangyang 2017/11/19 23:12
 */
public class InterruptThreadDemo2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 =new Thread(){
			@Override
			public void run() {

				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interrupted");
						break;
					}
					Thread.yield();
				}
			}
		};

		t1.start();
		Thread.sleep(200);
		t1.interrupt();
	}

}
