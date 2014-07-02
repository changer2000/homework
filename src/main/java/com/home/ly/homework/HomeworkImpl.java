package com.home.ly.homework;

import org.apache.commons.lang3.StringUtils;


public class HomeworkImpl implements IHomework {
	
	private String aHomework;
	private String result;
	private String answer;


	@Override
	public boolean isRight() {
		return StringUtils.equals(StringUtils.trimToEmpty(result), StringUtils.trimToEmpty(answer));
	}
	
	@Override
	public String getAHomework() {
		return aHomework;
	}

	@Override
	public void setAHomework(String homework) {
		this.aHomework = homework;
	}

	@Override
	public String getResult() {
		return result;
	}

	@Override
	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String getAnswer() {
		return this.answer;
	}

	@Override
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
