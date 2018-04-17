package concurrent.Singleton;


/**
 * 静态内部类实现单例模式
 * Created by leon on 2017/7/25.
 */
public class InnerClassSingleton {

    private static class InnerClass{
        private static InnerClass single = new InnerClass();
    }

    public static InnerClass getInstance(){
        return InnerClass.single;
    }
}
