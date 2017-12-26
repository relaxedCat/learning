package com.fuiou.designpatterns.bridge.impl;

import com.fuiou.designpatterns.bridge.DBbridge;

public class Mybridge extends DBbridge {

	@Override
	public void driver() {
		getDriver().driver();
	}

	
}
