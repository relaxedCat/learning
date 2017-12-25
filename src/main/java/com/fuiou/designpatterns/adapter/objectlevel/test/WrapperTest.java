package com.fuiou.designpatterns.adapter.objectlevel.test;

import com.fuiou.designpatterns.adapter.classlevel.Source;
import com.fuiou.designpatterns.adapter.objectlevel.Wrapper;

public class WrapperTest {

	public static void main(String[] args) {
		Source source = new Source();
		Wrapper wp = new Wrapper(source);
		wp.sourceMethon();
		wp.targetMethon();
	}
}
