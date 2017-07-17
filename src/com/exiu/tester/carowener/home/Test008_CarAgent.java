package com.exiu.tester.carowener.home;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;
/**
 * 车务代办
 * @author exlm
 *
 */
public class Test008_CarAgent extends BaseTestCase{
  @Test(priority=1)
  public void 代办审车() {
	  /**
	   * 1.首页进入车务代办 
	   * 根据 isStandard true or flase 执行相应的操作
	   */
	  click(getId("汽车服务"));
	  click(getId("车务代办"));
	  click(getId("代办审车"));
	  click(getId("综合"));
	  compare("代办审车-综合", getId("tableId"), getId("tableListName"));
	  click(getId("距离"));
	  compare("代办审车-距离", getId("tableId"), getId("tableListName"));
	  click(getId("好评"));
	  compare("代办审车-好评", getId("tableId"), getId("tableListName"));
  }
  @Test(priority=2)
  public void 代交罚款() {
	  click(getId("汽车服务"));
	  click(getId("车务代办"));
	  click(getId("代办审车"));
	  click(getId("综合"));
	  compare("带教罚款-综合", getId("tableId"), getId("tableListName"));
	  click(getId("距离"));
	  compare("带教罚款-距离", getId("tableId"), getId("tableListName"));
	  click(getId("好评"));
	  compare("带教罚款-好评", getId("tableId"), getId("tableListName"));
  }
  @Test(priority=3)
  public void 过户() {
	  click(getId("汽车服务"));
	  click(getId("车务代办"));
	  click(getId("代办审车"));
	  click(getId("综合"));
	  compare("过户-综合", getId("tableId"), getId("tableListName"));
	  click(getId("距离"));
	  compare("过户-距离", getId("tableId"), getId("tableListName"));
	  click(getId("好评"));
	  compare("过户-好评", getId("tableId"), getId("tableListName"));
  }
  
  @Test(priority=4)
  public void 其他() {
	  click(getId("汽车服务"));
	  click(getId("车务代办"));
	  click(getId("代办审车"));
	  click(getId("综合"));
	  compare("其他-综合", getId("tableId"), getId("tableListName"));
	  click(getId("距离"));
	  compare("其他-距离", getId("tableId"), getId("tableListName"));
	  click(getId("好评"));
	  compare("其他-好评", getId("tableId"), getId("tableListName"));
  }
}
