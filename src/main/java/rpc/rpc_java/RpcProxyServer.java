package rpc.rpc_java;

import com.google.errorprone.annotations.Var;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author leon
 * @date 2019-03-12
 */
public class RpcProxyServer {
    private IHello hello = new HelloService();

    public void publish(int port){
        try(ServerSocket ss = new ServerSocket(port)) {
            while (true){
                try (Socket socket = ss.accept()){
                    try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                        String method = ois.readUTF();
                        Object[] objs = (Object[]) ois.readObject();
                        Class<?>[] types = new Class[objs.length];
                        for (int i = 0; i < types.length; i++) {
                            types[i] = objs[i].getClass();
                        }

                        Method m = HelloService.class.getMethod(method, types);
                        Object obj = m.invoke(hello, objs);

                        try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())){
                            oos.writeObject(obj);
                            oos.flush();
                        }

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
