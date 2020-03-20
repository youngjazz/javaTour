package serialize;

import lombok.Data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/**从执行结果来看：
 * java序列化后的流比ByteBuffer实现的二进制编码完成的二进制数组搭上好几倍
 * java序列化编码耗时也要比ByteBuffer长很多
 *
 * FastJson、Kryo、Protobuf、Hessian
 *
 * 极客时间版权所有: https://time.geekbang.org/column/article/99774
 * @author 张洋
 * @date: 2019-09-23 09:43
 */
public class SerializaPerformance {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("test");
        user.setPassword("pwd");
        int counter = 10000;

        //java序列化性能
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(os);
            out.writeObject(user);
            out.flush();
            out.close();
            byte[] testByte = os.toByteArray();
            if (i == 0) {
                System.out.println("ObjectOutputStream 字节编码长度：" + testByte.length);
            }
            os.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ObjectOutputStream 序列化时间：" + (endTime - startTime));

        //NIO中ByteBuffer编码性能
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < counter; i++) {
            ByteBuffer bf = ByteBuffer.allocate(2048);
            byte[] userName = user.getName().getBytes();
            byte[] password = user.getPassword().getBytes();
            bf.putInt(userName.length);
            bf.put(userName);
            bf.putInt(password.length);
            bf.put(password);

            bf.flip();
            byte[] bytes = new byte[bf.remaining()];
            if (i == 0) {
                System.out.println("ByteBuffer 字节编码长度：" + bytes.length);
            }
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("ByteBuffer 序列化时间：" + (endTime2 - startTime2));
    }
}

@Data
class User implements Serializable {
    private String name;
    private String password;
}
