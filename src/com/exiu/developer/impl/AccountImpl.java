package com.exiu.developer.impl;

import com.exiu.api.Account;
import com.exiu.developer.BaseTest;

public class AccountImpl extends BaseTest implements Account {

	@Override
	public void login(String username, String password) {
		if (isAndroid) {
		} else {
			click(getId("我"));
			click(getId("登录到账户"));
		}
		// sendKeys(getId("username"), username);
		// sendKeys(getId("password"), password);
		autoInput();
		click(getId("login"));
	}

	@Override
	public void logout() {
		if (isAndroid) {
			click(getId("my"));
			click(getId("more"));
			click(getId("exit"));
			click(getId("SwitchAccount"));
		}
	}

}
