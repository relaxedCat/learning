package com.fuiou.designpatterns.factory.normal;

public class FactoryTest {

	public static void main(String[] args) {
		Sender sender = SenderFactory.produce("mail");
		sender.send();
	}
}
