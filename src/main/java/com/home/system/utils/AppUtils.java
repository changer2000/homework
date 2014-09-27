package com.home.system.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppUtils {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:root-config.xml");
	
	public static ApplicationContext getContext() {
		return context;
	}
	
	public static void releaseContext() {
		((ClassPathXmlApplicationContext) context).destroy();
	}
}
