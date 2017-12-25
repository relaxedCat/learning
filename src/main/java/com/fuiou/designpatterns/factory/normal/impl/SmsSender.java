package com.fuiou.designpatterns.factory.normal.impl;

import com.fuiou.designpatterns.factory.normal.Sender;

public class SmsSender implements Sender{

	@Override
	public void send() {
		System.err.println("sms send...");
	}

}
