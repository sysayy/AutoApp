package com.exiu.tester.carowener.home;
import org.testng.annotations.Test;
import com.exiu.developer.BaseTestCase;

public class Test012_FreeTicket extends BaseTestCase {

	/**免费领券
	 * 
	 * @throws Exception
	 */
	
	@Test(priority=1)
	public void 领券中心() throws Exception {
		click(getId("汽车服务"));
		click(getId("免费领券"));
		click(getId("领券中心"));
		screenShoot("领券中心");
		compare("领券中心", getId("tableId"), getId("tableListName1"));
	
	}
	@Test(priority=2)
	public void 特价服务() throws Exception {
		click(getId("汽车服务"));
		click(getId("免费领券"));
		click(getId("特价服务"));
		screenShoot("特价服务");
		compare("特价服务", getId("tableId"), getId("tableListName2"));
	
	}
	@Test(priority=3)
	public void 特价商品() throws Exception {
		click(getId("汽车服务"));
		click(getId("免费领券"));
		click(getId("特价商品"));
		screenShoot("特价商品");
		compare("特价商品", getId("tableId"), getId("tableListName2"));
	
	}
	
}
