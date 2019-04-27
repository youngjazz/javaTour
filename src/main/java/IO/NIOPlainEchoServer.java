package IO;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author leon
 * @date 2019-03-26
 */
public class NIOPlainEchoServer {
    public void server(int port) throws IOException {
        System.out.println("Listen for connnections on port:" + port);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        //将serversocket绑定到指定的端口里
        serverSocket.bind(address);

        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //将channel注册到selector里, 并说明让Selector关注的点, 这里是关注建立连接的这个事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            try {
                //阻塞等待就绪的channel, 没有雨客户端建立连接就一直轮询
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            //获取到selector里面所有就绪的selectedKey实例, 每将一个channel注册到一个selector就会产生一个SelectedKey
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //将就绪的SelectedKey从Selector中移除, 因为马上要处理让,防止重复执行
                iterator.remove();

                try {
                    if(key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        //接受客户端的连接
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from "+client);
                        client.configureBlocking(false);
                        //向select注册socketchannel, 主要关注读写,并传入一个ByteBuffer实例供读写缓存
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(100));
                    }
                    if(key.isReadable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        //将ByteBuffer里的数据写入channel里
                        client.write(output);
                        output.compact();
                    }
                } catch (IOException e) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException e1) {

                    }
                }
            }
        }
    }
}
