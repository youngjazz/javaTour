package proxy.cglibDemo;

import net.sf.cglib.proxy.Enhancer;

/**
 * DESCRIPTION：客户端验证
 *
 * @author zhangyang 2018/2/28 16:58
 */
public class Client {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Hello.class); //继承被代理类
		enhancer.setCallback(new HelloMethodInterceptor()); //设置回调
		Hello proxy = (Hello) enhancer.create();//生成代理类对象
		proxy.sayHello();
	}
}
