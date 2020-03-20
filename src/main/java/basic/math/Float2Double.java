package basic.math;

import com.alibaba.fastjson.JSON;

/**
 * @author 张洋
 * @date: 2019-09-10 15:38
 */
public class Float2Double {
    public static void main(String[] args) {
        float priceF = 11.01f;
        double priceD = (double) priceF;
        System.out.println(priceD);

        String s = JSON.toJSONString(null);
        System.out.println(s);
    }
}
