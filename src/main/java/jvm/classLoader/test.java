package jvm.classLoader;

import org.junit.Test;
import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;

/**
 *
 * DESCRIPTION：
 *
 * @author zhangyang 2018/9/17 15:06
 */
public class test {
	//bootstrapClassLoader
	@Test
	public void test(){
		URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
		Arrays.stream(urLs).forEach(System.out::println);
	}


	//ExtClassloader path
	@Test
	public void extTest(){
		System.out.println(System.getProperty("java.ext.dirs"));
	}

	//appClassLoader
	@Test
	public void appClassLoaderTest(){
		Arrays.stream(System.getProperty("java.class.path").split(":")).forEach(System.out::println);
	}
}
