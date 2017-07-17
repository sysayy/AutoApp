package com.exiu.tester.carowener.home;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

/**
 * 
 * @author sys 爱车服务-常用服务
 *
 */
public class Test003_CarServer extends BaseTestCase {

	@Test(priority = 1)
	public void 修车() {
		click(getId("汽车服务"));// 点击首页爱车服务
		click(getId("服务商家"));// 点击服务商家
		click(getId("修车"));
		// 设置查询条件 在parameters 对应的android/ios 下配置筛选条件
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		// configs 下globle里的isStandard 为true:标定过程 为flase: test过程
		compare(parameter, getId("tableId"), getId("tableListName"));
	}

	@Test(priority = 2)
	public void 洗车() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("洗车"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter + "2", getId("tableId"), getId("tableListName"));
	}

	@Test(priority = 3)
	public void 停车() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("停车"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter + "3", getId("tableId"), getId("tableListName"));
	}

	@Test(priority = 5)
	public void 加油站() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("加油站"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter + "4", getId("tableId"), getId("tableListName"));
	}

	@Test(priority = 4)
	public void 钥匙店() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("钥匙店"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter + "5", getId("tableId"), getId("tableListName"));
	}

	@Test(priority = 6)
	public void 四S店() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("4S店"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter + "6", getId("tableId"), getId("tableListName"));
	}

	@Test(priority = 7)
	public void 轮胎服务() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("轮胎服务"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter + "7", getId("tableId"), getId("tableListName"));
	}

	@Test(priority = 8)
	public void 汽车用品() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("汽车用品"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter + "8", getId("tableId"), getId("tableListName"));
	}

}
