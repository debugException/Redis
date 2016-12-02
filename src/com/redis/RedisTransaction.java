package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTransaction {

	public boolean transMethod() throws InterruptedException{
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("192.168.50.28");
		int balance = 0;
		int amount = 10;
		
		jedis.watch("balance");
//		Thread.sleep(7000);
		balance = Integer.valueOf(jedis.get("balance"));
		if (balance < amount) {
			jedis.unwatch();
			System.out.println("modify");
			return false;
		}else {
			System.out.println("=========transaction========");
			Transaction ts = jedis.multi();
			ts.decrBy("balance", amount);
			ts.incrBy("debt", amount);
			ts.exec();
			System.out.println(jedis.get("balance")+"===="+jedis.get("debt"));
			return true;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		RedisTransaction rt = new RedisTransaction();
		boolean flag = rt.transMethod();
		System.out.println("main retvalue .....: "+flag);
	}
}
