package socket.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * description:
 *
 * @author 张洋
 * @date: 2019-06-12 20:06
 */
public class MultiCastClient2 {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.5.6.7");

            try {
                MulticastSocket socket = new MulticastSocket(8888);

                socket.joinGroup(group);
                byte[] buf = new byte[256];
                while (true) {
                    DatagramPacket messagePackage = new DatagramPacket(buf, buf.length);
                    socket.receive(messagePackage);

                    String msg = new String(messagePackage.getData());
                    System.out.println("接收到数据" + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
