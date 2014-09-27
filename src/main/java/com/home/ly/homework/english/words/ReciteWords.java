package com.home.ly.homework.english.words;

import org.aspectj.util.FileUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.ly.homework.service.WordService;
import com.home.system.utils.AppUtils;

public class ReciteWords {
	
	public static void main(String[] args) {
		
		
		WordService wordSvc = (WordService) AppUtils.getContext().getBean(WordService.class);
		System.out.println(wordSvc.saveOneWord("one", "1").getId());
		
		//FileUtil.read
		
		AppUtils.releaseContext();
	}
	
}
