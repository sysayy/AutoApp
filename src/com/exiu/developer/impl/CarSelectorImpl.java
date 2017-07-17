package com.exiu.developer.impl;

import com.exiu.api.CarSelector;


public class CarSelectorImpl extends LevelTest implements CarSelector {

	@Override
	public void selectCar(String id) {
		select(id, getId("l1"), getId("l2"), getId("l3"));
	}

}
