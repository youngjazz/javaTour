package proxy.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DESCRIPTION：动态代理类
 *
 * @author zhangyang 2018/2/28 16:28
 */
public class BusinessHandler implements InvocationHandler {

    private BusinessInterface businessInterface;

    public BusinessHandler(BusinessInterface businessInterface) {
        this.businessInterface = businessInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 处理业务逻辑");
        method.invoke(businessInterface, args);
        System.out.println("after 处理业务逻辑");
        return null;
    }
}
