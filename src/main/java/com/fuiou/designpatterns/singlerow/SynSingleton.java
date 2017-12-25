package com.fuiou.designpatterns.singlerow;

public class SynSingleton {

	private static SynSingleton instance = null;
	
	private SynSingleton(){
		
	}
	
	public static  synchronized SynSingleton getInstance(){
		if(instance == null){
			instance = new SynSingleton();
		}
		return instance;
	}
}
