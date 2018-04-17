package JDK;

/**
 * Created by leon on 2017/7/31.
 */
public class StringFormatDemo {
    public static void main(String[] args) {
        String ip = "192.168.0.1";

        String[] ipArr = ip.split("\\.");
        String ip1 = ipArr[0];
        String ip2 = ipArr[1];
        String ip3 = ipArr[2];
        String ip4 = ipArr[3];

        System.out.println(String.format("%03d",ip4));
    }
}
