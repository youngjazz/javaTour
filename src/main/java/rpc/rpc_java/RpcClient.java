package rpc.rpc_java;

/**
 * @author leon
 * @date 2019-03-12
 */
public class RpcClient {

    //调用服务
    public static void main(String[] args) {
        RpcProxyClient<HelloService> rpcProxyClient = new RpcProxyClient<>();
        IHello iHello = rpcProxyClient.proxyClient(HelloService.class);
        String s = iHello.sayHello("leon");
        System.out.println(s);
    }
}
