package com.fuiou.designpatterns.adapter.classlevel.impl;

import com.fuiou.designpatterns.adapter.classlevel.Source;
import com.fuiou.designpatterns.adapter.classlevel.Target;

public class Adapter extends Source implements Target {

	@Override
	public void targetMethon() {
		System.err.println("this is target methon!");

	}

}
