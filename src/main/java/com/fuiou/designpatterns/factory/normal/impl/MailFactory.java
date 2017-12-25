package com.fuiou.designpatterns.factory.normal.impl;

import com.fuiou.designpatterns.factory.normal.AbstractFactory;
import com.fuiou.designpatterns.factory.normal.Sender;

public class MailFactory implements AbstractFactory {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
