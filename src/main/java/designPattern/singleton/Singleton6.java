package designPattern.singleton;

/**
 * 静态内部类实现 单例模式
 * Created by leon on 2017/6/5.
 */
public class Singleton6 {

    private Singleton6(){}

    public static Singleton6 getInstance(){

        return SingletonHander.singleton;
    }

    private static class SingletonHander{
        private static Singleton6 singleton = new Singleton6();
    }
}
