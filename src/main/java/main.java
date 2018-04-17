import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Created by leon on 2017/7/7.
 */
public class main {
    
    
    @Test
    public void getToken(){
        for (int i = 0; i < 100000; i++) {
            String token = UUID.randomUUID().toString().replace("-","")+getRandom(10);
            System.out.println(token);
        }
    }
    private String getRandom(int n){
        char[] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        int length = chars.length;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int index = 0;index<n;index++){
            sb.append(chars[random.nextInt(length)]);
        }
        return sb.toString();
    }
    
    // 哈希算法
    public static long hash(byte[] digest, int nTime)
    {
        long rv = ((long)(digest[3 + nTime * 4] & 0xFF) << 24)
            | ((long)(digest[2 + nTime * 4] & 0xFF) << 16)
            | ((long)(digest[1 + nTime * 4] & 0xFF) << 8)
            | ((long)digest[0 + nTime * 4] & 0xFF);
        return rv;
    }
    
    @Test
    public void testHash(){
        String mobile = "13248269109,13288269109,13448261109,13248269100";
        String msg = "告警，任务: s_flow_hour_refer_device_city，状态:KILLED，详情:\"{\\\"diagnostics\\\":\\\"Application killed by user.\\\"}\"";
        String msg2 = "告警，任务: s_flow_hour_refer_device_city，状态:KILLED";
            String key = hash(mobile.getBytes(),0)+"_"+hash(msg.getBytes(),0);
            String key1 = hash(mobile.getBytes(),0)+"_"+hash(msg2.getBytes(),0);
            System.out.println(key);
            System.out.println(key1);
    }

	@Test
    public void arrayToJson(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList);
        System.out.println(JSONObject.toJSONString(arrayList));
    }

    public static void main(String[] args) {
        String params = getLongString("/Users/leon/temp/longJson.txt");

        JSONObject json = JSONObject.parseObject(params);
        JSONArray photo_lst = (JSONArray) json.get("photo_lst");
        for (Object o : photo_lst) {
            JSONObject jsonObject = (JSONObject)o;
            System.out.println(jsonObject.get("photo_name"));
            System.out.println(jsonObject.get("photo"));
        }

    }

    private static String getLongString(String fileName){
        String longStr = "";
        File file = new File(fileName);
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bf.readLine()) != null){
                longStr += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  longStr;
    }

    @Test
    public void jsonParse(){
        String jsonStr = "[{\"photo_type\":\"40\",\"photo_name\":\"03.jpg\"},{\"photo_type\":\"41\",\"photo_name\":\"04.jpg\"}]";
        JSONArray parse = (JSONArray) JSONArray.parse(jsonStr);
        System.out.println(parse);
        for (Object o : parse) {
            JSONObject jsonObject = (JSONObject)o;
            System.out.println(jsonObject.get("photo_type").toString());
            System.out.println(jsonObject.get("photo_name").toString());
        }
    }

    @Test
    public void jsonParse2(){
        String jsonStr = "[\n" +
                "        {\n" +
                "          \"contact_name\": \"芮恩特\",\n" +
                "          \"contact_phone\": \"15183749583\",\n" +
                "          \"contact_relation\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"contact_name\": \"恩斯特\",\n" +
                "          \"contact_phone\": \"15183749583\",\n" +
                "          \"contact_relation\": \"6\"\n" +
                "        }\n" +
                "      ]";
        JSONArray parse = (JSONArray) JSONArray.parse(jsonStr);
        System.out.println(parse);
        for (int i = 0; i < parse.size(); i++) {
            JSONObject json = (JSONObject) JSONObject.parse(parse.get(i).toString());
            System.out.println(json.get("contact_name"));
            System.out.println(json.get("contact_phone"));
            System.out.println(json.get("contact_relation"));
        }

    }
}
