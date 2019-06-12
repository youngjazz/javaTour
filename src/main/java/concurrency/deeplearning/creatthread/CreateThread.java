package concurrency.deeplearning.creatthread;

/**
 * description:
 * 线程构造函数参数什么意思?
 * 线程的生命周期,创建一个线程实际有多少个线程产生?
 *
 *
 * @author 张洋
 * @date: 2019-05-14 23:57
 */
public class CreateThread {
    public static void main(String[] args) {
        Thread thread = new Thread("test");
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }
}
