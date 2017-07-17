package com.exiu.tester.carowener.sharesocial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;
/**
 * 热点笑话
 * @author exlm
 *
 */
public class Test006_HotJoke extends BaseTestCase {
  @Test(priority=1)
  public void 热点笑话() {
	  click(getId("共享社交"));
	  click(getId("热点笑话"));	
	  compare("热点笑话", getId("tableId"), getId("tableListName"));
  }
//  @Test(priority=2)
  public void 发布热点笑话() {
	  click(getId("共享社交"));
	  click(getId("热点笑话"));	
	  click(getId("性别"));
	  click(getId("全部"));
	  compare("首次热点笑话", getId("tableId"), getId("tableListName"));
	  click(getId("新发布"));	
	  click(getId("预览描述"));
//	  autoInput();
	  sendKeys(getId("描述"),getId("笑话") );
	  click(getId("保存"));
	  click(getId("正文内容"));
//	  autoInput();
	  sendKeys(getId("内容"),"auto send !!!" );
	  click(getId("完成"));
	  click(getId("发布"));
	  iosClick();
	  compare("验证发布新热点笑话列表", getId("tableId"), getId("tableListName"));
	  click(getId("删除"));	
	  click(getId("确定删除"));
	  iosClick();
	  compare("热点笑话", getId("tableId"), getId("tableListName"));
  }
//  @Test(priority=3)
  public void 验证发布新热点笑话列表() {
	  click(getId("共享社交"));
	  click(getId("热点笑话"));	
//	  click(getId("新发布"));	
	  compare("验证发布新热点笑话列表", getId("tableId"), getId("tableListName"));
	  click(getId("删除"));	
	  click(getId("确定删除"));	
	  compare("热点笑话", getId("tableId"), getId("tableListName"));
  }
//  @Test(priority=4)
  public void 筛选异性笑话列表() {
	  click(getId("共享社交"));	
	  click(getId("热点笑话"));
	  click(getId("性别"));
	  click(getId("异性"));
	  compare("筛选异性笑话列表", getId("tableId"), getId("tableListName"));
	
  }
  
  public void iosClick() {
	  if(isAndroid) {
		  
	  }else {
		  click(getId("全部"));
		  click(getId("全部"));
	  }
  }
  
  @Test(priority=4)
  public void 跳转录入测试() {
	  click(getId("共享社交"));	
	  click(getId("热点笑话"));
//	  click(getId("性别"));
//	  click(getId("全部"));
	  click(getId("新发布"));	
//	  click(getId("预览描述"));	
//////	  compare("筛选异性笑话列表", getId("tableId"), getId("tableListName"));
//	  sendKeys(getId("text"),getId("笑话") );
//	  click(getId("保存"));
//	  click(getId("正文内容"));	
//	  sendKeys(getId("text"),"auto send !!!" );
//	  click(getId("完成"));
//	  click(getId("发布"));
	  autoInput();
	 
	  
	
  }
  
  
}
