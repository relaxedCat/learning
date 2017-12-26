package com.fuiou.designpatterns.bridge.impl;

import com.fuiou.designpatterns.bridge.Driver;

public class MysqlDriver implements Driver {

	@Override
	public void driver() {

		System.err.println("use mysql connect db ....");
	}

}
