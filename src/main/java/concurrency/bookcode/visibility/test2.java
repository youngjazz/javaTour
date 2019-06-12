package concurrency.bookcode.visibility;

/**
 * Created by leon on 2017/8/10.
 */
public class test2 {
    static User q = new User(0);
    static User p = q;
    static User r1,r3,r6;

    static int r2,r4,r5;



    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r1 = p;
                r2 = r1.x;
                r3 = q;
                r4 = r3.x;
                r5 = r1.x;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                r6 = p;
                r6.x = 3;
            }
        });
        t1.start();
        t2.start();
    }
}

class User{
    int x;

    public User(int x) {
        this.x = x;
    }
}