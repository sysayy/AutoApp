package com.exiu.tester.carowener.home;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

//自定义监听
@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test004_City extends BaseTestCase {
	@Test
	public void 更换城市() {
		// 点击首页
		click(getId("汽车服务"));
		click(getId("城市"));// 点击城市选择
		citySelector.selectCity(getParameter("城市"));// 选择城市
													// 根据Parameter里配置的城市进行选择
		// 验证信息 期望与实际值是否相同 不同 控制台打印信息
		Assertion.verifyEquals(elementToStr(getId("城市")), getParameter("验证"));
	}
}
