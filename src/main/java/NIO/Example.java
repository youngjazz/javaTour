package NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author leon
 * @date 2019-03-18
 */
public class Example {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/Users/leon/temp/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        /**
         * Basic Buffer Usage
         *
         * Using a Buffer to read and write data typically follows this little 4-step process:
         *
         * 1.Write data into the Buffer
         * 2.Call buffer.flip()
         * 3.Read data out of the Buffer
         * 4.Call buffer.clear() or buffer.compact()
         */

        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read" + bytesRead);
            buf.flip();

            while (buf.hasRemaining()){
//                System.out.println((char) buf.get());
                System.out.println(buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }



        aFile.close();
    }
}
