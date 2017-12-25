package com.fuiou.designpatterns.adapter.inflevel.test;

import com.fuiou.designpatterns.adapter.inflevel.Sourceable;
import com.fuiou.designpatterns.adapter.inflevel.impl.SourceSub1;
import com.fuiou.designpatterns.adapter.inflevel.impl.SourceSub2;

public class WrapperTest {

	public static void main(String[] args) {
		Sourceable sa1 = new SourceSub1();
		Sourceable sa2 = new SourceSub2();
		
		sa1.methon1();
		sa2.methon2();
	}
}
