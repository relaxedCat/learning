package com.fuiou.designpatterns.proxy.staticdesign.impl;

import com.fuiou.designpatterns.proxy.staticdesign.SourceAble;


public class Source implements SourceAble {

	@Override
	public void method() {

		System.err.println("this is the origin methon!");
	}

}
