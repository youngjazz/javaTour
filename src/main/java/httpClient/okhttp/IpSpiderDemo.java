package httpClient.okhttp;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;

/**
 * todo
 *
 * @author leon
 * @since 2018-12-21
 */
public class IpSpiderDemo {
    public static void main(String[] args) {
        String url = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?resource_id=6006&tn=baidu&format=json&ie=utf-8&oe=utf-8&need_di=1&_=1545380510958&query=";
        OkHttpClient okHttpClient = new OkHttpClient();

        String ip = "123.234.34.45";

        Request request = new Request.Builder()
                .url(url + ip)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            System.out.println(JSON.parseObject(execute.body().string()).get("data"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
