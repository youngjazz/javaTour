package basic.math;

import org.omg.CORBA.ARG_OUT;

import java.math.BigDecimal;

import static java.lang.Float.floatToRawIntBits;

/**
 * @author 张洋
 * @date: 2019-09-10 09:46
 */
public class FloatDoubleTest {
    public static void main(String[] args) {

        double price = DecimalUtil.getPrice(11.01f);
        System.out.println(price);

        price = DecimalUtil.getPrice(11.01F);
        System.out.println(price);

        price = DecimalUtil.getPrice(11.01d);
        System.out.println(price);

        price = DecimalUtil.getPrice(11.01D);
        System.out.println(price);

        Double.valueOf(11.01f);


        System.out.println("======================");
        double priceDouble = (double) 11.01F;
        System.out.println(priceDouble);
        System.out.println(Double.valueOf(11.01f));
        System.out.println(Double.valueOf(11.01));

        System.out.println("======================");
        BigDecimal bigDecimal = new BigDecimal(11.01);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.floatValue());
        System.out.println(bigDecimal.doubleValue());

        System.out.println("======================");
        bigDecimal = new BigDecimal(String.valueOf(11.01));
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.floatValue());
        System.out.println(bigDecimal.doubleValue());

        System.out.println("======================");
        bigDecimal = BigDecimal.valueOf(11.01f);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.floatValue());
        System.out.println(bigDecimal.doubleValue());


        System.out.println("===============222===============");
        System.out.println(Float.floatToIntBits(11.01f));
        System.out.println(Double.doubleToLongBits(11.010000228881836));
        System.out.println(Double.doubleToLongBits(11.01d));

        System.out.println("---------------------------");



    }

    public static String binaryToDecimal64(long n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 63; i >= 0; i--)
            stringBuilder.append(n >>> i & 1);

        return stringBuilder.toString();
    }

    public static long biannary2Decimal(String binStr) {
        Integer sum = 0;
        int len = binStr.length();
        for (int i = 1; i <= len; i++) {
            //第i位 的数字为：
            int dt = Integer.parseInt(binStr.substring(i - 1, i));
            sum += (int) Math.pow(2, len - i) * dt;
        }
        return sum;
    }
}
