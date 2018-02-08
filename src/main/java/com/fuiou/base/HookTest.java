package com.fuiou.base;

import java.util.ArrayList;
import java.util.List;

public class HookTest {

//	private static byte[] bytes = new byte[20*1024*1024];
	
	public void start(){
		Runtime.getRuntime().addShutdownHook(
				new Thread(){

					@Override
					public void run() {
						System.out.println("Execute Hook.....");
					}
					
				});
	}
	
	public static void main(String[] args){
		new HookTest().start();
		List<byte[]> l = new ArrayList<byte[]>();
		for (int i = 0; i < 10; i++) {
			byte[] bytes = new byte[2*1024*1024];
			HookTest t = new HookTest();
			l.add(bytes);
			System.err.println(i);
			System.err.println(t);
		}
		System.err.println("do something.....");
	}
	
}
