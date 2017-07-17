package com.exiu.tester.carowener.home;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;
@Listeners({com.exiu.developer.AssertionListener.class})
public class Test018_QuickPayment extends BaseTestCase {

	/**快捷付款
	 * 
	 * @throws Exception
	 */
	
//	@Test(priority=1)
	public void 快捷付款() throws Exception {
		click(getId("汽车服务"));
		click(getId("快捷付款"));
		swipUp();
		autoInput("消费");
		click(getId("余额支付"));
		click(getId("确认支付"));
		screenShoot("普通-消费");
		Assertion.verifyEquals(elementToStr(getId("title")), "订单详情");
	}
	
//	@Test(priority=2)
	public void 快捷付款_维修() throws Exception {
		click(getId("汽车服务"));
		click(getId("快捷付款"));
		click(getId("维修"));
		autoInput("工时");
		click(getId("余额支付"));
		click(getId("确认支付"));
		screenShoot("工时-消费");
		Assertion.verifyEquals(elementToStr(getId("title")), "订单详情");
	}
	
	@Test(priority=3)
	public void 快捷付款_搜索() throws Exception {
		click(getId("汽车服务"));
		click(getId("快捷付款"));
		click(getId("更换商家"));
		compare("快捷付款_搜索1",  getId("tableId"), getId("tableListName"));
		click(getId("搜索商家"));
		autoInput("搜索");
		click(getId("搜索"));
		compare("快捷付款_搜索2",  getId("tableId"), getId("tableListName"));
	}
}
