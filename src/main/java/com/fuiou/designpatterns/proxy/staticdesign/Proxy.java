package com.fuiou.designpatterns.proxy.staticdesign;

import com.fuiou.designpatterns.proxy.staticdesign.impl.Source;

public class Proxy implements SourceAble {

	private Source source;
	
	@Override
	public void method() {
		before();
		source.method();
		after();
		
	}
	
	public Proxy(){
		super();
		this.source = new Source();
	}
	
	private void before(){
		System.err.println("before proxy");
	}
	
	private void after(){
		System.err.println("after proxy");
	}

}
