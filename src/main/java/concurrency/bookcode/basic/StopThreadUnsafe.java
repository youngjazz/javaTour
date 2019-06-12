package concurrency.bookcode.basic;

/**
 * DESCRIPTION：终止线程
 * stop（暴力终止）的使用， 导致数据不一致
 *
 * 而如果真的想停止线程，最好写个stopme方法，改变flag值，对于run（）{while（flag）{
 *     break；
 * }}
 *
 * @author zhangyang 2017/11/19 21:51
 */
public class StopThreadUnsafe {
	public static User u = new User();
	public static class User{
		private int age;
		private String name;

		public User() {
			this.age = 0;
			this.name = "0";
		}

		@Override
		public String toString() {
			return "User{" +
					"age=" + age +
					", name='" + name + '\'' +
					'}';
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static class changeObjectThread extends Thread{
		@Override
		public void run() {
			while(true){
				synchronized (u){
					int v = (int)(System.currentTimeMillis()/1000);
					u.setAge(v);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					u.setName(String.valueOf(v));
				}
				Thread.yield();
			}
		}
	}

	public static class ReadObjectThread extends Thread{
		@Override
		public void run() {
			while(true){
				synchronized (u){
					if(u.getAge() != Integer.parseInt(u.getName())){
						System.out.println(u.toString());
					}
				}
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ReadObjectThread().start();
		while(true){
			Thread t = new changeObjectThread();
			t.start();
			Thread.sleep(201);
			t.stop();
		}
	}
}
