package com.exiu.tester.carowener.Chatting;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.exiu.developer.BaseTestCase;

@Listeners({ com.exiu.developer.AssertionListener.class })
public class Test037_Yixin extends BaseTestCase {
	/**
	 * 逸聊  逸信 case
	 * 
	 * @throws Exception
	 */

	@Test(priority = 1)
	public void 逸信() throws Exception {
		//进入消息
		click(getId("逸聊"));
		click(getId("逸信"));
		screenShoot("逸信");
		click(getId("消息"));
		click(getId("系统消息"));
		compare("系统消息", getId("消息List"), getId("消息Name"));
		click(getId("逸休通知"));
		compare("逸休通知", getId("通知List"), getId("通知Name"));
		click(getId("系统消息"));
		click(getId("更多"));
		//标记消息为已读
		click(getId("系统消息标为已读"));
		
	}


	
}
