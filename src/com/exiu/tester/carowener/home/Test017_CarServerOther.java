package com.exiu.tester.carowener.home;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

/**
 * 
 * @author sys
 * 爱车服务-其他服务
 *
 */
public class Test017_CarServerOther extends BaseTestCase {

	@Test(priority=1)
	public void 汽车改装() {
	
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("汽车改装"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter+"汽车改装", getId("tableId"), getId("tableListName"));
	}
	@Test(priority=2)
	public void 换油中心() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("换油中心"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter+"换油中心", getId("tableId"), getId("tableListName"));
	}
	@Test(priority=3)
	public void 变速箱() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("变速箱"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter+"变速箱", getId("tableId"), getId("tableListName"));
	}
	
	@Test(priority=4)
	public void 蓄电池() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("蓄电池"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter+"蓄电池", getId("tableId"), getId("tableListName"));
	}
	@Test(priority=5)
	public void 外观修复() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("外观修复"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter+"外观修复", getId("tableId"), getId("tableListName"));
	}
	@Test(priority=6)
	public void 汽车玻璃() {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("汽车玻璃"));
		String parameter = getParameter("sortRight");
		sortFilter.sortFilter(parameter);
		compare(parameter+"汽车玻璃", getId("tableId"), getId("tableListName"));
	}
	
	
	
	
}
