package designPattern.singleton;

/**
 * 线程安全的饿汉单例模式
 * Created by leon on 2017/6/5.
 */
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return singleton;
    }
}
