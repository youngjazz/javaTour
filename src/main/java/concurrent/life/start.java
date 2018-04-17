package concurrent.life;

/**
 * Created by leon on 2017/8/13.
 */
public class start {
    public static void main(String[] args) {

        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("t1 is running");
            }
        };

        thread.setName("t1");
        thread.start();

        System.out.println(thread.getState());
    }
}
