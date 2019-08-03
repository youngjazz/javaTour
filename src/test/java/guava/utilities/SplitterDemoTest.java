package guava.utilities;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * description:
 *
 * @author 张洋
 * @date: 2019-05-29 16:24
 */
public class SplitterDemoTest {

    @Test
    public void testSplitOnSplit(){
        List<String> strings = Splitter.on("|").splitToList("hello|world");
        assertThat(strings, notNullValue());
        assertThat(strings.size(), equalTo(2));
        assertThat(strings.get(0),  equalTo("hello"));
    }

    @Test
    public void testSplitterOmitEmpty(){
        List<String> result = Splitter.on("#").omitEmptyStrings().splitToList("Hello###World#");
        assertThat(result.size(), equalTo(2));
    }

    @Test
    public void testSplitterOmitEmpty_Trim(){
        List<String> result = Splitter.on("#").omitEmptyStrings().splitToList("Hello # ## World#");
        assertThat(result.size(), equalTo(3));

        result = Splitter.on("#").trimResults().omitEmptyStrings().splitToList("Hello # ## World#");
        assertThat(result.size(), equalTo(2));
        assertThat(result.get(1), equalTo("World"));
    }

    @Test
    public void testSplitterFixedLength(){
        List<String> result = Splitter.fixedLength(4).splitToList("aaaabbbbccccd");
        assertThat(result.size(), equalTo(4));
        assertThat(result.get(0), equalTo("aaaa"));
        assertThat(result.get(3), equalTo("d"));
    }

    @Test
    public void testSplitLimit(){
        List<String>  result = Splitter.on("#").limit(3).splitToList("hello#java#scala#python#php");
        assertThat(result.size(), equalTo(3));
        assertThat(result.get(2), equalTo("scala#python#php"));
    }

    @Test
    public void testSplitToMap(){
        Map<String, String> result = Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().withKeyValueSeparator("=").split("hello=Hello |world=World");

        assertThat(result.size(), equalTo(2));
        assertThat(result.get("hello"), equalTo("Hello"));
    }
}