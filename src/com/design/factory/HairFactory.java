package com.design.factory;

/*
 * 发型工厂
 */
public class HairFactory {
	
	/*
	 * 根据类型创建对象
	 */
	public HairInterface getHair(String key){
		if ("left".equals(key)) {
			return new LeftHair();
		}else if ("right".equals(key)) {
			return new RightHair();
		}else {
			return null;
		}
		
	}
}
