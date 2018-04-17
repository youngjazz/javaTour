package proxy.cglibDemo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * DESCRIPTION：实现MethodInterceptor接口生成的方法拦截器
 *
 * @author zhangyang 2018/2/28 16:57
 */
public class HelloMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("before "+method.getName());
		methodProxy.invokeSuper(o,objects);
		System.out.println("after "+method.getName());
		return null;
	}
}
