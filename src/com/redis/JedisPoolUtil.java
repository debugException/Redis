package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	private static volatile JedisPool jedisPool = null;
	
	private JedisPoolUtil(){
		
	}
	
	public static JedisPool getJedisPoolInstance(){
		if (null == jedisPool) {
			synchronized (JedisPoolUtil.class) {
				if (null == jedisPool) {
					JedisPoolConfig config = new JedisPoolConfig();	
					config.setMaxWaitMillis(1000);
					config.setMaxIdle(25);
					config.setTestOnBorrow(true);
					jedisPool = new JedisPool(config, "192.168.50.28");
				}
			}
		}
		return jedisPool;
	}
	
	@SuppressWarnings("deprecation")
	public static void release(JedisPool jedisPool, Jedis jedis){
		if (null != jedis) {
			jedisPool.returnResourceObject(jedis);
		}
	}
}
