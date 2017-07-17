package com.exiu.tester.carowener.my;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

/**
 * 我的页面 收藏夹 case
 * 
 * @author exlm
 *
 */

public class Test027_Favorites extends BaseTestCase {
	@Test(priority = 1)
	public void 商家() throws Exception {
		click(getId("我"));
		click(getId("收藏夹"));
		click(getId("商家"));
		compare("merchantList", getId("ListId"), getId("merchanName")); // 标定
																		// 列表筛选结果信息
	}

	@Test(priority = 2)
	public void 专家() throws Exception {
		click(getId("我"));
		click(getId("收藏夹"));
		click(getId("专家"));
		compare("expertList", getId("ListId"), getId("expertName"));
	}

	@Test(priority = 3)
	public void 商品() throws Exception {
		click(getId("我"));
		click(getId("收藏夹"));
		click(getId("商品"));
		compare("productList", getId("ListId"), getId("productName"));

	}

}
