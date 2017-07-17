package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test022_MyOrder extends BaseTestCase {
	/**
	 * 我的页面
	 * 
	 * 我的订单case
	 * 
	 * @throws Exception
	 */
	@Test
	public void 我的订单() throws Exception {
		click(getId("我"));
		click(getId("我的订单"));
		compare("订单列表-全部", getId("tableId"), getId("tableListName"));
		click(getId("待处理"));
		compare("订单列表-待处理", getId("tableId"), getId("tableListName"));
		click(getId("已完成"));
		compare("订单列表-已完成", getId("tableId"), getId("tableListName"));
		click(getId("已取消"));
		compare("订单列表-已取消", getId("tableId"), getId("tableListName"));
		click(getId("全部"));
		click(getId("order"));
		Assertion.verifyEquals(elementToStr(getId("orderName")), getParameter("orderName"), "orderName不正确");
	}
}
