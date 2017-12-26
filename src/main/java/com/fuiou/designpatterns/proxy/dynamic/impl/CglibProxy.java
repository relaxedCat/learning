package com.fuiou.designpatterns.proxy.dynamic.impl;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.err.println("before invoke...");
		arg3.invokeSuper(arg0, arg2);
		System.err.println("after invoke...");
		return null;
		
	}

}
