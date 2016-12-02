package com.design.singleton;

/*
 * 懒汉模式：
 * 区别：懒汉模式的特点是加载类时比较慢，	但运行时获取对象的速度比较快，线程安全
 * 饿汉模式的特点是加载类时比较快，但运行时获取对象的速度比较慢，线程不安全
 */
public class SingletonLH {

	//1：将构造方法私有化，不允许外部直接创建对象
	private SingletonLH(){
	}
	
	//2：声明类的唯一实例，使用private static修饰
	private static SingletonLH instance;
	
	//3：提供一个用于获取实例的方法
	public static SingletonLH getInstance(){
		if (instance == null) {
			instance = new SingletonLH();
		}
		return instance;
	}
}
