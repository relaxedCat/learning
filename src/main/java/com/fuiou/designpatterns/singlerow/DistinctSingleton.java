package com.fuiou.designpatterns.singlerow;

public class DistinctSingleton {

	private static DistinctSingleton instance = null;
	
	private DistinctSingleton(){
		
	}
	
	public static synchronized void init(){
		if(instance == null){
			instance = new DistinctSingleton();
		}
	}
	
	public DistinctSingleton getInstance(){
		if(instance == null){
			init();
		}
		return instance;
	}
}
