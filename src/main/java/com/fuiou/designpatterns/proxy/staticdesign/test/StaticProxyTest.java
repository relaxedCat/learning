package com.fuiou.designpatterns.proxy.staticdesign.test;

import com.fuiou.designpatterns.proxy.staticdesign.Proxy;
import com.fuiou.designpatterns.proxy.staticdesign.SourceAble;

public class StaticProxyTest {

	public static void main(String[] args) {
		SourceAble proxy = new Proxy();
		proxy.method();
	}
}
