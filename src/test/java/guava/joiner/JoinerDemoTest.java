package guava.joiner;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;


/**
 * @author leon
 * @date 2018/10/10
 */
public class JoinerDemoTest {

    private final List<String> stringList = Arrays.asList(
            "Google","Guava", "Java", "Scala", "Kafka"
    );

    private final List<String> stringListWithNull = Arrays.asList(
            "Google","Guava", "Java", "Scala", "Kafka", null
    );

    @Test
    public void testJoinOnJoin(){
        String result = Joiner.on("#").join(stringList);
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
    }

    @Test
    public void testJoinOnJoinNull(){
        String result = Joiner.on("#").skipNulls().join(stringListWithNull);
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
    }

    @Test
    public void testJoinOnJoinNullButUserDefault(){
        String result = Joiner.on("#").useForNull("DEFAULT").join(stringListWithNull);
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka#DEFAULT"));
    }

    @Test
    public void testJoinOn_append_to_stringbuilder(){
        final StringBuilder builder = new StringBuilder();
        StringBuilder resultBuilder = Joiner.on("#").useForNull("DEFAULT").appendTo(builder, stringListWithNull);
        assertThat(builder, sameInstance(resultBuilder));
        assertThat(resultBuilder.toString(), equalTo("Google#Guava#Java#Scala#Kafka#DEFAULT"));
        assertThat(builder.toString(), equalTo("Google#Guava#Java#Scala#Kafka#DEFAULT"));
    }
}