package com.exiu.developer.impl;

import com.exiu.api.SortFilter;

public class SortFilterImpl extends LevelTest implements SortFilter {

	@Override
	public void sortFilter(String string) {
		select(string, null, getId("l1"), getId("l2"));
	}

	@Override
	public void sortFilter(String content, String level1, String level2, String level3) {
		select(content, level1, level2, level3);
	}

}
