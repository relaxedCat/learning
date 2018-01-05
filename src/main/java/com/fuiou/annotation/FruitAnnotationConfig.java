package com.fuiou.annotation;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FruitAnnotationConfig {

	public Object getFruitConfigInf(Class<?> clz) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException{
		
		String FruitNm = "水果名称";
		String FruitColor = "水果颜色";
		
		Field[] fields = clz.getDeclaredFields();
		Object obj = clz.newInstance();
		for (Field field : fields) {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clz);
			Method setter = pd.getWriteMethod();
			if(field.isAnnotationPresent(FruitName.class)){
				FruitName fruitName = field.getAnnotation(FruitName.class);
				FruitNm = FruitNm+":"+fruitName.value();
				System.err.println(FruitNm);
				setter.setAccessible(true);
				setter.invoke(obj, fruitName.value().toString());
			}else if(field.isAnnotationPresent(FruitColor.class)){
				FruitColor fruitClr = field.getAnnotation(FruitColor.class);
				FruitColor = FruitColor + ":"+ fruitClr.fruitColor().toString();
				System.err.println(FruitColor);
				setter.setAccessible(true);
				setter.invoke(obj, fruitClr.fruitColor().toString());
			}
		}
		return obj;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
		FruitAnnotationConfig fac = new FruitAnnotationConfig();
		Apple apple = (Apple) fac.getFruitConfigInf(Apple.class);
		System.err.println(apple.getAppleColor());
		System.err.println(apple.getAppleNm());
	}
}
