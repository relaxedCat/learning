package com.fuiou.designpatterns.facade.test;

import com.fuiou.designpatterns.facade.Computer;

public class FacadeTest {

	public static void main(String[] args) {
		
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}
	
}
