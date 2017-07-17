package com.exiu.developer.impl;

import com.exiu.api.ConversionNumber;
import com.exiu.developer.BaseTestImpl;
/**
 *  转换手机号
 * @author exlm
 *
 */
public class ConversionNumberImpl extends BaseTestImpl implements ConversionNumber {

	
	@Override
	public String conversionNum(String phone) {
		// TODO Auto-generated method stub
		
		if (isAndroid) {
			// Android 返回 拼接的 手机号
			return phone = phone.substring(1, 3) + phone.substring(4, 8) + phone.substring(9, 14);

		} else {
			// Ios 返回 拼接的 手机号
			return phone = phone.substring(0, 11);
		}
		
	}

}
