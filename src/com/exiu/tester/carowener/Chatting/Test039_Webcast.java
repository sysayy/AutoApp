package com.exiu.tester.carowener.Chatting;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test039_Webcast extends BaseTestCase {
	/**
	 * 逸聊 网络直拨 case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 网络直播() throws Exception {
		click(getId("逸聊"));
		click(getId("网络直拨"));
		dial.dial(getParameter("phone"));
		screenShoot("拨号");
		click(getId("结束"));
		delPhoneNum(getParameter("phone"));
		click(getId("hideKeyboard"));
		String phoneNum = elementToStr(getId("phoneNum"));
		phoneNum = conversionNumber.conversionNum(phoneNum);
		System.out.println(phoneNum);
		Assertion.verifyEquals(phoneNum, getParameter("phone"));
		click(getId("hideKeyboard"));
		click(getId("话费"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("FreeCalls"));
	}

}
