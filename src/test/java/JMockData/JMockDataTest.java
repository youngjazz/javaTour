package JMockData;

import JMockData.testBean.MockDemoBeanAnyData;
import JMockData.testBean.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.jsonzou.jmockdata.JMockData;
import org.junit.Test;

import java.math.BigInteger;


/**
 * Created by leon on 2017/4/15.
 */
public class JMockDataTest {

    private void print(Object data){
        System.out.println(JSON.toJSONStringWithDateFormat(data,"YYYY-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));
    }

    /**
     * 测试模拟简单POJO-user
     */
    @Test
    public void mockSimpleType_POJO(){
        User user = JMockData.mockSimpleType(User.class);
        print(user);
    }

    /**
     * 模拟any
     */
    @Test
    public void mockSimpleType_any(){
        MockDemoBeanAnyData anyData = JMockData.mockSimpleType(MockDemoBeanAnyData.class);
        print(anyData);
    }

    /**
     * 模拟元数据
     */
    @Test
    public void mockSimple_mockMeta(){
        print(JMockData.mockSimpleType(BigInteger.class));
    }


    /**
     *
     */
}
