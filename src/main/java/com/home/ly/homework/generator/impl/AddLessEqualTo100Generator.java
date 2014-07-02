package com.home.ly.homework.generator.impl;

import java.util.Random;

import com.home.ly.homework.HomeworkImpl;
import com.home.ly.homework.IHomework;
import com.home.ly.homework.generator.IGenerator;

public class AddLessEqualTo100Generator implements IGenerator {
	
	private static int MAX_SUM = 100;
	private Random random = new Random();
	
	@Override
	public IHomework generateHomework() {
		int adder1 = generateAdder(MAX_SUM);
		int adder2 = generateAdder(MAX_SUM-adder1);
		
		IHomework homework = new HomeworkImpl();
		homework.setAHomework(adder1 + " + " + adder2);
		homework.setResult(Integer.toString(adder1+adder2));
		
		return homework;
	}
	
	private int generateAdder(int seed) {
		int adder = random.nextInt(seed);
		while (adder<=10 || adder>=90) {
			adder = random.nextInt(seed);
		}
		return adder;
	}

}
