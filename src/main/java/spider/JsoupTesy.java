package spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by leon on 2017/7/6.
 */
public class JsoupTesy {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://en.wikipedia.org/").get();
        System.out.println(document);
    }
}
