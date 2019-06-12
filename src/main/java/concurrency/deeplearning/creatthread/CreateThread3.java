package concurrency.deeplearning.creatthread;

/**
 * description: 创建线程, 关注线程栈空间
 *
 * @author 张洋
 * @date: 2019-05-13 23:51
 * @modified By:
 */
public class CreateThread3 {
    public static void main(String[] args) {
        Thread t = new Thread(null, new Runnable() {
            int counter = 0;

            @Override
            public void run() {
                try {
                    add(0);
                } catch (Error e) {
                    System.out.println(counter);
//                    e.printStackTrace();
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        },"test", 1<<24);

        t.start();
    }
}
