package com.fuiou.designpatterns.bridge.test;

import com.fuiou.designpatterns.bridge.impl.DB2Driver;
import com.fuiou.designpatterns.bridge.impl.Mybridge;
import com.fuiou.designpatterns.bridge.impl.MysqlDriver;
import com.fuiou.designpatterns.bridge.impl.OracleDriver;

public class BridgeTest {

	public static void main(String[] args) {
		
		Mybridge bridge = new Mybridge(); 
		
		OracleDriver od = new OracleDriver();
		MysqlDriver md = new MysqlDriver();
		DB2Driver dd = new DB2Driver();
		
		bridge.setDriver(od);
		bridge.driver();
		bridge.setDriver(md);
		bridge.driver();
		bridge.setDriver(dd);
		bridge.driver();
	}
}
