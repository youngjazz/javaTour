package java8;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * description: Lambda与for性能对比
 *
 * @author zhangyang03@imadada.cn
 * @date: 2019-04-24 10:40
 * @modified By:
 */
public class LambdaVsFor {
    static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int size = i * i + i * 2 + 10;
            List<User> users = initUserList(size);

            System.out.println("-------------case " + i + "-----------------------");
            long t1 = System.nanoTime();
            testFor(users);
            long t2 = System.nanoTime();
            testLambda(users);
            long t3 = System.nanoTime();
            testLambdaParallel(users);
            long t4 = System.nanoTime();
            testLambdaFor(users);
            long t5 = System.nanoTime();

            System.out.println("for            " + (t2 - t1) / 1000 + "μs");
            System.out.println("lambdaFor      " + (t5 - t4) / 1000 + "μs");
            System.out.println("lambda         " + (t3 - t2) / 1000 + "μs");
            System.out.println("lambdaParallel " + (t4 - t3) / 1000 + "μs");
        }
    }

    private static void testFor(List<User> users) {
        for (User user : users) {
            user.hashCode();
        }
    }

    private static void testLambda(List<User> users) {
        users.stream().forEach(item -> item.hashCode());
    }

    private static void testLambdaParallel(List<User> users) {
        users.parallelStream().forEach(item -> item.hashCode());
    }

    private static void testLambdaFor(List<User> users) {
        users.forEach(item -> item.hashCode());
    }

    private static List<User> initUserList(int size) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            userList.add(new User(i, "user" + i));
        }

        return userList;
    }

}

@Data
class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}