package com.exiu.tester.carowener.home;
import org.testng.annotations.Test;
import com.exiu.developer.BaseTestCase;

public class Test016_EmergencyRescue extends BaseTestCase {

	/**紧急求助
	 * 
	 * @throws Exception
	 */
	
	@Test(priority=1)
	public void 求助专家() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("求助专家"));
		sortFilter.sortFilter(getParameter("sortRight1"));
		screenShoot("求助专家"+getParameter("sortRight1"));
		compare("求助专家"+getParameter("sortRight1"), getId("tableId"), getId("tableListPeople"));
		
		sortFilter.sortFilter(getParameter("sortMiddle2"));
		screenShoot("求助专家"+getParameter("sortMiddle2"));
		compare("求助专家"+getParameter("sortMiddle2"), getId("tableId"), getId("tableListPeople"));
		
		sortFilter.sortFilter(getParameter("sortLeft"));
		screenShoot("求助专家"+getParameter("sortLeft"));
		compare("求助专家"+getParameter("sortLeft"), getId("tableId"), getId("tableListPeople"));
		
	}
	
	@Test(priority=2)
	public void 搜索_求助专家() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("求助专家"));
		click(getId("搜索框"));
		autoInput();
		click(getId("搜索"));
	
		screenShoot("搜索_求助专家");
		compare("搜索_求助专家", getId("tableId"), getId("tableListName"));
		
	}
	
	@Test(priority=3)
	public void 路边快修() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("路边快修"));	
		screenShoot("路边快修");
		compare("路边快修", getId("tableId"), getId("tableListName"));
		
	}
	
//	@Test(priority=4)
	public void 派送燃料() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("派送燃料"));	
		screenShoot("派送燃料");
//		compare("派送燃料", getId("tableId"), getId("tableListName"));
		
	}
	
	@Test(priority=5)
	public void 电瓶搭电() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("电瓶搭电"));	
		screenShoot("电瓶搭电");
//		compare("电瓶搭电", getId("tableId"), getId("tableListName"));
		
	}
	
	@Test(priority=6)
	public void 更换轮胎() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("更换轮胎"));	
		screenShoot("更换轮胎");
//		compare("更换轮胎", getId("tableId"), getId("tableListName"));
		
	}
	@Test(priority=7)
	public void 加防冻液() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("加防冻液"));	
		screenShoot("加防冻液");
//		compare("加防冻液", getId("tableId"), getId("tableListName"));
		
	}
	@Test(priority=8)
	public void 紧急拖车() throws Exception {
		click(getId("汽车服务"));
		click(getId("紧急求助"));
		click(getId("紧急拖车"));	
		screenShoot("紧急拖车");
//		compare("紧急拖车", getId("tableId"), getId("tableListName"));
		
	}
}
