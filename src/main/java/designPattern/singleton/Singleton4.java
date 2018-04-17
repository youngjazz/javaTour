package designPattern.singleton;

/**
 * 线程不安全 懒汉式单例模式
 * Created by leon on 2017/6/5.
 */
public class Singleton4 {
    private static Singleton4 singleton = null;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if(singleton == null){
            //模拟实例化的一些耗时操作
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton4.class){
                singleton = new Singleton4();
            }
        }

        return singleton;
    }
}
