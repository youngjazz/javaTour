package IO.NIO;

import jdk.jfr.events.SocketReadEvent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION：基于socket的服务端的多线程模式
 *
 * 为每一个客户端连接启用一个线程，这个线程全心全意为这个客户端服务
 * 为了接受客户端连接，服务器还会额外使用一个分发线程
 *
 * @author zhangyang 2018/4/28 09:11
 */
public class MutiThreadEchoServer {
	private static ExecutorService tp = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		ServerSocket echoServer = null;
		Socket clientSocket = null;
		try {
			echoServer = new ServerSocket(8000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (true){
			try {
				clientSocket = echoServer.accept();
				System.out.println(clientSocket.getRemoteSocketAddress()+" connect!");
				tp.execute(new HandleMsg(clientSocket));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class HandleMsg implements Runnable{
		Socket clientSocket;
		
		public HandleMsg(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		@Override
		public void run() {
			BufferedReader is = null;
			PrintWriter os = null;
			
			try {
				is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				os = new PrintWriter(clientSocket.getOutputStream(),true);
				
				//从InputStream当中读取客户端发送的数据
				String inputLine = null;
				long b = System.currentTimeMillis();
				while ((inputLine = is.readLine())!= null){
					os.println(inputLine);
				}
				long e = System.currentTimeMillis();
				System.out.println("spend:"+(e-b)+"ms");
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(is!=null) is.close();
					if(os != null) os.close();
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
