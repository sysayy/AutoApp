package com.exiu.tester.carowener.my;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

public class Test001_login extends BaseTestCase {

	@DataProvider(name = "login")
	public Object[][] Users() {

		return new Object[][] {
		// { "13098765432", "123456" },
		{ "13603450902", "111111" }, };
	}

	@Test(dataProvider = "login")

	public void 登录(String username, String password) {
		account.login(username, password);
		account.logout();
	}
}