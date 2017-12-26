package com.fuiou.designpatterns.bridge.impl;

import com.fuiou.designpatterns.bridge.Driver;

public class OracleDriver implements Driver {

	@Override
	public void driver() {

		System.err.println("use oracle connect db...");
	}

}
