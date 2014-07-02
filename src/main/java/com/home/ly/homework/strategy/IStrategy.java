package com.home.ly.homework.strategy;

import com.home.ly.homework.IHomework;

public interface IStrategy {
	public void addStrategy(IStrategy strategy);
	public IStrategy getNextStrategy();
	public boolean isPassedCheck(IHomework homework);
}
