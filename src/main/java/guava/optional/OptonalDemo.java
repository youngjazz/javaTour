package guava.optional;


import com.google.common.base.Optional;

/**
 * Created by leon on 2018-12-13
 */
public class OptonalDemo {
    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        Optional<Integer> a = Optional.fromNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(sum(a, b));
    }

    private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("First paramter is present:" + a.isPresent());
        System.out.println("Second paramter is present:" + b.isPresent());

        Integer v1 = a.or(0);
        Integer v2 = b.get();

        return v1 + v2;
    }
}
