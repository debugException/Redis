package com.design.singleton;

public class TestDesign {

	public static void main(String[] args) {
		//饿汉模式
		SingletonEH instance1 = SingletonEH.getInstance();
		SingletonEH instance2 = SingletonEH.getInstance();
		if (instance1 == instance2) {
			System.out.println("instance1 和 instance2是同一个实例。");
		}else{
			System.out.println("instance1 和 instance2不是同一个实例。");
		}
		//懒汉模式
		SingletonLH instance3 = SingletonLH.getInstance();
		SingletonLH instance4 = SingletonLH.getInstance();
		if (instance3 == instance4) {
			System.out.println("instance3 和 instance4是同一个实例。");
		}else{
			System.out.println("instance3 和 instance4不是同一个实例。");
		}
	}
}
