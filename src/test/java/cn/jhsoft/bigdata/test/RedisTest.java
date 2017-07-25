package cn.jhsoft.bigdata.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by chenyi9 on 2017/7/25.
 */
public class RedisTest {

    @Test
    public void testRedis(){
        JedisPoolConfig config = new JedisPoolConfig();
        JedisPool pool = new JedisPool(config, "s1", 6379, 10000, "123456");
        Jedis jedis = pool.getResource();
        jedis.set("a2", "11");
        System.out.println(jedis.get("a2"));
    }

}
