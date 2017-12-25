package com.fuiou.designpatterns.factory.normal.test;

import com.fuiou.designpatterns.factory.normal.AbstractFactory;
import com.fuiou.designpatterns.factory.normal.Sender;
import com.fuiou.designpatterns.factory.normal.SenderFactory;
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
