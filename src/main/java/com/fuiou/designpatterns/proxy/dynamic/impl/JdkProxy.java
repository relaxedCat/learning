package com.fuiou.designpatterns.proxy.dynamic.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {

	private Object subject;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("before proxy");
		System.err.println("methon"+method);
		method.invoke(subject, args);
		System.err.println("after proxy");
		return null;
	}

	public JdkProxy(Object subject){
		super();
		this.subject = subject;
	}
	
}
