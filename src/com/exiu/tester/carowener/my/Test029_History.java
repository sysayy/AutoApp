package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.Assertion;
import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test029_History extends BaseTestCase {
	/**
	 * 我的页面 历史记录case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 历史记录() throws Exception {
		click(getId("我"));
		click(getId("历史记录"));
		screenShoot("历史记录");
		Assertion.verifyEquals(elementToStr(getId("title")), getParameter("title")); // 断言
																						// 页面跳转
		if (eleIsExist(getId("选择")) == true) {
			System.out.println("------ >  历史记录为空");
		} else {
			if (isAndroid) {
				compare("HistoryList", getId("listId"), getId("listName")); // 标定
																			// 列表结果
				click(getId("选择"));
				click(getId("全选"));
				click(getId("删除"));
				click(getId("确定删除"));
				if (eleIsExist(getId("选择")) == true) {
					System.out.println("------ >  历史记录删除成功");
				}
			} else {
				compare("HistoryList", getId("listId"), getId("listName"));
			}

		}
	}

}
