package com.craftsman.util;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
 
public class ThreadUtils {
	public static ThreadPoolTaskExecutor getThread(){
		ApplicationContext ac=new ClassPathXmlApplicationContext();
		HashMap h =new HashMap();
		ThreadPoolTaskExecutor taskExecutor=(ThreadPoolTaskExecutor) ac.getBean("taskThread");
		return null;
	}
}
