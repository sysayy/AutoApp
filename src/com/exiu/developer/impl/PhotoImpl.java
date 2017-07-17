package com.exiu.developer.impl;

import com.exiu.api.Photo;
import com.exiu.developer.BaseTestImpl;

public class PhotoImpl extends BaseTestImpl implements Photo {

	@Override
	public void takePhoto(String id) {
		click(id);
		if(isAndroid) {
			click("拍照");
			click(getDeviceId("photo"));
			click(getDeviceId("confirm"));
			click(getDeviceId("save"));
		}else {
			click("common_picCtrl_add");
			click("TZImagePickerController.bundle/takePicture.png");
			click("PhotoCapture");
			click("使用照片");
			click("OK");
			click("提交");	
		}
		
	}
}
