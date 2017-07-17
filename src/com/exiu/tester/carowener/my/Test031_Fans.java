package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test031_Fans extends BaseTestCase {

	/**
	 * 我的页面 粉丝case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 粉丝() throws Exception {
		click(getId("我"));
		click(getId("粉丝"));
		screenShoot("粉丝");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title1"));// 断言
																						// 页面跳转
		click(getId("收益规则"));
		screenShoot("收益规则");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title2"));
		Back();
		click(getId("邀请"));
		compare("FansList", getId("listId"), getId("listName"));

	}

}
