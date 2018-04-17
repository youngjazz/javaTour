package designPattern.singleton;

/**
 * 线程不安全的懒汉式单例模式
 * Created by leon on 2017/6/5.
 */
public class Singleton2 {
    private static Singleton2 singleton = null;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(singleton == null){
            //模拟实例化的一些耗时操作
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton2();
        }

        return singleton;
    }
}
