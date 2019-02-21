package json;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author leon
 * @since 2019-01-10
 */
public class Json2Obj {
    public static void main(String[] args) {


        String jsonStr  = "{\n" +
                "    \"username\": \"ycayb\",\n" +
                "    \"password\": \"ycayb123\",\n" +
                "    \"agentInfos\": [\n" +
                "        {\n" +
                "            \"provinceCode\": \"430000\",\n" +
                "            \"cityCode\": \"430100\",\n" +
                "            \"deptCode\": \"2324\",\n" +
                "            \"agentCode\": \"230002110011\",\n" +
                "            \"agentName\": \"长沙天顺保险代理有限公司\",\n" +
                "            \"qlfNo\": \"430105000028455\",\n" +
                "            \"conferCode\": \"B230012100003A\",\n" +
                "            \"operatorCode\": \"10324000E\",\n" +
                "            \"salesmanNo\": \"10324000E\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"provinceCode\": \"350000\",\n" +
                "            \"deptCode\": \"1027\",\n" +
                "            \"agentCode\": \"102702110022\",\n" +
                "            \"agentName\": \"福建祥天保险代理有限公司\",\n" +
                "            \"conferCode\": \"B102712070001A\",\n" +
                "            \"qlfNo\": \"350100400004972\",\n" +
                "            \"operatorCode\": \"10324000E\",\n" +
                "            \"salesmanNo\": \"10324000E\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"provinceCode\": \"110000\",\n" +
                "            \"deptCode\": \"0221\",\n" +
                "            \"agentCode\": \"073903170010\",\n" +
                "            \"agentName\": \"明亚保险经纪股份有限公司\",\n" +
                "            \"conferCode\": \"B02200800006\",\n" +
                "            \"qlfNo\": \"200901110000001000\",\n" +
                "            \"operatorCode\": \"10324000E\",\n" +
                "            \"salesmanNo\": \"10324000E\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"provinceCode\": \"460000\",\n" +
                "            \"deptCode\": \"3021\",\n" +
                "            \"agentCode\": \"302102140001\",\n" +
                "            \"agentName\": \"符彩新\",\n" +
                "            \"conferCode\": \"B302113010001A\",\n" +
                "            \"qlfNo\": \"20020946010000000000\",\n" +
                "            \"operatorCode\": \"10324000E\",\n" +
                "            \"salesmanNo\": \"10324000E\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"provinceCode\": \"440000\",\n" +
                "            \"deptCode\": \"0424\",\n" +
                "            \"agentCode\": \"042402130014\",\n" +
                "            \"agentName\": \"梁见棠\",\n" +
                "            \"conferCode\": \"B04201000069A\",\n" +
                "            \"qlfNo\": \"20070244000009000000\",\n" +
                "            \"operatorCode\": \"10324000E\",\n" +
                "            \"salesmanNo\": \"10324000E\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"provinceCode\": \"140000\",\n" +
                "            \"deptCode\": \"1424\",\n" +
                "            \"agentCode\": \"142402120021\",\n" +
                "            \"agentName\": \"胡素红\",\n" +
                "            \"conferCode\": \"B14200900009A\",\n" +
                "            \"qlfNo\": \"20000214050000000000\",\n" +
                "            \"operatorCode\": \"10324000E\",\n" +
                "            \"salesmanNo\": \"10324000E\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"provinceCode\": \"510000\",\n" +
                "            \"deptCode\": \"0526\",\n" +
                "            \"agentCode\": \"052602130002\",\n" +
                "            \"agentName\": \"符彩新\",\n" +
                "            \"conferCode\": \"B052612020005A\",\n" +
                "            \"qlfNo\": \"20070451060000400000\",\n" +
                "            \"operatorCode\": \"10324000E\",\n" +
                "            \"salesmanNo\": \"10324000E\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        YongChengConfigDTO yongChengConfigDTO = JSON.parseObject(jsonStr, YongChengConfigDTO.class);
        System.out.println(yongChengConfigDTO.getAgentInfos().size());
    }

}
