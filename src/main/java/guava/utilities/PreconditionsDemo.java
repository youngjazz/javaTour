package guava.utilities;

import com.google.common.base.Preconditions;

import java.sql.SQLOutput;

/**
 * Created by leon on 2018-12-13
 */
public class PreconditionsDemo {
    public static void main(String[] args) {
        try {
            sqrt(-3.0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sum(null, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getValue(6);
    }

    public static double sqrt(double input) {
        Preconditions.checkArgument(input > 0.0, "Illegal Argument passed:Negative value s%.", input);
        return Math.sqrt(input);
    }

    public static int sum(Integer a, Integer b) {
        a = Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b, "Illegal Argument passed: First parameter is Null.");

        return a + b;
    }

    public static int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5};
        Preconditions.checkElementIndex(input, data.length, "Illegal Argument passed: Invalid index.");

        return 0;
    }
}
