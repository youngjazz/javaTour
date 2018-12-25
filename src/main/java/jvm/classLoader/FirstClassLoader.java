package jvm.classLoader;

/**
 *
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/9/17 17:36
 */
public class FirstClassLoader {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
		System.out.println(parent);
		System.out.println(parent.getParent());
	}
}
