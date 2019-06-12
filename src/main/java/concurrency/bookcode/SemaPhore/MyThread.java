package concurrency.bookcode.SemaPhore;

/**
 * Created by leon on 2017/6/2.
 */
public class MyThread extends Thread{
    private ListPOOL listPOOL;
    public MyThread(ListPOOL listPOOL){
        super();
        this.listPOOL = listPOOL;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String getStr = listPOOL.get();
            System.out.println(Thread.currentThread().getName()+" 取得值"+getStr);
            listPOOL.put(getStr);
        }
    }
}
