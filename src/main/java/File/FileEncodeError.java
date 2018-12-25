package File;

/**
 * Created by leon on 2018-12-06
 */
public class FileEncodeError {

    public static boolean equals(Object object1, Object object2) {
        if (object1 == object2) {
            return true;
        }
        if ((object1 == null) || (object2 == null)) {
            return false;
        }
        return object1.equals(object2);
    }

    public static void main(String[] args) {
        String str = new String("测试");
        String str2 = new String("测试");
        System.out.println(equals(str, str2));

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
