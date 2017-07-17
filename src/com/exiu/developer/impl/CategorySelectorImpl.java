package com.exiu.developer.impl;

import com.exiu.api.CategorySelector;

public class CategorySelectorImpl extends LevelTest implements CategorySelector {

	@Override
	public void selectCategory(String id) {
		select(id, getId("l1"), getId("l2"), null);
	}

}
