package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * todo
 *
 * @author leon
 * @since 2019-02-21
 */
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Class.forName("reflect.Robot");
        System.out.println("Class name is "+clazz.getName());

        Method methodGetHello = clazz.getDeclaredMethod("throwHello", String.class);
        Robot robot = (Robot) clazz.newInstance();
        //私有方法需要accessible为true才能访问
        methodGetHello.setAccessible(true);
        Object result = methodGetHello.invoke(robot, "Bob");
        System.out.println("invoke private method throwHello(), result:"+result);

        Method methodSayHi = clazz.getMethod("sayHi", String.class);
        methodSayHi.invoke(robot, "Welcome");

        Field namefiled = clazz.getDeclaredField("name");
        namefiled.setAccessible(true);
        namefiled.set(robot,"Alice");
        methodSayHi.invoke(robot, "Welcome");

        //ExtClassLoader要去加载类的路径
        System.out.println(System.getProperty("java.ext.dirs"));

        //AppClassLoader要去加载类的路径，其中包含了/Users/leon/projects/javaDemo/target/classes
        System.out.println(System.getProperty("java.class.path"));
    }
}
