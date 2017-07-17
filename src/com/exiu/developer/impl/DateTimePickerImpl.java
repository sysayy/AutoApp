package com.exiu.developer.impl;

import org.openqa.selenium.WebElement;

import com.exiu.api.DateTimePicker;
import com.exiu.developer.BaseTestImpl;

public class DateTimePickerImpl extends BaseTestImpl implements DateTimePicker {
	private final int times = 1000;

	@Override
	public void pickDate(String date) {
		String[] split = date.split("-");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);

		WebElement yearElement = findElement(getId("year"));
		WebElement monthElement = findElement(getId("month"));
		WebElement dayElement = findElement(getId("day"));
		while (true) {
			int parseInt = Integer.parseInt(yearElement.getText());
			if (year == parseInt) {
				break;
			} else if (year > parseInt) {
				click("com.exiu.exiucarowner:id/pop_title_right_iv");
			} else {
				click("com.exiu.exiucarowner:id/pop_title_left_iv");
			}
		}
		while (true) {
			int parseInt = Integer.parseInt(monthElement.getAttribute("name"));
			if (month == parseInt) {
				break;
			} else if (month > parseInt) {
				swipeUp(monthElement, times);
			} else {
				swipeDown(monthElement, times);
			}
		}
		while (true) {
			int parseInt = Integer.parseInt(dayElement.getAttribute("name"));
			if (day == parseInt) {
				break;
			} else if (day > parseInt) {
				swipeUp(dayElement, times);
			} else {
				swipeDown(dayElement, times);
			}
		}
		click("com.exiu.exiucarowner:id/pop_sure_iv");
	}

	@Override
	public void pickDateTime(String dateTime) {
		String[] split = dateTime.split("-");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);
		int hour = 0;
		if (split.length >= 4) {
			hour = Integer.parseInt(split[3]);
		}
		int min = 0;
		if (split.length >= 5) {
			min = Integer.parseInt(split[4]);
		}
		WebElement yearElement = findElement(getId("year"));
		while (true) {
			String text = yearElement.getText();
			if (!isAndroid) {
				text = text.replace("年", "").trim();
			}
			int parseInt = Integer.parseInt(text);
			if (year == parseInt) {
				break;
			} else if (year > parseInt) {
				click(getId("yearAdd"));
			} else {
				click(getId("yearMin"));
			}
		}
		WebElement monthElement = findElement(getId("month"));
		while (true) {
			String attribute = null;
			if (isAndroid) {
				attribute = monthElement.getAttribute("name");
			} else {
				String string = monthElement.getText().split(",")[0];
				attribute = string.substring(0, string.length() - 1);
			}
			int parseInt = Integer.parseInt(attribute);
			if (month == parseInt) {
				break;
			} else if (month > parseInt) {
				up(monthElement);
			} else {
				down(monthElement);
			}
		}
		WebElement dayElement = findElement(getId("day"));
		while (true) {
			String attribute = null;
			if (isAndroid) {
				attribute = dayElement.getAttribute("name");
			} else {
				String string = dayElement.getText().split(",")[0];
				attribute = string.substring(0, string.length() - 1);
			}
			int parseInt = Integer.parseInt(attribute);
			if (day == parseInt) {
				break;
			} else if (day > parseInt) {
				up(dayElement);
			} else {
				down(dayElement);
			}
		}
		WebElement hourElement = findElement(getId("hour"));
		while (true) {
			if (hourElement == null) {
				break;
			}
			String attribute = null;
			if (isAndroid) {
				attribute = hourElement.getAttribute("name");
			} else {
				String string = hourElement.getText().split(",")[0];
				attribute = string.substring(0, string.length() - 1);
			}
			int parseInt = Integer.parseInt(attribute);
			if (hour == parseInt) {
				break;
			} else if (hour > parseInt) {
				up(hourElement);
			} else {
				down(hourElement);
			}
		}
		WebElement minElement = findElement(getId("min"));
		while (true) {
			if (minElement == null) {
				break;
			}
			String attribute = null;
			if (isAndroid) {
				attribute = minElement.getAttribute("name");
			} else {
				String string = minElement.getText().split(",")[0];
				attribute = string.substring(0, string.length() - 1);
			}
			int parseInt = Integer.parseInt(attribute);
			if (min == parseInt) {
				break;
			} else if (min > parseInt) {
				up(minElement);
			} else {
				down(minElement);
			}
		}
		click(getId("sure"));
	}

	private void down(WebElement monthElement) {
		if (isAndroid) {
			swipeDown(monthElement, times);
		} else {
			clickTop(monthElement);
		}
	}

	private void up(WebElement monthElement) {
		if (isAndroid) {
			swipeUp(monthElement, times);
		} else {
			clickBottom(monthElement);
		}
	}

	@Override
	public void pickDateTime_Carpool(String id, String dateTime) {
		click(id);
		String[] split = dateTime.split(" ");
		String[] date = split[0].split("-");
		String[] time = split[1].split(":");
		int month = Integer.parseInt(date[0]);
		int day = Integer.parseInt(date[1]);
		int hour = Integer.parseInt(time[0]);
		int minute = Integer.parseInt(time[1]);
		loop(month, "monthX");
		loop(day, "dayX");
		loop(hour, "hourX");
		loop(minute, "minuteX");
		click(getId("sure"));
	}

	private void loop(int hour, String propName) {
		WebElement hourElement = findElement(getId(propName));
		while (true) {
			String attribute = null;
			if (isAndroid) {
				WebElement hourSon = findElement(hourElement, "android:id/numberpicker_input");
				attribute = hourSon.getText();
			} else {
				String string = hourElement.getText().split(",")[0];
				attribute = string.substring(0, string.length() - 1);
			}
			int parseInt = Integer.parseInt(attribute);
			if (hour == parseInt) {
				break;
			} else if (hour > parseInt) {
				up(hourElement);
			} else {
				down(hourElement);
			}
		}
	}
}
