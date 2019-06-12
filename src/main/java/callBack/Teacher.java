package callBack;

/**
 * Created by leon on 2017/4/16.
 */
public class Teacher implements CallBack {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion(){
        student.resolveQuestion(this);
    }

    public void tellAnswer(String answer) {
        System.out.println("知道了，你的答案是："+answer);
    }

    public String test(String s){
        return s;
    }
}
