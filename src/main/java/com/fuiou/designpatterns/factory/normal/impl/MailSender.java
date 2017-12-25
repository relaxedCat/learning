package com.fuiou.designpatterns.factory.normal.impl;

import com.fuiou.designpatterns.factory.normal.Sender;

public class MailSender implements Sender {

	@Override
	public void send() {

		System.err.println("mail send....");
	}

}
