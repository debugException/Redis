package com.design.singleton;

/*
 * 单例模式 Singleton
 * 作用：保证整个应用程序中某一个实例有且只有一个
 * 类型：懒汉模式，饿汉模式
 */
//饿汉模式
public class SingletonEH {
	
	//1：将构造方法私有化，不允许外部直接创建对象
	private SingletonEH(){
		
	}
	
	//2：创建类的唯一实例
	private static SingletonEH instance = new SingletonEH();
	
	//3：提供唯一一个获取实例的方法
	public static SingletonEH getInstance(){
		return instance;
	}
}
