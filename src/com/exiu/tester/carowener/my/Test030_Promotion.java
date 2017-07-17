package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test030_Promotion extends BaseTestCase {

	/**
	 * 我的页面 推广赚钱case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 推广赚钱() throws Exception {
		click(getId("我"));
		click(getId("推广赚钱"));
		screenShoot("推广赚钱");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title1"));// 断言
																						// 页面跳转
		click(getId("收益规则"));
		screenShoot("收益规则");
		Back();
		click(getId("点击分享"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title2"));
		click(getId("分享"));
		if (eleIsExist("微信好友") != true) {
			screenShoot("分享");
		} else {
			screenShoot("分享");
			System.out.println("------> 分享页面没有出现");
		}
	}

}
