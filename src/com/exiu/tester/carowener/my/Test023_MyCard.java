package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test023_MyCard extends BaseTestCase {
	/**
	 * 我的页面 我的券卡 case
	 * 
	 * @throws Exception
	 */
	@Test
	public void 我的券卡() throws Exception {
		click(getId("我"));
		click(getId("我的券卡"));
		screenShoot("我的券卡"); // 截取当前页面并命名为 我的券卡
		compare("我的券卡", getId("列表Id"), getId("tableListName"));
		click(getId("使用记录"));
		screenShoot("我的券卡-使用记录");
		compare("我的券卡-使用记录", getId("列表Id"), getId("tableListName"));
	}
}
