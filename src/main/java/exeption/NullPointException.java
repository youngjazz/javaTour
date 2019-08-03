package exeption;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 张洋
 * @date: 2019-07-25 18:11
 */
@Slf4j
public class NullPointException {
    public static void main(String[] args) {
        int max_error_times = 5800; //5686就不会打印堆栈信息
        for (int i = 1; i <= max_error_times; i++) {
            try {
                npe();
            } catch (NullPointerException e) {
                if(i == max_error_times){
                    log.error("npe, {}", i, e);
                }
            }
        }
    }

    public static void npe() {
        String s = null;
        System.out.println(s.length());
    }
}
