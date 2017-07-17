package com.exiu.developer.impl;

import com.exiu.api.Dial;
import com.exiu.developer.BaseTestImpl;

/**
 * 拨打电话
 * @author exlm
 *phoneNumber  手机号
 */

public class DialImpl extends BaseTestImpl implements Dial{

	@Override
	public void dial(String phoneNumber) {
		for (int i = 0; i < phoneNumber.length();) {
			String b = phoneNumber.substring(i, i + 1);
			click(b);
			i++;
		}
		if (isAndroid) {
			click("com.exiu.exiucarowner:id/callp");
		} else {
			click("car phone dial");
		}

	}
}
