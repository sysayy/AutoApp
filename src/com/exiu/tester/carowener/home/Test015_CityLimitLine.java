package com.exiu.tester.carowener.home;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

public class Test015_CityLimitLine extends BaseTestCase {

	/**城市限行
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 城市限行() throws Exception {
		click(getId("汽车服务"));
		click(getId("城市限行"));
		click(getId("时间设置"));
		dateTimePicker.pickDate(getParameter("date"));
		// click(getId("城市"));
		// citySelector.selectCity(getParameter("城市"));
		// screenShoot("城市限行" + getParameter("城市"));
		// compare("城市限行", getId("tableId"), getId("tableListName"));

	}

}
