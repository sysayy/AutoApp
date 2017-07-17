package com.exiu.tester.carowener.home;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;
/**
 * 公交出行
 * @author exlm
 *
 */
public class Test010_Bus extends BaseTestCase {
	
	
  @Test
  public void 公交出行() throws Exception {
	  click(getId("汽车服务"));
	  click(getId("公交出行"));
	  Thread.sleep(2000);
	  click(getId("线路站点"));
	  click(getId("查看附近公交站"));
//	  sendKeys(getId("公交线路文本框"), "10");
//	  click(getId("查询bus"));
//	  compare("线路站点-附近公交站", getId("附近公交站列表"), getId("附近公交站列表Name"));
	  screenShoot("查看附近公交站");

	  
 
  
  
  }
  
  
  
  
}
