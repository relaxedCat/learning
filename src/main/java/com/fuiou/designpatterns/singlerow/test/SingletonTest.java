package com.fuiou.designpatterns.singlerow.test;

import com.fuiou.designpatterns.singlerow.PartSynSingleton;

public class SingletonTest {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(){

				@Override
				public void run() {
					PartSynSingleton instance = PartSynSingleton.getInstance();
					System.err.println(instance);
				}
				
			}.start();;
		}
	}
}
