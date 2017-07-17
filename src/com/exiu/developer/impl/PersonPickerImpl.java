package com.exiu.developer.impl;

import org.openqa.selenium.WebElement;

import com.exiu.api.PersonPicker;
import com.exiu.developer.BaseTestImpl;

public class PersonPickerImpl extends BaseTestImpl implements PersonPicker {
	private void loop(int hour, String propName) {
		WebElement hourElement = findElement(getId(propName));
		while (true) {
			String attribute = null;
			if (isAndroid) {
				WebElement hourSon = findElement(hourElement, "android:id/numberpicker_input");
				attribute = hourSon.getText();
			} else {
				attribute = hourElement.getText().split(",")[0];
			}
			attribute = attribute.substring(0, attribute.length() - 1);
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

	private void down(WebElement monthElement) {
		if (isAndroid) {
			swipeDown(monthElement, 1000);
		} else {
			clickTop(monthElement);
		}
	}

	private void up(WebElement monthElement) {
		if (isAndroid) {
			swipeUp(monthElement, 1000);
		} else {
			clickBottom(monthElement);
		}
	}

	@Override
	public void pickPerson(String id, String count) {
		click(id);
		int person = Integer.parseInt(count);
		loop(person, "person");
		click(getId("sure"));
	}

}
