package concurrency.bookcode.SemaPhore;

/**
 * Created by leon on 2017/6/9.
 */
public class ThreadP extends Thread{
    private RepastService service;

    public ThreadP(RepastService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.set();
    }
}
