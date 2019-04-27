package rpc.rpc_netty.provider;

import rpc.rpc_netty.netty.NettyServer;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/27 16:31
 */
public class ServerBootstrap {
	public static void main(String[] args) {
		NettyServer.startServer("localhost",8088);
	}
}
