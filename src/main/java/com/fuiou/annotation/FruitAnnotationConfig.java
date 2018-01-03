package com.fuiou.annotation;

import java.lang.reflect.Field;

public class FruitAnnotationConfig {

	public void getFruitConfigInf(Class<?> clz){
		
		String FruitNm = "水果名称";
		String FruitColor = "水果颜色";
		
		Field[] fields = clz.getDeclaredFields();
		
		for (Field field : fields) {
			if(field.isAnnotationPresent(FruitName.class)){
				FruitName fruitName = field.getAnnotation(FruitName.class);
				FruitNm = FruitNm+fruitName.value();
				System.err.println(FruitNm);
			}else if(field.isAnnotationPresent(FruitColor.class)){
				FruitColor fruitClr = field.getAnnotation(FruitColor.class);
				FruitColor = FruitColor + fruitClr.fruitColor().toString();
				System.err.println(FruitColor);
			}
		}
	}
	
	public static void main(String[] args) {
		FruitAnnotationConfig fac = new FruitAnnotationConfig();
		fac.getFruitConfigInf(Apple.class);
	}
}
