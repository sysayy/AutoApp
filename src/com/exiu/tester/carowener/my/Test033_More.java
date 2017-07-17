package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test033_More extends BaseTestCase {
	/**
	 * 我的页面 更多 case
	 * 
	 * @throws Exception
	 */

//	@Test(priority = 1)
	public void 反馈信息() throws Exception {
		click(getId("我"));
		swipUp();
		click(getId("更多"));
		screenShoot("更多");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_more"));// 断言页面跳转
		click(getId("反馈信息"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_fkxx"));// 断言页面跳转
		autoInput("反馈信息");
		click(getId("提交"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_more"));// 断言页面跳转
	}

//	@Test(priority = 2)
	public void 修改密码() throws Exception {
		click(getId("我"));
		swipUp();
		click(getId("更多"));
		screenShoot("更多");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_more"));// 断言页面跳转
		click(getId("修改密码"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_xgmm"));// 断言页面跳转
		autoInput("修改密码");
		click(getId("确定"));

	}

	@Test(priority = 3)
	public void 关于我们() throws Exception {
		click(getId("我"));
		swipUp();
		click(getId("更多"));
		screenShoot("更多");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_more"));// 断言页面跳转
		click(getId("关于我们"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_gywm"));// 断言页面跳转
		String str = elementToStr(getId("版本号"));
		System.out.println("--------> 当前安装的版本号为：" + str);
		click(getId("平台介绍"));
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title_ptjs"));// 断言页面跳转
		Back();
		click(getId("客服电话"));
		screenShoot("拨打客服电话");
		Assertion.verifyEquals(isExist(getId("取消")), true ,"拨打客服电话失败");
	}
}
