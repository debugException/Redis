package com.redis;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;


public class RedisTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("192.168.50.28", 6379);
		System.out.println("redis service connection success");
		System.out.println(jedis.ping());
		
		//keys
		System.out.println("==================");
		Set<String> set = jedis.keys("*");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			if (jedis.type(string).equals("string")) {
				System.out.println(string+" : "+jedis.get(string));
			}
		}
		System.out.println(jedis.exists("k2"));
		System.out.println(jedis.type("k2"));
		System.out.println("==================");
		
		//String
		jedis.set("k4", "v4");
		jedis.mset("str1","v1","str2","v2");
		System.out.println(jedis.mget("str1","str2"));
		System.out.println("==================");
		
		//list
		//jedis.lpush("mylist", "v1","v2","v3","v4","v5");
		List<String> list = jedis.lrange("mylist", 0, -1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("==================");
		
		//set
		jedis.sadd("orders", "jd001");
		jedis.sadd("orders", "jd002");
		jedis.sadd("orders", "jd003");
		Set<String> set2 = jedis.smembers("orders");
		Iterator<String> it2 = set2.iterator();
		while (it2.hasNext()) {
			String string = (String) it2.next();
			System.out.println(string);
		}
		jedis.srem("orders", "jd002");
		System.out.println(jedis.smembers("orders").size());
		System.out.println("==================");
		
		//hash
		jedis.hset("hash1", "userName", "lisi");
		System.out.println(jedis.hget("hash1", "userName"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("telephone","13511111111");
		map.put("age", "12");
		map.put("address", "beijing");
		jedis.hmset("hash2", map);
		List<String> result = jedis.hmget("hash2", "age","address");
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		System.out.println("=================");
		
		//zset
		jedis.zadd("zset01", 60d, "v1");
		jedis.zadd("zset01", 80d, "v2");
		jedis.zadd("zset01", 70d, "v3");
		jedis.zadd("zset01", 90d, "v4");
		
		Set<String> set3 = jedis.zrange("zset01", 0, -1);
		Iterator<String> it3 = set3.iterator();
		while (it3.hasNext()) {
			String string = (String) it3.next();
			System.out.println(string);
		}
	}
}
