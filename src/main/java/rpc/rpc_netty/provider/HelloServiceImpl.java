package rpc.rpc_netty.provider;

import rpc.publicInterface.HelloService;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/27 15:30
 */
public class HelloServiceImpl implements HelloService {
	
	@Override
	public String hello(String msg) {
		return msg != null ? msg + "-------------> I am fine." : "I am fine.";
	}
}
