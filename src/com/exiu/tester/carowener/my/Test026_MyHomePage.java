package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;
import com.sun.swing.internal.plaf.basic.resources.basic;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test026_MyHomePage extends BaseTestCase {

	/**
	 * 我的页面 我的主页case
	 * 
	 * @throws Exception
	 */

	@Test
	public void 我的主页() throws Exception {
		click(getId("我"));
		click(getId("我的主页"));
		screenShoot("我的主页");
		click(getId("我的主页编辑"));
		Assertion.verifyEquals(elementToStr(getId("title")), "个人信息");// 断言
																		// 验证页面跳转是否为个人信息页面
		Back();
		compare("我的动态", getId("动态list"), getId("动态内容"));
		String str = elementToStr(getId("浏览Num"));
		click(getId("谁看过我"));
		Assertion.verifyEquals(elementToStr(getId("title")), str);
		compare("我的动态", getId("列表Id"), getId("tableListName"));
		Back();
		click(getId("加入的群组"));
		// str=elementToStr(getId("群昵称"));
		Assertion.verifyEquals(elementToStr(getId("title")), "群主页");
		click(getId("进入群聊"));
		// Assertion.verifyEquals(elementToStr(getId("聊天title")), str);
		click(getId("群聊设置"));
		screenShoot("群信息");
		Back();
		Back();
		click(getId("编辑"));
		screenShoot("编辑群信息");
		click(getId("保存"));
		Assertion.verifyEquals(elementToStr(getId("title")), "群主页");

	}
}
