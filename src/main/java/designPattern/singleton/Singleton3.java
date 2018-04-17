package designPattern.singleton;

/**
 * 粗粒度线程安全 懒汉式单例模式
 * Created by leon on 2017/6/5.
 */
public class Singleton3 {
    private static Singleton3 singleton = null;

    private Singleton3(){}

    public synchronized static Singleton3 getInstance(){
        if(singleton == null){
            //模拟实例化的一些耗时操作
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton3();
        }

        return singleton;
    }
}
