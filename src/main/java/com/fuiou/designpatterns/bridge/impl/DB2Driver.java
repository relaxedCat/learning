package com.fuiou.designpatterns.bridge.impl;

import com.fuiou.designpatterns.bridge.Driver;

public class DB2Driver implements Driver {

	@Override
	public void driver() {

		System.err.println("use db2 connect db ...");
	}

}
