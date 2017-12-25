package com.fuiou.designpatterns.adapter.classlevel.test;

import com.fuiou.designpatterns.adapter.classlevel.Target;
import com.fuiou.designpatterns.adapter.classlevel.impl.Adapter;

public class AdapterTest {

	public static void main(String[] args) {
		
		Target target = new Adapter();
		target.targetMethon();
		target.sourceMethon();
	}
	
}
