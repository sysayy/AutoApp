package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test024_CarInfo extends BaseTestCase {

	/**
	 * 我的页面 爱车信息case
	 * 
	 * @throws Exception
	 */

	@Test
	public void 爱车信息() throws Exception {
		click(getId("我"));
		click(getId("爱车信息"));
		click(getId("品牌型号"));
		carSelect.selectCar(getParameter("car")); // 选择车型
		click(getId("车牌号"));
		carPlateInput.sendCarArea(getId("地区缩写"), "云"); // 设置车牌
		carPlateInput.sendCarPlate(getId("车牌"), "A12345");
		click(getId("保存"));
		carInfo(getId("变速箱"), getParameter("自动")); // 设置车辆信息
		carInfo(getId("车辆颜色"), getParameter("银色"));// 设置车辆信息
		carInfo(getId("里程"), getParameter("20~40"));// 设置车辆信息
		carInfo(getId("座位数"), getParameter("5座"));// 设置车辆信息
		carInfo(getId("车辆配置"), getParameter("天窗"));// 设置车辆信息
		screenShoot("车辆信息");
	}
}
