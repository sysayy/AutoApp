package com.exiu.tester.carowener.my;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

public class Test002_Personalinformation extends BaseTestCase {

	@Test
	public void 个人信息() throws Exception {
		click(getId("我"));
//		click(getId("头像"));
//		photo.takePhoto(getId("更换头像"));
     
		// 设置 姓名、昵称、性别、驾龄、手机号、真实年龄、身份证号、血型、爱好
		// click(getId("真实年龄"));
		// ageSelector.selectPersonalAge(getParameter("age"));
		 autoInput("个性签名");
//		 autoInput("昵称");
		// selectSex("男");
		// selectBloodtype("NO");
		// click(getId("我的爱好"));
		// interestSeleect.selectInterest(getParameter("互联网IT"));
		// click(getId("保存"));
		// autoInput("姓名");
		// swipUp();
		// autoInput("身份证");
		// screenShoot("录入信息");
		// updatePhoto("身份证图");
		// updatePhoto("驾驶证图");
		// Back();
		// swipUp();
		// screenShoot("上传图片");

	}
}
