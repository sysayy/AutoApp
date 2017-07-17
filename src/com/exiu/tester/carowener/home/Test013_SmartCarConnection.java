package com.exiu.tester.carowener.home;
import org.testng.annotations.Test;
import com.exiu.developer.BaseTestCase;

public class Test013_SmartCarConnection extends BaseTestCase {

	/**智能车联
	 * 
	 * @throws Exception
	 */
	
	@Test(priority=1)
	public void 智能车联() throws Exception {
		click(getId("汽车服务"));
		click(getId("智能车联"));
	    autoInput();
	    click(getId("激活设备"));
	}
	
	
}
