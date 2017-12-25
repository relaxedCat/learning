package com.fuiou.designpatterns.factory.normal;

import com.fuiou.designpatterns.factory.normal.impl.MailSender;
import com.fuiou.designpatterns.factory.normal.impl.SmsSender;

public class SenderFactory {

	public static Sender produce(String type){
		if("mail".equals(type)){
			return new MailSender();
		}else if("sms".equals(type)){
			return new SmsSender();
		}else{
			System.err.println("error type");
			return null;
		}
	}
}
