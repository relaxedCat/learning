package com.fuiou.designpatterns.singlerow;

public class FactorySingleton {

	private FactorySingleton(){
		
	}
	
	private static class SingletonFactoy{
		private static FactorySingleton instance = new FactorySingleton();
	}
	
	public FactorySingleton getInstance(){
		return SingletonFactoy.instance;
	}
	
}
