package designPattern.singleton;

/**
 * Created by leon on 2017/6/5.
 */
public class TestSingleton1 extends Thread{

    public void run() {
        System.out.println(Singleton6.getInstance().hashCode());
    }

    public static void main(String[] args) {
        TestSingleton1[] threads = new TestSingleton1[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new TestSingleton1();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
