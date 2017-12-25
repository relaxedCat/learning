package com.fuiou.designpatterns.decorator.impl;

import com.fuiou.designpatterns.decorator.Sourceable;

public class Decorate implements Sourceable {

	private Sourceable source;
	
	@Override
	public void sourceMethon() {

		System.err.println("before origin");
		source.sourceMethon();
		System.err.println("after origin");
		
	}

	public Decorate(Sourceable source) {
		super();
		this.source = source;
	}
	
	

}
