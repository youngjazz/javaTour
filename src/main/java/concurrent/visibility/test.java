package concurrent.visibility;

/**
 * Created by leon on 2017/8/10.
 */
public class test {

    static int r1 = 0;
    static int r2 = 0;
    static int A = 0;
    static int B = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                B = 1;
                r2= A;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                A = 2;
                r1 = B;
            }
        });

        t1.start();
        t2.start();

        System.out.println(r1);
        System.out.println(r2);
    }
}
