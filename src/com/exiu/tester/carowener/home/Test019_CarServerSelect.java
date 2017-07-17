package com.exiu.tester.carowener.home;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.api.CategorySelector;
import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;
@Listeners({com.exiu.developer.AssertionListener.class})
public class Test019_CarServerSelect extends BaseTestCase {

	/**爱车服务按类别筛选
	 * 
	 * @throws Exception
	 */
	
	@Test(priority=1)
	public void 服务类别() throws Exception {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("服务类别"));
		screenShoot("请选择服务项目");
		categorySelect.selectCategory(getParameter("洗车美容3"));
		screenShoot(getParameter("洗车美容3")+" 筛选结果");
		compare(getParameter("洗车美容3"), getId("tableId"), getId("tableListName"));
		
	}
	
//	@Test(priority=2)
	public void 车品类别() throws Exception {
		click(getId("汽车服务"));
		click(getId("服务商家"));
		click(getId("车品类别"));
		screenShoot("请选择汽车用品");
		categorySelect.selectCategory(getParameter("车品"));
		screenShoot(getParameter("车品")+" 筛选结果");
		compare(getParameter("车品"), getId("tableId"), getId("tableListName"));
		
	}
}
