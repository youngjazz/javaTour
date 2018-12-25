package File;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author leon
 * @date 2018/11/12
 */
public class File2Base64 {
    public static void main(String[] args) {
        String path = "/Users/leon/temp/WX20181112-102555@2x.png";
        try {
            String base64Result = encodeFileBase64(path);
            base64Result = base64Result.replaceAll("[\\s*\t\n\r]", "");
            System.out.println(base64Result);
            toFile(base64Result, "/Users/leon/temp/base64ToFile.txt");
            decoderFileBase64(base64Result,"/Users/leon/temp/base64ToFile.png" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * encodeFile to Base64
     * @param path
     * @return
     * @throws IOException
     */
    private static String encodeFileBase64(String path) throws IOException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        fileInputStream.read(buffer);
        fileInputStream.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * base64 to file
     * @param base64Code
     * @param targePath
     * @throws IOException
     */
    private static void toFile(String base64Code, String targePath) throws IOException {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream fileOutputStream = new FileOutputStream(targePath);
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }

    /**
     * decoderFile from Base64
     * @param base64Code
     * @param targePath
     * @throws IOException
     */
    private static void decoderFileBase64(String base64Code, String targePath) throws IOException {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targePath);
        out.write(buffer);
        out.close();
    }
}
