package com.home.ly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.home.ly.homework.IHomework;
import com.home.ly.homework.constants.Constants;
import com.home.ly.homework.generator.impl.AddLessEqualTo100Generator;
import com.home.ly.homework.generator.impl.MinusLess100GeneratorImpl;
import com.home.ly.homework.strategy.IStrategy;
import com.home.ly.homework.strategy.StrategyDupliImpl;

public class Am {
	
	public static final int HOMEWORK_CNT = 20;
	private String type=null;
	
	public Am(String type) {
		this.type = type;
	}
	
	public static void main(String[] args) {
		String type = null;
		if (args!=null && args.length>0)
			type = args[0];
		
		for (int i=0; i<50; i++) {
			Am am = new Am(type);
			am.doHomework();
			System.out.println("");
		}
		
	}
	
	public void doHomework() {
		List<IHomework> adderHomeworkList = new ArrayList<IHomework>();
		List<IHomework> minusHomeworkList = new ArrayList<IHomework>();
		
		generateHomework(adderHomeworkList, minusHomeworkList);
		qa(adderHomeworkList, minusHomeworkList);
		
	}
	
	protected void generateHomework(List<IHomework> adderHomeworkList, List<IHomework> minusHomeworkList) {
		IStrategy strategy = new StrategyDupliImpl();
		
		AddLessEqualTo100Generator g = new AddLessEqualTo100Generator();
		for (int i=0; i<HOMEWORK_CNT; i++) {
			IHomework homework = g.generateHomework();
			if (strategy.isPassedCheck(homework)) {
				adderHomeworkList.add(homework);
				//System.out.println(homework.getAHomework() + " = " + homework.getResult());
			} else {
				i--;
			}
		}
		
		MinusLess100GeneratorImpl m = new MinusLess100GeneratorImpl();
		for (int i=0; i<HOMEWORK_CNT; i++) {
			IHomework homework = m.generateHomework();
			if (strategy.isPassedCheck(homework)) {
				minusHomeworkList.add(homework);
				//System.out.println(homework.getAHomework() + " = " + homework.getResult());
			} else {
				i--;
			}
		}
		
	}
	
	protected void qa(List<IHomework> adderHomeworkList, List<IHomework> minusHomeworkList) {
		
		Random random = new Random();
		while (adderHomeworkList.size()>0 && minusHomeworkList.size()>0) {
			IHomework homework = null;
			int flg = random.nextInt(2);
			if (flg==0) {
				homework = adderHomeworkList.get(0);
				adderHomeworkList.remove(0);
			} else {
				homework = minusHomeworkList.get(0);
				minusHomeworkList.remove(0);
			}
			while (true) {
				System.out.print(homework.getAHomework() + " = ");
				if (Constants.DIRECT_PRINT.equals(this.type)) {
					System.out.println("");
					break;
				}
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String result = null;
				try {
					result = in.readLine();
				} catch (Exception e) {
					
				}
				if (!StringUtils.equals(StringUtils.trimToEmpty(result), homework.getResult())) {
					System.out.println(" 答错了。小越越，再想一想...... ");
				} else {
					System.out.println(" 答对了。小越越真棒！ ");
					break;
				}
			}
		}
		
		if (adderHomeworkList.size()>0) {
			qa(adderHomeworkList);
		} else if (minusHomeworkList.size()>0) {
			qa(minusHomeworkList);
		}
		
	}
	
	protected void qa(List<IHomework> homeworkList) {
		while (homeworkList.size()>0) {
			IHomework homework = homeworkList.get(0);
			homeworkList.remove(0);
			while (true) {
				System.out.print(homework.getAHomework() + " = ");
				if (Constants.DIRECT_PRINT.equals(this.type)) {
					System.out.println("");
					break;
				}
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String result = null;
				try {
					result = in.readLine();
				} catch (Exception e) {
					
				}
				if (!StringUtils.equals(StringUtils.trimToEmpty(result), homework.getResult())) {
					System.out.println(" 答错了。小越越，再想一想...... ");
				} else {
					System.out.println(" 答对了。小越越真棒！ ");
					break;
				}
			}
		}
		
	}

}
