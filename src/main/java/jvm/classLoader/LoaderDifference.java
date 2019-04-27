package jvm.classLoader;

import jvm.reflect.Robot;

/**
 * Class.forName()与ClassLoader.load()的区别
 */
public class LoaderDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        //会输出Hello Robot
        Class.forName("jvm.reflect.Robot");
        System.out.println("-----------------------");

        //不会输出Hello Robot
        ClassLoader classloader =  Robot.class.getClassLoader();
        classloader.loadClass("jvm.reflect.Robot");

        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
