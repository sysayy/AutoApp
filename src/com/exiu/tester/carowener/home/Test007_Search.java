package com.exiu.tester.carowener.home;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

/**
 * 首页面搜索
 * @author exlm
 *
 */
public class Test007_Search extends BaseTestCase {

	
  @Test(priority=1)
  public void 保险() {
	  /**
	   * 1.首页面点击搜索对 未进行搜索的类别做记录
	   * 2.点击保险 对保险列表做记录 根据 isStandard true or flase 执行相应的操作
	   * 
	   */
	  click(getId("汽车服务"));
	  click(getId("home_search"));
	  compare("空列表", getId("历史列表"), getId("历史列表名称"));
	  click(getId("保险"));
	  sortFilter.sortFilter(getParameter("sortMiddle"));
	  compare("保险", getId("tableId"), getId("tableListName"));
	  
  }
  @Test(priority=2)
  public void 洗车办卡() {
	  /**
	   * 1.点击洗车办卡 对洗车办卡列表做记录 
	   */
	  click(getId("汽车服务"));
	  click(getId("home_search"));
	  click(getId("洗车办卡"));
	  sortFilter.sortFilter(getParameter("sortMiddle"));
	  compare("洗车办卡", getId("tableId"), getId("tableListName"));
	  
  }
  @Test(priority=3)
  public void 上门维修() {
	  click(getId("汽车服务"));
	  click(getId("home_search"));
	  click(getId("上门维修"));
	  sortFilter.sortFilter(getParameter("sortMiddle"));
	  compare("上门维修", getId("tableId"), getId("tableListName"));
	  
  }
  @Test(priority=4)
  public void 办卡担保() {
	  click(getId("汽车服务"));
	  click(getId("home_search"));
	  click(getId("办卡担保"));
	  sortFilter.sortFilter(getParameter("sortMiddle"));
	  compare("办卡担保", getId("tableId"), getId("tableListName"));
	  
  }
  @Test(priority=5)
  public void 历史搜索() {
	  /**
	   * 1.点击搜索对之前的历史操作做记录
	   * 根据 isStandard true or flase 执行相应的操作
	   */
	  click(getId("汽车服务"));
	  click(getId("home_search"));
	  compare("历史搜索", getId("历史列表"), getId("历史列表名称"));
	  click(getId("et_search"));
	  autoInput();
	  click(getId("搜索"));
	  compare("搜索", getId("tableId"), getId("tableListName"));
	  Back();
	  compare("搜索历史", getId("历史列表"), getId("历史列表名称"));
	  if(isAndroid) {  
	  }else {
		  click("完成");
	  }
	  click(getId("清空历史记录"));
	  compare("空列表", getId("历史列表"), getId("历史列表名称"));
  }
  
  

}
