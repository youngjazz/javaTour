package designPattern.singleton;

/**
 * Double Check Locking 懒汉式单例模式
 * Created by leon on 2017/6/5.
 */
public class Singleton5 {
    private static Singleton5 singleton = null;

    private Singleton5(){}

    public static Singleton5 getInstance(){
        if(singleton == null){
            //模拟实例化的一些耗时操作
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton5.class){
                //double check
                if(singleton == null){
                    singleton = new Singleton5();
                }
            }
        }

        return singleton;
    }
}
