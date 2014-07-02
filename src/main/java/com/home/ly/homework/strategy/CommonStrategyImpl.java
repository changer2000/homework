package com.home.ly.homework.strategy;

public abstract class CommonStrategyImpl implements IStrategy {

	private IStrategy nextStrategy;
	
	@Override
	public void addStrategy(IStrategy strategy) {
		if (nextStrategy==null)
			nextStrategy = strategy;
		else {
			IStrategy nxt = nextStrategy;
			while (nxt.getNextStrategy()!=null) {
				nxt = nxt.getNextStrategy();
			}
			nxt.addStrategy(strategy);
		}
	}
	
	@Override
	public IStrategy getNextStrategy() {
		return nextStrategy.getNextStrategy();
	}

}
