package com.fuiou.designpatterns.proxy.dynamic.impl;

import com.fuiou.designpatterns.proxy.dynamic.Subject;

public class RealSubject implements Subject {

	@Override
	public void rent() {

		System.err.println("i want rent your house");
	}

	@Override
	public void hello(String str) {

		System.err.println("hello"+str);
	}

}
