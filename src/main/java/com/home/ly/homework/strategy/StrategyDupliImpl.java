package com.home.ly.homework.strategy;

import java.util.HashMap;
import java.util.Map;

import com.home.ly.homework.IHomework;

public class StrategyDupliImpl extends CommonStrategyImpl {
	
	private Map<String, IHomework> homeworkMap = new HashMap<String, IHomework>();
	
	@Override
	public boolean isPassedCheck(IHomework homework) {
		if (homework!=null) {
			if (homeworkMap.get(homework.getAHomework())==null) {
				homeworkMap.put(homework.getAHomework(), homework);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
