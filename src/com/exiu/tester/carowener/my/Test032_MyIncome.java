package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test032_MyIncome extends BaseTestCase {
	/**
	 * 我的页面 我的收益 case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 我的收益() throws Exception {
		click(getId("我"));
		click(getId("我的收益"));
		screenShoot("我的收益");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title1"));// 断言页面跳转
		click(getId("收益明细"));
		screenShoot("收益明细");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title2"));
		Back();
		

	}

}
