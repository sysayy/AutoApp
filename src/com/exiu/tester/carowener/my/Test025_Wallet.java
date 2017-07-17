package com.exiu.tester.carowener.my;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test025_Wallet extends BaseTestCase {

	/**
	 * 我的页面 我的钱包case
	 *
	 * 
	 * @throws Exception
	 */

	// @Test(priority=1)
	public void 账户余额() throws Exception {
		click(getId("我"));
		click(getId("我的钱包"));
		click(getId("钱包余额"));
		screenShoot("钱包余额");
		click(getId("收支明细"));
		compare("收支明细", getId("列表Id"), getId("tableListName"));
		Back();
		click(getId("充值"));
		autoInput("充值"); // 自动输入 充值部分的信息
		click(getId("银行卡快捷支付"));
		click(getId("确认支付"));
		screenShoot("确认支付");
	}

	// @Test(priority=2)
	public void 银行卡() throws Exception {
		click(getId("我"));
		click(getId("我的钱包"));
		click(getId("银行卡"));
		screenShoot("银行卡");
		click(getId("新卡"));
		autoInput("银行卡");
		click(getId("开卡城市"));
		citySelector.selectCity(getParameter("城市")); // 选择城市信息
		click(getId("所属银行"));
		click(getParameter("招商银行"));
		click(getId("私人"));
		click(getId("新卡提现"));
		screenShoot("新卡提现");
	}

	// @Test(priority=3)
	public void 支付管理() throws Exception {
		click(getId("我"));
		click(getId("我的钱包"));
		click(getId("支付管理"));
		screenShoot("支付管理");
		click(getId("重置支付密码"));
		autoInput("重置支付密码");
		click(getId("重置密码确定"));
	}

	@Test(priority = 4)
	public void 红包() throws Exception {
		click(getId("我"));
		click(getId("我的钱包"));
		click(getId("红包"));
		screenShoot("红包");
		click(getId("我的红包"));
		click(getId("收到的红包"));
		screenShoot("收到的红包");
		Back();
		click(getId("我的红包"));
		click(getId("发出的红包"));
		screenShoot("发出的红包");
		Back();
		click(getId("发送注册红包"));
		autoInput("红包");
		click(getId("塞进红包"));
		click(getId("余额支付"));
		click(getId("确认支付"));
		screenShoot("请输入支付密码");

	}

	// @Test(priority=5)

	public void 话费充值() throws Exception {
		click(getId("我"));
		click(getId("我的钱包"));
		click(getId("话费充值"));
		screenShoot("话费充值");
		click(getId("规则"));
		screenShoot("规则");
		Back();
		click(getId("去分享"));
		screenShoot("分享");
		Back();
		click(getId("去充值"));
		screenShoot("去充值");
		Back();
		click(getId("购买洗车卡"));
		compare("购买洗车卡", getId("列表Id"), getId("listName"));
		Back();
		click(getId("更多"));
		click(getId("购买保险"));
		screenShoot("购买保险");
		compare("购买保险", getId("列表Id"), getId("listName"));
		Back();
		click(getId("车联套餐"));
		compare("车联套餐", getId("列表Id"), getId("listName"));
		screenShoot("车联套餐");

	}

}
