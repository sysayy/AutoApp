package com.exiu.developer.impl;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.exiu.api.CarPlateInput;
import com.exiu.developer.BaseTestImpl;
import com.exiu.util.StringUtil;

public class CarPlateInputImpl extends BaseTestImpl implements CarPlateInput {

	@Override
	public void sendCarPlate(String id, String carPlate) {
		char[] charArray = carPlate.toCharArray();
		if (isAndroid) {
			click("com.exiu.exiucarowner:id/delete");
			click(id);
			WebElement element = findElement("com.exiu.exiucarowner:id/keyboard_view");
			if (element == null) {
				return;
			}
			if (StringUtil.isEmpty(carPlate)) {
				return;
			}
			Point location = element.getLocation();
			Dimension size = element.getSize();
			int x = location.getX();
			int y = location.getY();
			int height = size.getHeight() / 8;
			int width = size.getWidth() / 20;
			List<String> list = Arrays.asList(carPlates);
			for (char c : charArray) {
				int index = list.indexOf(c + "");
				int clickY = y + height * (1 + (index / 10) * 2);
				int clickX = x + width * (1 + (index % 10) * 2);
				driver.tap(1, clickX, clickY, 100);
			}
			click("com.exiu.exiucarowner:id/close");
		} else {
			click("car delete icon");
			click(id);
			for (char c : charArray) {
				String s = String.valueOf(c);
				click(s);
			}
			click("隐藏键盘");
		}

	}

	private String[] carAreas = { "京", "津", "冀", "鲁", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "豫", "鄂",
			"湘", "粤", "桂", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "琼", "新", "台", "宁", "" };
	private String[] carPlates = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Q", "W", "E", "R", "T", "Y", "U",
			"I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M" };

	@Override
	public void sendCarArea(String id, String carArea) {
		char[] charArray = carArea.toCharArray();
		click(id);
		if (isAndroid) {
			WebElement element = findElement("com.exiu.exiucarowner:id/keyboard_view");
			if (element == null) {
				return;
			}
			if (StringUtil.isEmpty(carArea)) {
				return;
			}
			Point location = element.getLocation();
			Dimension size = element.getSize();
			int x = location.getX();
			int y = location.getY();
			int height = size.getHeight() / 8;
			int width = size.getWidth() / 20;
			List<String> list = Arrays.asList(carAreas);
			for (char c : charArray) {
				int index = list.indexOf(c + "");
				int clickY = y + height * (1 + (index / 10) * 2);
				int clickX = x + width * (1 + (index % 10) * 2);
				driver.tap(1, clickX, clickY, 100);
			}
			click("com.exiu.exiucarowner:id/close");
		} else {
			for (char c : charArray) {
				click(c + "");
			}
		}

	}
}
