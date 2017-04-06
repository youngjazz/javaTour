package redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Jedis测试类
 * 更多参考 http://doc.redisfans.com
 * Created by leon on 2017/4/5.
 */
public class RedisUtilTest {
    private Jedis jedis;

    @Before
    public void setup(){
        jedis = new Jedis("127.0.0.1",6379);


//        jedis = RedisUtil.getJedis();
    }

    @Test
    public void testRedisPool(){
        RedisUtil.getJedis().set("name","中文测试");
        System.out.println(RedisUtil.getJedis().get("name"));
    }

    /**
     * jedis操作字符串
     */
    @Test
    public void testString(){
        jedis.set("name","zhangyang");
        System.out.println(jedis.get("name"));

        jedis.append("name"," is handsome");
        System.out.println(jedis.get("name"));

        //删除某个键值对
        long result = jedis.del("zhangyang");
        System.out.println(result);

        //设置多个键值对
        jedis.mset("name","lyn","age","26","qq","123123");
        jedis.incr("age");
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
    }

    /**
     * jedis操作Map
     */
    @Test
    public void testMap(){
        //添加数据
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","zhangyang");
        map.put("age","26");
        map.put("qq","496512380");

        jedis.hmset("user",map);
        //取出map对象,第一个是key，后面是可变参数。，返回List
        List<String> rsmap = jedis.hmget("user","name","age","qq");
        System.out.println(rsmap);

        //删除map中的某个值
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user","age"));
        System.out.println(jedis.hlen("user"));//返回user中键个数
        System.out.println(jedis.exists("user"));
        System.out.println(jedis.hkeys("user"));//返回map对象中所有的key
        System.out.println(jedis.hvals("user"));//返回map对象中所有的value

        Iterator<String> iterator = jedis.hkeys("user").iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key+": "+jedis.hmget("user", key));
        }
    }

    /**
     * Jedis操作List
     */
    @Test
    public void testList(){
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));
        //先向key为 java framework中放三条数据
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");

        //在jedis按范围取出数据，第一个是key，第二个是起始位置，第三个结束位置，jedis.llen获取长度，-1表示取所有
        System.out.println(jedis.lrange("java framework",0,-1));
        jedis.del("java framework");
        jedis.rpush("java framework","spring");
        jedis.rpush("java framework","struts");
        jedis.rpush("java framework","hibernate");

        System.out.println(jedis.lrange("java framework",0,-1));
    }

    /**
     * jedis 操作Set
     */
    @Test
    public void testSet(){
        //添加
        jedis.sadd("user","lyn");
        jedis.sadd("user","ygp");
        jedis.sadd("user","hdd");
        jedis.sadd("user","lyl");
        jedis.sadd("user","who");
        //获取所有加入的value
        System.out.println(jedis.smembers("user"));
        //移除noname
        jedis.srem("user","who");
        System.out.println(jedis.smembers("user"));
        //判断who是否是user集合的元素
        System.out.println(jedis.sismember("user","who"));
        //从user随机取值
        System.out.println(jedis.srandmember("user"));
        //返回集合元素个数
        System.out.println(jedis.scard("user"));
    }

    /**
     * 测试jedis有效期
     */
    @Test
    public void testExpire(){
        System.out.println(jedis.keys("*"));
        jedis.expire("name",30);
        System.out.println(jedis.ttl("name"));
    }
}