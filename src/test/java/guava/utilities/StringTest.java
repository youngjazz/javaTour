package guava.utilities;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * description:
 *
 * @author 张洋
 * @date: 2019-06-04 20:39
 */
public class StringTest {
    @Test
    public void testStringMethod(){
        assertThat(Strings.emptyToNull(""), nullValue());
        assertThat(Strings.nullToEmpty(null), equalTo(""));
        assertThat(Strings.nullToEmpty("hello"), equalTo("hello"));
        assertThat(Strings.commonPrefix("Hello","Hix"), equalTo("H"));
        assertThat(Strings.commonSuffix("Hello","Echo"), equalTo("o"));
        assertThat(Strings.repeat("Leon", 3), equalTo("LeonLeonLeon"));
        assertThat(Strings.isNullOrEmpty(null), equalTo(true));
        assertThat(Strings.isNullOrEmpty(""), equalTo(true));

        assertThat(Strings.padStart("Leon",3,'X'), equalTo("Leon"));
        assertThat(Strings.padStart("Leon",6,'X'), equalTo("XXLeon"));
        assertThat(Strings.padEnd("Leon",6,'X'), equalTo("LeonXX"));
    }

    @Test
    public void testCharset(){
        Charset charset = Charset.forName("UTF-8");
        assertThat(Charsets.UTF_8, equalTo(charset));
    }

    @Test
    public void testCharMatcher(){

    }
}
