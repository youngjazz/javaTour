package proxy.dynamic2;

import java.lang.reflect.Proxy;

/**
 * DESCRIPTION：调用测试
 *
 * @author zhangyang 2018/2/28 16:31
 */
public class Test {
    public static void main(String[] args) {
        //具体实现类对象
        BusinessImpl business = new BusinessImpl();

        //生成代理对象,利用proxy 的静态方法Proxy.newProxyInstance()来为一组接口动态的生成代理类及对象
        BusinessInterface proxy = (BusinessInterface) Proxy.newProxyInstance(business.getClass().getClassLoader(), business.getClass().getInterfaces(),
                new BusinessHandler(business));
	
	    proxy.doSomeWork(); //调用代理类的对象
    }
}
