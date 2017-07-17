package com.exiu.tester.carowener.home;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.api.CategorySelector;
import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;
@Listeners({com.exiu.developer.AssertionListener.class})
public class Test021_SupportCar extends BaseTestCase {

	/**全城养车
	 * 
	 * @throws Exception
	 */
	
//	@Test(priority=1)
	public void 全城养车() throws Exception {
		click(getId("汽车服务"));
		click(getId("城市"));
		citySelector.selectCity(getParameter("城市"));
		click(getId("全城养车"));
		click(getId("优质维保"));
		screenShoot("全城养车-优质维保");
		compare("全城养车-优质维保", getId("tableId1"), getId("tableListName"));
		
		click(getId("全城洗车"));
		screenShoot("全城养车-全城洗车");
//		compare("全城养车-全城洗车", getId("tableId1"), getId("tableListName"));
		
		click(getId("年检"));
		screenShoot("全城养车-年检");
//		compare("全城养车-年检", getId("tableId1"), getId("tableListName"));
	}
	
//	@Test(priority=2)
	public void 全城养车_搜索() throws Exception {
		click(getId("汽车服务"));
		click(getId("城市"));
		citySelector.selectCity(getParameter("城市"));
		click(getId("全城养车"));
		click(getId("全城洗车"));
		click(getId("搜索1"));	
		autoInput();
		click(getId("搜索2"));
		screenShoot("全城养车-搜索-全城洗车");
//		compare("全城养车-搜索-全城洗车", getId("tableId"), getId("tableListName"));
		Back();
		click(getId("优质维保"));
		click(getId("搜索1"));	
		autoInput();
		click(getId("搜索2"));
		screenShoot("全城养车-搜索-优质维保");
		compare("全城养车-搜索-优质维保", getId("tableId"), getId("tableListName"));
		Back();
		click(getId("年检"));
		click(getId("搜索1"));	
		autoInput();
		click(getId("搜索2"));
		screenShoot("全城养车-搜索-年检");
//		compare("全城养车-搜索-年检", getId("tableId"), getId("tableListName"));
	}
	@Test(priority=3)
	public void 全城养车_优惠活动() throws Exception {
		click(getId("汽车服务"));
		click(getId("城市"));
		citySelector.selectCity(getParameter("城市"));
		click(getId("全城养车"));
		click(getId("优惠活动"));
	    Thread.sleep(1000);
		screenShoot("全城养车-优惠活动");
	}
}