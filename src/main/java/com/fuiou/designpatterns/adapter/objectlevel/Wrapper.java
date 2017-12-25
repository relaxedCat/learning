package com.fuiou.designpatterns.adapter.objectlevel;

import com.fuiou.designpatterns.adapter.classlevel.Source;
import com.fuiou.designpatterns.adapter.classlevel.Target;

public class Wrapper implements Target {
	
	private Source source;

	@Override
	public void sourceMethon() {

		this.source.sourceMethon();
	}

	@Override
	public void targetMethon() {

		System.err.println("this is target methon!");
	}

	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	
	
}
