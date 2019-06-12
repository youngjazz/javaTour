package concurrency.bookcode.Singleton;

/**
 * Created by leon on 2017/7/25.
 */
public class DoubleCheckSingleton {
    private static  DoubleCheckSingleton ds;

    private DoubleCheckSingleton() {}


    public static DoubleCheckSingleton getDs(){
        if(ds == null){
            try {
                //模拟初始化对象准备时间
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (DoubleCheckSingleton.class){
                if(ds == null){
                    ds = new DoubleCheckSingleton();
                }
            }
        }

        return ds;
    }

}
