package com.fuiou.designpatterns.prototype;

public class Prototype implements Cloneable{

	
	public Prototype cloneProto() throws CloneNotSupportedException{
		Prototype pro = (Prototype)super.clone();
		return pro;
		
	}

	
}
