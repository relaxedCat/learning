package com.fuiou.designpatterns.observer.impl;

import java.util.ArrayList;
import java.util.List;

import com.fuiou.designpatterns.observer.Observer;
import com.fuiou.designpatterns.observer.Subject;

public class ConcreteSubject implements Subject{

	private List<Observer> oblist;
	private String states;
	
	@Override
	public void register(Observer obs) {

		oblist.add(obs);
	}

	@Override
	public void unregister(Observer obs) {
		oblist.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (Observer obs : oblist) {
			obs.update(states);
		}
	}

	public ConcreteSubject() {
		super();
		this.oblist = new ArrayList<Observer>();
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
		this.notifyObservers();
	}
	
	
	
	

}
