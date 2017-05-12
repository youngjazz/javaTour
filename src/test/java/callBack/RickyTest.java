package callBack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by leon on 2017/4/16.
 */
public class RickyTest {

    @Test
    public void testCallBack(){
        Student student = new Ricky();
        Teacher teacher = new Teacher(student);
        System.out.println("老师开始问问题");
        teacher.askQuestion();
        System.out.println("老师问完问题");
    }
}