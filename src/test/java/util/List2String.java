package util;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 张洋
 * @date: 2019-07-15 19:35
 */
public class List2String {
    private List<List<Float>> weightAddCondition = Collections.emptyList();

    @Before
    public void init() {
        weightAddCondition = Arrays.asList(Arrays.asList(0F, 2F, 1F), Arrays.asList(2F, 3F, 2F));
    }

    @Test
    public void list2String() {
        String jsonString = JSON.toJSONString(weightAddCondition);
        System.out.println(jsonString);
    }

    @Test
    public void string2List() {
        List<List<Integer>> result = new ArrayList<>();

        String json = "[[1,2,3],[2,3,4]]";
        JSON.parseArray(json,String.class).stream().forEach((item -> result.add(JSON.parseArray(item, Integer.class))));
        System.out.println(result);
    }

    @Test
    public void testFloat(){
        float price = 120.123f;
        System.out.println(price == 120.1230f);
    }
}
