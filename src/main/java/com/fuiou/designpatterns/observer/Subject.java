package com.fuiou.designpatterns.observer;

public interface Subject {

	void register(Observer obs);
	
	void unregister(Observer obs);
	
	void notifyObservers();
}
