package com.redis;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;


public class RedisJava {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//连接redis服务
		Jedis jedis = new Jedis("192.168.50.28");
		System.out.println("连接redis服务成功。。。。");
		//查看服务是否运行
		System.out.println("Service is running......"+jedis.ping());
		
		//设置redis字符串数据
		System.out.println("=======设置redis字符串数据=======");
		jedis.set("k1", "v1");
		System.out.println(jedis.get("k1"));
		
		//存储数据到列表中
		System.out.println("=======存储数据到列表中=======");
		jedis.lpush("name", "zhangsan");
		jedis.lpush("name", "lisi");
		jedis.lpush("name", "wangwu");
		
		//获取存储的数据并输出
		System.out.println("=======获取存储的数据并输出=======");
		List<String> list = jedis.lrange("name", 0, -1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//获取数据并输出
		System.out.println("=======获取数据并输出========");
		Set<String> set = jedis.keys("*");
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
	}
}
