package com.exiu.developer.impl;

import com.exiu.api.CitySelector;

public class CitySelectorImpl extends LevelTest implements CitySelector {

	@Override
	public void selectCity(String id) {
		select(id, getId("l1"), getId("l2"), null);
	}

}
