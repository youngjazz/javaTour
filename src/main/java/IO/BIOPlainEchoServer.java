package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leon
 * @date 2019-03-26
 */
public class BIOPlainEchoServer {
    public void improvedServer(int port) throws IOException {
        //将serverSocket绑定到指定的端口
        final ServerSocket socket = new ServerSocket(port);
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        while (true){
            //阻塞直到接收到新的客户端连接
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection from :"+clientSocket);

            //将请求提交给线程池去执行
            executorService.execute(()->{
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                    //从客户端读取数据并原封不动回写回去
                    while (true){
                        writer.println(reader.readLine());
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
