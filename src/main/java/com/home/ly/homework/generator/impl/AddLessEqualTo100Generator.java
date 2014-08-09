package com.home.ly.homework.generator.impl;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.home.ly.homework.HomeworkImpl;
import com.home.ly.homework.IHomework;
import com.home.ly.homework.generator.IGenerator;

public class AddLessEqualTo100Generator implements IGenerator {
	
	private static int MAX_SUM = 100;
	private Random random = new Random();
	
	@Override
	public IHomework generateHomework() {
		IHomework homework = null;
		while (true) {
			int adder1 = generateAdder(MAX_SUM);
			int adder11 = Integer.valueOf(StringUtils.right(adder1+"", 1)).intValue();
			if (adder1<10 || adder1>90 || adder11<6) {
				random = new Random();
				continue;
			}
			
			
			int adder2 = generateAdder(MAX_SUM-adder1);
			int adder21 = Integer.valueOf(StringUtils.right(adder2+"", 1)).intValue();
			while (adder11+adder21<=10) {
				adder2 = generateAdder(MAX_SUM-adder1);
				adder21 = Integer.valueOf(StringUtils.right(adder2+"", 1)).intValue();
			}
			
			homework = new HomeworkImpl();
			homework.setAHomework(adder1 + " + " + adder2);
			homework.setResult(Integer.toString(adder1+adder2));
			break;
		}
		return homework;
	}
	
	private int generateAdder(int seed) {
		int adder = random.nextInt(seed);
		adder = random.nextInt(seed);
		return adder;
	}

}
