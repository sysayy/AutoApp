package com.exiu.developer.impl;

import com.exiu.api.InterestSelector;

public class InterestSelectImpl extends LevelTest implements InterestSelector {

	@Override
	public void selectInterest(String id) {
		select(id, getId("l1"), getId("l2"), null);
	}

}
