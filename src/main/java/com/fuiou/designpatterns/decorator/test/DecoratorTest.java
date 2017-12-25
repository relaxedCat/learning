package com.fuiou.designpatterns.decorator.test;

import com.fuiou.designpatterns.decorator.Sourceable;
import com.fuiou.designpatterns.decorator.impl.Decorate;
import com.fuiou.designpatterns.decorator.impl.Source;

public class DecoratorTest {

	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable decorator = new Decorate(source);
		decorator.sourceMethon();
		
	}
}
