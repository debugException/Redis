package com.design.factory;

//模拟客户端的实现
public class HairTest {

	public static void main(String[] args) {
		/*HairInterface hair = new LeftHair();
		hair.draw();*/
		HairFactory factory = new HairFactory();
		HairInterface left = factory.getHair("left");
		left.draw();
	}
}
