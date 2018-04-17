import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by leon on 2017/6/6.
 */
public class Collection {
    public static String main(String[] args) throws IOException {
        String str = "sdsdfs12sdf234sdfs";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("sdsd"))) {
            return bufferedReader.readLine();
        }
    }
}
