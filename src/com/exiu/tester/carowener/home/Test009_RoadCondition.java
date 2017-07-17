package com.exiu.tester.carowener.home;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;
/**
 * 路况查询
 * @author exlm
 *
 */
public class Test009_RoadCondition extends BaseTestCase {
  @Test
  public void 路况查询() {
	  /**
	   * 1.汽车服务页面进入路况查询
	   * 2.输入地址搜索 截图  标定
	   */
	  click(getId("汽车服务"));
	  click(getId("路况查询"));
	  sendKeys(getId("搜索框"), getParameter("地址"));
	  compare("路况查询-搜索列表", getId("搜索列表id"), getId("搜索列表"));
	  click(getId("搜索"));
	  click(getId("定位"));
	  
  }
}
