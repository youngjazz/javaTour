package rpc.rpc_java;

/**
 * @author leon
 * @date 2019-03-12
 */
public class HelloService implements IHello {
    @Override
    public String sayHello(String info) {
        String result = "hello:" + info;
        System.out.println(result);

        return result;
    }
}
