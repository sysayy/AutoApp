package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test028_InsuranceOrder extends BaseTestCase {
	/**
	 * 我的页面 保险订单 case
	 * 
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 保险订单() throws Exception {
		click(getId("我"));
		click(getId("保险订单"));
		screenShoot("保险订单");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title"));// 断言
																					// 页面跳转
	}

}
