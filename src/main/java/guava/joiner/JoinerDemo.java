package guava.joiner;

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * @author leon
 * @date 2018/10/10
 */
public class JoinerDemo {
    public static void main(String[] args) {
        String join = Joiner.on(',').skipNulls().join(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        System.out.println(join);
    }
}
