package com.fuiou.designpatterns.proxy.dynamic.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;

import com.fuiou.designpatterns.proxy.dynamic.Subject;
import com.fuiou.designpatterns.proxy.dynamic.impl.CglibProxy;
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
		
		CglibProxy cp = new CglibProxy();
		RealSubject realsub = new RealSubject();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(realsub.getClass());
		enhancer.setCallback(cp);
		RealSubject proxysub = (RealSubject) enhancer.create();
		proxysub.rent();
		proxysub.hello("you");
	}
}
