package rpc.rpc_netty.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import rpc.rpc_netty.consumer.ClientBootstrap;
import rpc.rpc_netty.provider.HelloServiceImpl;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/27 15:49
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//如何符合约定，则调用本地方法，返回数据
		if(msg.toString().startsWith(ClientBootstrap.providerName)){
			String result = new HelloServiceImpl()
				.hello(msg.toString().substring(msg.toString().lastIndexOf("#")+1));
			ctx.writeAndFlush(result);
		}
	}
}
