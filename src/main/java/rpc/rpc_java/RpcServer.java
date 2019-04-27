package rpc.rpc_java;

/**
 * @author leon
 * @date 2019-03-12
 */
public class RpcServer {

    //发布服务
    public static void main(String[] args) {
        RpcProxyServer server = new RpcProxyServer();
        System.out.println("start rpc server ... ");
        server.publish(8000);
    }
}
