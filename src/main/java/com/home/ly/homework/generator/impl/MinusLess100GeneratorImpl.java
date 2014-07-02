package com.home.ly.homework.generator.impl;

import java.util.Random;

import com.home.ly.homework.HomeworkImpl;
import com.home.ly.homework.IHomework;
import com.home.ly.homework.generator.IGenerator;

public class MinusLess100GeneratorImpl implements IGenerator {

	private static int MAX_SUM = 100;
	private static int THE_CNT_LESS_THAN_10 = 7;
	private Random random = new Random();
	private int cntLessThan10 = 0;
	
	@Override
	public IHomework generateHomework() {
		int minuend = generateMinuend();
		int subtractor = generateSubtractor(minuend);
		
		IHomework homework = new HomeworkImpl();
		homework.setAHomework(minuend + " - " + subtractor);
		homework.setResult(Integer.toString(minuend-subtractor));
		return homework;
	}
	
	public int generateMinuend() {
		int val = random.nextInt(MAX_SUM);
		while (val<=10) {
			val = random.nextInt(MAX_SUM);
		}
		return val;
	}
	
	public int generateSubtractor(int minuend) {
		int val = random.nextInt(minuend);
		if (val<=10 && cntLessThan10 < THE_CNT_LESS_THAN_10) {
			cntLessThan10++;
			return val;
		}
		while (val<=10) {
			val = random.nextInt(minuend);
		}
		return val;
		
	}

}
