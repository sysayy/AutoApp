package com.exiu.tester.carowener.Chatting;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test038_AddressBook extends BaseTestCase {
	/**
	 * 逸聊 通讯录 case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 通讯录_新的朋友() throws Exception {
		click(getId("逸聊"));
		click(getId("通讯录"));
		click(getId("新的朋友"));
		click(getId("好友请求"));
		screenShoot("好友请求");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("newFriends"));
		compare("newFriewndsList", getId("请求List"), getId("好友请求Name"));
		compare("newFriewndsList", getId("请求List"), getId("好友请求status"));
		// 群组请求列表
		click(getId("群组请求"));
		screenShoot("群组请求");
		compare("newFriewndsList", getId("请求List"), getId("群组请求Name"));

		// 顾问请求列表
		click(getId("顾问请求"));
		screenShoot("顾问认证");
		compare("newFriewndsList", getId("请求List"), getId("顾问认证Name"));
		compare("newFriewndsList", getId("请求List"), getId("顾问认证status"));
	}

	
	@Test(priority = 2)
	public void 通讯录_我的群组() throws Exception {
		click(getId("逸聊"));
		click(getId("通讯录"));
		click(getId("我的群组"));
		screenShoot("我的群组");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("myGroup"));
		click(getId("去群组首页"));
		Assertion.verifyEquals(isExist(getId("创建群")), true,"跳转至 我的群组页面失败");
		
	}

	
	@Test(priority = 3)
	public void 通讯录_我的顾问() throws Exception {
		click(getId("逸聊"));
		click(getId("通讯录"));
		click(getId("我的顾问"));
		click(getId("已购买咨询"));
		screenShoot("已购买咨询");
//		compare("newFriewndsList", getId("请求List"), getId("顾问认证status"));
		click(getId("已关注顾问"));
		screenShoot("已关注顾问");
		compare("newFriewndsList", getId("请求List"), getId("顾问Name"));
		
		
	}
	@Test(priority = 4)
	public void 通讯录_我的客户() throws Exception {
		click(getId("逸聊"));
		click(getId("通讯录"));
		click(getId("我的客户"));
		screenShoot("我的客户");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("myClient"));
		click(getId("我的主页"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("ConsultantHomePage"));
		screenShoot("顾问主页");
		
		
	}

	
}
