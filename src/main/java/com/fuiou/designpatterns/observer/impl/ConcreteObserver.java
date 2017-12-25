package com.fuiou.designpatterns.observer.impl;

import com.fuiou.designpatterns.observer.Observer;
import com.fuiou.designpatterns.observer.Subject;

public class ConcreteObserver implements Observer {

	private String state;
	private Subject subject;
	
	@Override
	public void update(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
