package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * description:
 *
 * @author 张洋
 * @date: 2019-06-12 19:14
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        try {
            socket = new Socket("localhost",8888);
             //reader data from server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //write data to server
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Hello Marry");
            while (true){
                String serverData = reader.readLine();
                if (serverData == null){
                    break;
                }
                System.out.println("客户端收到数据："+serverData);
            }
            writer.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket != null){
                socket.close();
            }
        }
    }
}
