package com.exiu.tester.carowener.home;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;
/**
 * 故障咨询
 * @author exlm
 *
 */
public class Test005_TroubleConsultation extends BaseTestCase {
  @Test
  public void 故障咨询_新发布() {
	  //点击汽车服务
	  click(getId("汽车服务"));	    
	  click(getId("故障咨询"));	
	  click(getId("新发布"));  
	  click(getId("咨询商家"));
	  click(getId("疑难杂症"));
	  autoInput();
	  click(getId("确定"));
	  compare("故障咨询", getId("tableId"), getId("tableListName"));
	  
  }
	  
  }


