package com.fuiou.designpatterns.proxy.dynamic.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.fuiou.designpatterns.proxy.dynamic.Subject;
import com.fuiou.designpatterns.proxy.dynamic.impl.JdkProxy;
import com.fuiou.designpatterns.proxy.dynamic.impl.RealSubject;

public class DynamicProxyTest {

	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		
		InvocationHandler handler = new JdkProxy(realSubject);
		Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		System.err.println(subject.getClass().getName());
		subject.rent();
		subject.hello("world");
	}
}
