package com.fuiou.annotation;

import com.fuiou.annotation.FruitColor.Color;

public class Apple {

	@FruitName("apple")
	private String appleNm;
	
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;

	public String getAppleNm() {
		return appleNm;
	}

	public void setAppleNm(String appleNm) {
		this.appleNm = appleNm;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}
	
	public void displayNm(){
		System.out.println("水果的名字：苹果");
	}
	
	
	
	public static void main(String[] args) {
		Apple app = new Apple();
		System.out.println(app.getAppleColor());
		System.out.println(app.getAppleNm());
	}
}
