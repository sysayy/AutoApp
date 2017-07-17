package com.exiu.tester.carowener.home;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;
@Listeners({com.exiu.developer.AssertionListener.class})
public class Test020_BankPacks extends BaseTestCase {

	

	
	
	/**建行大礼包
	 * 
	 * @throws Exception
	 */
	
//	@Test(priority=1)
	public void 建行大礼包() throws Exception {
//		isPrompt();
		click(getId("汽车服务"));
		click(getId("城市"));
		citySelector.selectCity(getParameter("城市"));
		click(getId("建行大礼包"));
//		Assertion.verifyEquals(elementToStr(getId("title")), "建行特惠");
		click(getId("优惠政策"));
//		Assertion.verifyEquals(elementToStr(getId("title1")), "优惠政策");
		screenShoot("建行大礼包-优惠政策");
		Back();
		click(getId("特惠洗车"));
//		Assertion.verifyEquals(elementToStr(getId("title1")), "建行洗车");
		screenShoot("建行大礼包-特惠洗车");
//		compare("特惠洗车", getId("tableId"), getId("tableListName"));
		Back();
		click(getId("特惠维修保养"));
//		Assertion.verifyEquals(elementToStr(getId("title1")), "建行维保");
		screenShoot("建行大礼包-特惠维修保养");
//		compare("特惠维修保养", getId("tableId"), getId("tableListName"));
		Back();
		click(getId("特惠年检"));
//		Assertion.verifyEquals(elementToStr(getId("title1")), "建行年检");
		screenShoot("建行大礼包-特惠年检");
		compare("特惠年检", getId("tableId"), getId("tableListName"));
	}
	
	@Test(priority=2)
	public void 建行大礼包_无鲁通卡用户领取() throws Exception {
//		isPrompt();
		click(getId("汽车服务"));
		click(getId("城市"));
		citySelector.selectCity(getParameter("城市"));
		click(getId("建行大礼包"));
		click(getId("无鲁通卡用户领取"));
		screenShoot("无鲁通卡用户领取");
		switchtoWeb();	
		autoInput();
		click(getId("提交信息"));
		returnNativeApp();
		screenShoot("无鲁通卡用户领取-提交申请");
		switchtoWeb();
		if(isAndroid) {
			if(
					driver.findElementByXPath(getId("系统消息"))==null) {
					System.out.print("----> 用户第一次申请");
				}else {
					System.out.print("----> 申请信息已提交不能重复提交！");
						driver.findElementByXPath(getId("重复申请确定")).click();	
				}
		}else {
			if(findElement(getId("系统消息"))==null) {
				System.out.print("----> 用户第一次申请");
				
			}else {
				System.out.print("----> 申请信息已提交不能重复提交！");
				click(getId("重复申请确定"));
			}
		}
		
		
	}

	
	


//		@Test(priority=3)
	public void 建行大礼包_已有鲁通卡用户领取() throws Exception {
//		isPrompt();
		click(getId("汽车服务"));
		click(getId("城市"));
		citySelector.selectCity(getParameter("城市"));
		click(getId("建行大礼包"));
		click(getId("已有鲁通卡用户领取"));
		screenShoot("已有鲁通卡用户领取");
		autoInput("已有鲁通卡");
		screenShoot("已有鲁通卡用户领取-填写信息");
		click(getId("提交审核"));
		screenShoot("已有鲁通卡用户领取-提交申请");
	
	}

}
