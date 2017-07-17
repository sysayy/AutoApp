package com.exiu.tester.carowener.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;
/**
 *私密挪车
 * @author exlm
 *
 */
public class Test011_MoveCar extends BaseTestCase {
 
	/**
	 * 1.汽车服务页面进入私密挪车
	 * 输入车牌号挪车
	 * @throws Exception
	 */
	
	@Test
	public void 私密挪车() throws Exception {
		click(getId("汽车服务"));
		click(getId("私密挪车"));
		carPlateInput.sendCarArea(getId("地区缩写"), "云");
		carPlateInput.sendCarPlate(getId("车牌号"), "A12345");
		click(getId("我要挪车"));
	}
}
