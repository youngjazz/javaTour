package concurrent.SemaPhore;

/**
 * Created by leon on 2017/6/2.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {

/*      ListPOOL pool = new ListPOOL();
        MyThread[] threads = new MyThread[12];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new MyThread(pool);
        }
        for (int i=0;i<threads.length;i++){
            threads[i].start();
        }*/


        //使用Semaphore实现多生产者/多消费者模式
        RepastService service = new RepastService();
        ThreadP[] arrayP = new ThreadP[60];
        ThreadC[] arrayC = new ThreadC[60];
        for (int i = 0; i < 60; i++) {
            arrayP[i] = new ThreadP(service);
            arrayC[i] = new ThreadC(service);
        }

        Thread.sleep(2000);
        for (int i = 0; i < 60; i++) {
            arrayP[i].start();
            arrayC[i].start();
        }
    }
}
