package com.exiu.developer.impl;

import com.exiu.developer.BaseTest;

public class LevelTest extends BaseTest {
	protected void select(String content, String level1, String level2, String level3) {
		String[] split = content.split(",");
		click(loopFindElement(level1, split[0]));
		if (split.length > 1) {
			click(loopFindElement(level2, split[1]));
			if (split.length > 2) {
				click(loopFindElement(level3, split[2]));
			}
		}
	}
}
