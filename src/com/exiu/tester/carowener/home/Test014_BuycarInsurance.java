package com.exiu.tester.carowener.home;
import org.testng.annotations.Test;
import com.exiu.developer.BaseTestCase;

public class Test014_BuycarInsurance extends BaseTestCase {

	/**购买车险
	 * 
	 * @throws Exception
	 */
	
	@Test(priority=1)
	public void 购买车险() throws Exception {
		click(getId("汽车服务"));
		click(getId("购买车险"));
	//点击购买车险
//		driver.findElementByXPath("/html/body/div[5]/div/div/div[2]/div[2]/div[2]/div/a").click();
		for(String winHandle : driver.getWindowHandles()){
			System.out.println("------> "+winHandle);
		    driver.switchTo().window(winHandle);
		    System.out.println("------>   ios 切换到webview ");
		  }
		
		
	}
	
	
}
