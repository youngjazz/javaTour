package concurrent.SemaPhore;

/**
 * Created by leon on 2017/6/9.
 */
public class ThreadC extends Thread{
    private RepastService service;

    public ThreadC(RepastService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.get();
    }
}
