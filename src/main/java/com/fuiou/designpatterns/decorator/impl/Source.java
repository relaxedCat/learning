package com.fuiou.designpatterns.decorator.impl;

import com.fuiou.designpatterns.decorator.Sourceable;


public class Source implements Sourceable{

	@Override
	public void sourceMethon() {

		System.err.println("this is a origin methon!");
	}


}
