package com.exiu.tester.carowener.sharecarpool;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test040_PeopleLookingForCars extends BaseTestCase {
	/**
	 * 共享拼车 人找车 case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 人找车() throws Exception {
		click(getId("共享拼车"));
		click(getId("人找车"));
	    if(isExist(getId("新发布"))==true)	{
	    	click(getId("新发布"));
	    	System.out.println("***已发布有线路***");
	    }
		// click(getId("起始地址"));
		// autoInput("起始地址");
		// List<WebElement> el = findElements(getId("搜索结果"));
		// System.out.println(el.get(1).getText());
		// click(el.get(1).getText());
		click(getId("目的地"));
		autoInput("目的地");
		click(findElements(getId("搜索结果")).get(2).getText());
//		dateTimePicker.pickDateTime_Carpool(getId("时间"), getParameter("time"));
		personPicker.pickPerson(getId("人数"), getParameter("人数"));
		autoInput("留言");
		click(getId("确认发布"));
	}

	/**
	 * 分享发布的 拼车路线
	 * 
	 * @throws Exception
	 */
	
	@Test(priority = 2)
	public void 分享_人找车() throws Exception {
		click(getId("共享拼车"));
		click(getId("人找车"));
		if (isExist(getId("分享路线")) == true) {
			click(getId("分享路线"));
			click(getId("微信朋友圈"));
			click(getId("发送"));
            screenShoot("分享微信朋友圈");
		}

	}

	/**
	 * 删除 发布的 拼车路线
	 * 
	 * @throws Exception
	 */

	@Test(priority = 3)
	public void 删除_人找车() throws Exception {
		click(getId("共享拼车"));
		click(getId("人找车"));
		if (isExist(getId("详情")) == true) {
			click(getId("详情"));
			click(getId("删除发布"));
			
			click(getId("删除确定"));
			screenShoot("删除发布");
		}

	}

	/**
	 *  查看附近拼车  车找人 
	 * @throws Exception
	 */
	
	@Test(priority = 4)
	public void 查看附近拼车() throws Exception {
		click(getId("共享拼车"));
		click(getId("人找车"));
		click(getId("查看附近拼车"));
		compare("查看附近拼车", getId("CarList"), getId("CarTime"));	
		
	}
/**
 * 预约附近拼车（价格面议的车辆）
 * @throws Exception
 */
	@Test(priority = 5)
	public void 预约附近拼车() throws Exception {
		click(getId("共享拼车"));
		click(getId("人找车"));
		click(getId("查看附近拼车"));
		click(findElements(getId("CarTime")).get(4));
		String str1 =elementToStr(getId("车主Name"));
		click(getId("立即预约"));
		click(getId("确定预约"));
		screenShoot("预约附近车辆");
		click(getId("预约确定"));
		Back();
		click(getId("车找人"));
		click(getId("人找车"));
		String str2 = elementToStr(getId("待处理行程车主Name"));
		Assertion.verifyEquals(str2, str1);
	}
	/**
	 * 取消预约车辆
	 * @throws Exception
	 */
	
	@Test(priority = 6)
	public void 取消预约() throws Exception {
		click(getId("共享拼车"));
		click(getId("人找车"));
		if(isExist(getId("取消预约"))==true){
			click(getId("取消预约"));
			click(getId("确定取消"));	
		}else {
			Assertion.verifyEquals(true, false," 没有待处理的行程 ");
		}
	}
}
