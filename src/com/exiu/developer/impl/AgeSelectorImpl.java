package com.exiu.developer.impl;

import org.openqa.selenium.WebElement;

import com.exiu.api.AgeSelector;
import com.exiu.developer.BaseTestImpl;

public class AgeSelectorImpl extends BaseTestImpl implements AgeSelector {
	private final int times = 1500;

	@Override
	public void selectPersonalAge(String info) {
		String[] split = info.split(",");
		click(split[0]);
		WebElement year = findElement("com.exiu.exiucarowner:id/picker_year");
		WebElement month = findElement("com.exiu.exiucarowner:id/picker_month");
		WebElement day = findElement("com.exiu.exiucarowner:id/picker_day");
		WebElement element = findElement("com.exiu.exiucarowner:id/tv_date");
		String date = split[1];
		String[] dates = date.split("-");
		int dateYear = Integer.parseInt(dates[0]);
		while (true) {
			String text = element.getText();
			String[] texts = text.split("-");
			int i = Integer.parseInt(texts[0]);
			if (i == dateYear) {
				break;
			} else if (i > dateYear) {
				swipeDown(year, times);
			} else {
				swipeUp(year, times);
			}
		}
		while (true) {
			String text = element.getText();
			String[] texts = text.split("-");
			int i = Integer.parseInt(texts[1]);
			if (i == Integer.parseInt(dates[1])) {
				break;
			} else if (i > Integer.parseInt(dates[1])) {
				swipeDown(month, times);
			} else {
				swipeUp(month, times);
			}
		}
		while (true) {
			String text = element.getText();
			String[] texts = text.split("-");
			int i = Integer.parseInt(texts[2]);
			if (i == Integer.parseInt(dates[2])) {
				break;
			} else if (i > Integer.parseInt(dates[2])) {
				swipeDown(day, times);
			} else {
				swipeUp(day, times);
			}
		}
		click("确定");
	}

}
