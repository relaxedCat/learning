package com.fuiou.designpatterns.factory.normal;

import com.fuiou.designpatterns.factory.normal.impl.SmsFactory;

public class FactoryTest {

	public static void main(String[] args) {
		Sender sender = SenderFactory.produce("mail");
		sender.send();
		AbstractFactory abf = new SmsFactory();
		Sender sd = abf.produce();
		sd.send();
	}
}
