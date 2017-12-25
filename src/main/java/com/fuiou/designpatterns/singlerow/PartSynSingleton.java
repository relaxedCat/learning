package com.fuiou.designpatterns.singlerow;

public class PartSynSingleton {

	private static PartSynSingleton instance = null;
	
	private static final Object obj = new Object();
	
	@SuppressWarnings("static-access")
	private PartSynSingleton(){
		try {
			Thread.currentThread().sleep(5000);
			System.err.println(Thread.currentThread().getId()+Thread.currentThread().getName()+"对象初始化完毕！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static PartSynSingleton getInstance(){
		if(instance == null){
			synchronized (obj) {
			
				if(instance == null){
					instance = new PartSynSingleton();
				}
				System.err.println(Thread.currentThread().getId()+Thread.currentThread().getName()+"对象创建完毕!");
			}
		}
		return instance;
	}
	
	
}
