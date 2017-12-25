package com.fuiou.designpatterns.observer.test;

import com.fuiou.designpatterns.observer.impl.ConcreteObserver;
import com.fuiou.designpatterns.observer.impl.ConcreteSubject;

public class ObserverTest {

	public static void main(String[] args) {
		ConcreteObserver ob = new ConcreteObserver();
		ConcreteSubject sj = new ConcreteSubject();
		sj.register(ob);
		sj.setStates("new State");
		System.err.println("当前观察到的状态："+ob.getState());
	}
}
