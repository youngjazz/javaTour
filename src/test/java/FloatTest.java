import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author 张洋
 * @date: 2019-08-14 16:39
 */
public class FloatTest {
    @Test
    public void testModify() {
        checkPositiveDecimalPrecision(30.001f, 2);
        checkPositiveDecimalPrecision(30.000001f, 2);
        checkPositiveDecimalPrecision(30.02521f, 2);
        checkPositiveDecimalPrecision(30.99f, 2);
        checkPositiveDecimalPrecision(30.01f, 2);
        checkPositiveDecimalPrecision(30.33f, 2);
        checkPositiveDecimalPrecision(30.3f, 2);
        checkPositiveDecimalPrecision(30f, 2);
        checkPositiveDecimalPrecision(3f, 2);
        checkPositiveDecimalPrecision(0f, 2);
    }

    public static void checkPositiveDecimalPrecision(float originalNumber, int expectedPrecision) {
        System.out.println("==========================");
        System.out.println("输入" + originalNumber);

        if (originalNumber < 0) {
            System.out.println("Oops");
            return;
        }
        String str = String.valueOf(originalNumber);
        if (str.indexOf(".") > 0) {
            String s = str.split("\\.")[1];
            if (s.length() > expectedPrecision) {
                System.out.println("Oops");
                return;
            }
        }

        System.out.println("成功");

    }

    @Test
    public void split(){
        String s1 = "1#2";
        String s2 = "1#";
        String s3 = "#2";
        String s4 = "#";

        System.out.println(s1.split("#",2).length);
        System.out.println(s2.split("#",2).length);
        System.out.println(s3.split("#",2).length);
        System.out.println(s4.split("#",2).length);
    }

}
