package rpc.rpc_netty.netty;

import java.util.concurrent.Callable;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/27 16:04
 */
public class ClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context;

    private String                result;

    private String                para;
	
	/**
	 * 与服务器的连接已经建立之后将被调用
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		context = ctx;
	}
	
	/**
	 * 收到服务端数据，唤醒等待线程
	 * @param ctx
	 * @param msg
	 * @throws Exception
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		result = msg.toString();
		notify();
	}
	
	/**
	 * 写出数据，开始等待唤醒
	 * @return
	 * @throws Exception
	 */
	@Override
    public Object call() throws Exception {
		context.writeAndFlush(para);
		wait();
		return result;
    }
    
    void  setPara(String para){
		this.para = para;
    }
}

