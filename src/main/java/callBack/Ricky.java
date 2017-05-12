package callBack;

/**
 * Created by leon on 2017/4/16.
 */
public class Ricky implements Student{

    public void resolveQuestion(CallBack callBack) {
        //模拟解决问题
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //回调，告诉老师答案
        callBack.tellAnswer("啊哈哈哈");
    }
}
