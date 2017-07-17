package com.exiu.developer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * 处理自动化配置的类
 * 
 * @author 冯高远
 * @date 2017年5月12日 下午1:42:59
 * @description
 */
public class BaseTest {
	protected static final String UserDir = System.getProperty("user.dir");
	private static final String IDConfigDir = UserDir + "/idConfigs";
	protected static final String Globle = UserDir + "/configs" + "/globle.properties";
	protected static final boolean isAndroid = getPlatform();
	protected static final String Config = UserDir + "/configs"
			+ (isAndroid ? "/AndroidConfig.properties" : "/IOSConfig.properties");
	private static final String AutoInputDir = UserDir + "/autoInput";

	protected static AppiumDriver<WebElement> driver;
	private Properties configsProperties = null;
	private Properties deviceConfigsProperties = null;

	private final int waitTimes = 12;
	private String deviceName;
	private final static String CarOwner = "com.exiu.tester.carowener";
	private final static String Merchant = "com.exiu.tester.merchant";
	private final static String Accessory = "com.exiu.tester.accessory";
	private final static String Expert = "com.exiu.tester.expert";
	private final static String Collect = "com.exiu.tester.collect";
	private final static String Develpoer = "com.exiu.developer";

	protected String getApp() {
		String extra = "";
		if (this.getClass().getName().startsWith(CarOwner)) {
			extra = "carowner";
		} else if (this.getClass().getName().startsWith(Merchant)) {
			extra = "merchant";
		} else if (this.getClass().getName().startsWith(Accessory)) {
			extra = "accessory";
		} else if (this.getClass().getName().startsWith(Expert)) {
			extra = "expert";
		} else if (this.getClass().getName().startsWith(Collect)) {
			extra = "collect";
		} else if (this.getClass().getName().startsWith(Develpoer)) {
			extra = "developer";
		}
		return "/" + extra;
	}

	protected String getAppPackage() {
		String extra = "";
		if (this.getClass().getName().startsWith(CarOwner)) {
			extra = "com.exiu.exiucarowner";
		} else if (this.getClass().getName().startsWith(Merchant)) {
			extra = "com.exiu.merchant";
		} else if (this.getClass().getName().startsWith(Accessory)) {
			extra = "com.exiu.accessory";
		} else if (this.getClass().getName().startsWith(Expert)) {
			extra = "com.exiu.expert";
		} else if (this.getClass().getName().startsWith(Collect)) {
			extra = "collect";
		} else if (this.getClass().getName().startsWith(Develpoer)) {
			extra = "developer";
		}
		return extra;
	}

	protected String getRealPath(String path) {
		return path + getApp() + getDevice();
	}

	protected String getDevice() {
		return "/" + (isAndroid ? "android" : "ios");
	}

	/**
	 * @author gaoyuan
	 * @param index
	 *            根据index 选择对应的配置文件
	 */
	protected void autoInput(String index) {
		String fileName = this.getClass().getSimpleName();
		fileName += index;
		Properties keyProperties = getPropertiesFromPath(getRealPath(AutoInputDir) + "/key/" + fileName);
		Properties valueProperties = getPropertiesFromPath(getRealPath(AutoInputDir) + "/value/" + fileName);
		Set<Object> keySet = keyProperties.keySet();
		for (Object object : keySet) {
			String key = keyProperties.getProperty((String) object);
			String value = valueProperties.getProperty((String) object);
			sendKeys(key, value);
		}
	}

	protected void autoInput() {
		autoInput("");
	}

	public BaseTest() {
		initConfigs();
	}

	@Deprecated
	protected Properties getPropertiesFromFile(File file) {
		Properties properties = new Properties();
		try {
			InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(file), "UTF-8");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	protected Properties getPropertiesFromPath(String path) {
		return getPropertiesFromFile(new File(path + ".properties"));
	}

	protected void setPropertiesToFile(Properties properties, File file) {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			properties.store(outputStreamWriter, "store");
			outputStreamWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean getPlatform() {
		Properties properties = new Properties();
		try {
			File file = new File(Globle);
			InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(file), "UTF-8");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = properties.getProperty("isAndroid");
		if ("false".equals(property)) {
			return false;
		}
		return true;
	}

	private void initConfigs() {
		File file = new File(getRealPath(IDConfigDir), this.getClass().getSimpleName() + ".properties");
		if (file.exists() && file.length() > 0) {
			try {
				configsProperties = new Properties();
				InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(file), "UTF-8");
				configsProperties.load(fileInputStream);
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Properties deviceProperties = new Properties();
		try {
			File deviceFile = new File(Config);
			FileInputStream inputStream = new FileInputStream(deviceFile);
			deviceProperties.load(inputStream);
			inputStream.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		deviceName = deviceProperties.getProperty("deviceName");
		File deviceFile = new File(getRealPath(IDConfigDir) + "/" + this.getClass().getSimpleName(), deviceName
				+ ".properties");
		if (deviceFile.exists() && deviceFile.length() > 0) {
			try {
				deviceConfigsProperties = new Properties();
				InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(deviceFile), "UTF-8");
				deviceConfigsProperties.load(fileInputStream);
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * case 执行前执行的方法 配置android ios 启动配置
	 * 
	 * @param method
	 *            case 开始前输出执行的case 名
	 * @throws Exception
	 */
	@BeforeMethod
	public void setUpAndroid(Method method) throws Exception {
		Properties properties = new Properties();
		File file = new File(Config);
		FileInputStream inputStream = new FileInputStream(file);
		properties.load(inputStream);
		inputStream.close();
		deviceName = properties.getProperty("deviceName");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Class : " + getClass().getName() + "\n"
				+ ">>>>>>>>>>>>>>>>>>>>>>> Test case : " + method.getName() + " "
				+ properties.getProperty("platformName") + ":设备 " + deviceName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if (isAndroid) {
			capabilities.setCapability("platformName", properties.getProperty("platformName"));
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
			capabilities.setCapability("appPackage", getAppPackage());
			capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
			// capabilities.setCapability("automationName", "uiautomator2");
			// //Android 7.0需要加上该配置
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("unicodeKeyboard", "True");
			capabilities.setCapability("resetKeyboard", "True");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(waitTimes, TimeUnit.SECONDS);
		} else {
			capabilities.setCapability("platformName", properties.getProperty("platformName"));
			capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("udid", properties.getProperty("udid"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest"); // ios
																							// 9.3以上测试要加上该句
			capabilities.setCapability("bundleId", properties.getProperty("bundleId"));
			capabilities.setCapability("autoAcceptAlerts", "True");
			capabilities.setCapability("unicodeKeyboard", "True");
			capabilities.setCapability("resetKeyboard", "True");
			capabilities.setCapability("startIWDP", "True");
			capabilities.setCapability("noReset", "true");
			driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(waitTimes, TimeUnit.SECONDS);
		}
		isPrompt();
		System.err.println("driver初始化成功");
	}

	/**
	 * case 结束时调用 清理driver
	 */
	@AfterMethod
	public void tearDown() {
		System.err.println("driver退出成功");
		driver.quit();
	}

	/**
	 * 点击方法
	 * 
	 * @param id
	 */
	protected void click(String id) {
		click(findElement(id));
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("***click : " + id + "***");
	}

	protected void click(WebElement webElement) {
		// if (webElement == null) {
		// return;
		// }
		webElement.click();
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected String getDeviceId(String key) {
		return deviceConfigsProperties.getProperty(key).trim();
	}

	protected String getId(String key) {
		return configsProperties.getProperty(key).trim();
	}

	/**
	 * 输入文本方法
	 * 
	 * @param id
	 * @param content
	 */
	protected void sendKeys(String id, String content) {
		WebElement element = findElement(id);
		Point location = element.getLocation();
		element.click();
		try {
			Point location2 = element.getLocation();
			if (location.getX() == location2.getX() && location.getY() == location2.getY()) {
				element.clear();
				element.sendKeys(content);
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e) {

			WebElement element3 = findElement(isAndroid ? "android.widget.EditText" : "//XCUIElementTypeStaticText");
			// element3.clear();
			element3.sendKeys(content);
			if (isAndroid) {
				WebElement element4 = findElement("保存");
				if (element4 != null) {
					element4.click();
				}
			} else {
				WebElement element4 = findElement("隐藏键盘");
				if (element4 != null) {
					element4.click();
				}

				// click("隐藏键盘");
				WebElement element5 = findElement("common save n");
				if (element5 != null) {
					element5.click();
				}
			}
			WebElement element5 = findElement("完成");
			if (element5 != null) {
				element5.click();
			}
		}
	}

	/**
	 * 查找对象封装的方法
	 * 
	 * @param id
	 *            根据传入的参数判断用那种方式查找控件
	 * @return
	 */
	protected WebElement findElement(String id) {
		if (id == null) {
			return null;
		}
		try {
			if (id.startsWith("//") || id.startsWith("/")) {
				return driver.findElementByXPath(id);
			} else if (id.contains("android.widget.")) {
				return getAndroidDriver().findElementByAndroidUIAutomator("new UiSelector().className(\"" + id + "\")");
			} else if (id.contains("id") || isWebView()) {
				return driver.findElementById(id);
			} else {
				if (isAndroid) {
					return getAndroidDriver().findElementByAndroidUIAutomator("text(\"" + id + "\")");
				} else {
					return driver.findElementByName(id);
				}
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断该上下午是不是webview页面
	 * 
	 * @return
	 */
	private boolean isWebView() {
		return driver.getContext().startsWith("WEBVIEW");
	}

	protected WebElement findLastElement(String id) {
		List<WebElement> findElements = findElements(id);
		return findElements.get(findElements.size() - 1);
	}

	protected List<WebElement> findElements(String id) {
		try {
			if (id.startsWith("//") || id.startsWith("/")) {
				return driver.findElementsByXPath(id);
			} else if (id.contains("android.widget.")) {
				return getAndroidDriver()
						.findElementsByAndroidUIAutomator("new UiSelector().className(\"" + id + "\")");
			} else if (id.contains("id")) {
				return driver.findElementsById(id);
			} else {
				if (isAndroid) {
					return getAndroidDriver().findElementsByAndroidUIAutomator("text(\"" + id + "\")");
				} else {
					return driver.findElementsByName(id);
				}
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected List<WebElement> findElements(String root, String id) {
		try {
			WebElement rootElement = findElement(root);
			if (rootElement == null) {
				throw new RuntimeException("列表找不到");
			}
			By by = null;
			if (id.startsWith("//")) {
				by = By.xpath(id);
			} else if (id.contains("android.widget.")) {
				by = MobileBy.AndroidUIAutomator("new UiSelector().className(\"" + id + "\")");
			} else if (id.contains("id")) {
				by = By.id(id);
			} else {
				if (isAndroid) {
					by = MobileBy.AndroidUIAutomator("text(\"" + id + "\")");
				} else {
					by = By.name(id);
				}
			}

			return rootElement.findElements(by);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected WebElement loopFindElement(String root, String id) {
		WebElement element = null;
		WebElement rootElement = findElement(root);
		while (true) {
			element = findElement(rootElement, id);
			if (isAndroid) {
				if (element == null) {
					swipeUp(rootElement);
				} else {
					return element;
				}
			} else {
				if (element != null) {
					Point location = element.getLocation();
					if (location.getX() == 0 && location.getY() == 0) {

						swipeUp(rootElement);
					} else {
						return element;
					}
				}
			}
		}
	}

	protected WebElement findElement(WebElement rootElement, String id) {
		if (rootElement == null) {
			return findElement(id);
		}
		try {
			By by = null;
			if (id.startsWith("//")) {
				by = By.xpath(id);
			} else if (id.contains("android.widget.")) {
				by = MobileBy.AndroidUIAutomator("new UiSelector().className(\"" + id + "\")");
			} else if (id.contains("id")) {
				by = By.id(id);
			} else {
				if (isAndroid) {
					by = MobileBy.AndroidUIAutomator("text(\"" + id + "\")");
				} else {
					by = By.name(id);
				}
			}
			return rootElement.findElement(by);
		} catch (WebDriverException e) {
			e.printStackTrace();
			return findElement(id);
		}
	}

	private WebElement findElement(String root, String id) {
		WebElement rootElement = findElement(root);
		return findElement(rootElement, id);
	}

	/**
	 * 向上滑动 方法
	 */
	protected void swipUp() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 1000);
		// wait for page loading
		System.out.println("***向上滑动一次***");

	}

	/**
	 * 点击屏幕
	 */
	protected void tap() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.tap(1, width - 1, height - 1, 500);
	}

	/**
	 * 滑动方法
	 * 
	 * @param element
	 * @param i
	 * @param times
	 */
	private void swipe(WebElement element, int i, int times) {
		Point center = element.getLocation();
		Dimension size = element.getSize();
		center.x = center.x + size.getWidth() / 2;
		center.y = center.y + size.getHeight() / 2;
		int rightX = center.getX() + size.getWidth() / 4;
		int bottomY = center.getY() + size.getHeight() / 4;
		int leftX = center.getX() - size.getWidth() / 4;
		int topY = center.getY() - size.getHeight() / 4;
		switch (i) {
		// 看上边
		case 0:
			driver.swipe(center.getX(), topY, center.getX(), bottomY, times);
			break;
		// 看下边
		case 1:
			driver.swipe(center.getX(), bottomY, center.getX(), topY, times);
			break;
		// 看左边
		case 2:
			driver.swipe(leftX, center.getY(), rightX, center.getY(), times);
			break;
		// 看右边
		case 3:
			driver.swipe(rightX, center.getY(), leftX, center.getY(), times);
			break;
		}

	}

	protected void swipeUp(WebElement element) {
		if (element == null) {
			swipUp();
		} else {
			swipe(element, 1, 1000);
		}

	}

	protected void swipeDown(WebElement element) {
		swipe(element, 0, 1000);
	}

	protected void swipeDown(WebElement element, int seconds) {
		Point center = element.getLocation();
		Dimension size = element.getSize();
		center.x = center.x + size.getWidth() / 2;
		center.y = center.y + size.getHeight() / 2;
		int bottomY = center.getY() + size.getHeight() / 4;
		driver.swipe(center.getX(), center.getY(), center.getX(), bottomY, seconds);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void swipeUp(WebElement element, int seconds) {
		Point center = element.getLocation();
		Dimension size = element.getSize();
		center.x = center.x + size.getWidth() / 2;
		center.y = center.y + size.getHeight() / 2;
		int bottomY = center.getY() + size.getHeight() / 4;
		driver.swipe(center.getX(), bottomY, center.getX(), center.getY(), seconds);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取对象的文本属性并返回
	 * 
	 * @param id
	 * @return
	 */
	protected String elementToStr(String id) {
		WebElement element = findElement(id);
		String str = element.getText();
		System.out.println("*** " + element + " text 属性 ：" + str + "***");
		return str;
	}

	private AndroidDriver<WebElement> getAndroidDriver() {
		if (isAndroid) {
			return (AndroidDriver<WebElement>) driver;
		}
		return null;
	}

	/**
	 * @author sys android ios 返回上一个页面
	 */
	protected void Back() {
		if (isAndroid) {
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		} else {
			WebElement element1 = findElement("btn gold back");
			if (element1 != null) {
				element1.click();
			}
			WebElement element2 = findElement("com nav return@2x");
			if (element2 != null) {
				element2.click();
			}
		}
		System.out.println("*** 返回上一级 ***");
	}

	/**
	 * @author sys 判断首页切换城市后 再次进入对 弹框提示的处理
	 */
	protected void isPrompt() {
		if (isAndroid) {
			WebElement el = null;
			el = findElement("com.exiu.exiucarowner:id/dialog_title");
			if (el != null) {
				click("确定");
			}

			// }else {
			// WebElement el =null;
			// el = findElement("温馨提示");
			// if(el!=null) {
			// click("好的");
			// }
			//
		}
	}

	/**
	 * @author sys
	 * @param sWindow
	 *            根据sWindow 切换 上下文
	 */
	protected void switchToWindow(String sWindow) {
		// LogManager.getLogger(this.getClass()).info("Swith to window: " +
		// sWindow);
		Set<String> contextNames = driver.getContextHandles();
		// LogManager.getLogger(this.getClass()).info("Exists windows: " +
		// contextNames.toString());
		for (String contextName : contextNames) {
			if (contextName.contains(sWindow)) {
				driver.context(contextName);
				break;
			}
		}
	}

	/**
	 * @author sys
	 * 
	 *         从NATIVE_APP 切换至WEBVIEW 页面
	 */
	protected void switchtoWeb() {
		if (!isAndroid) {
			return;
		}
		try {
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
				// 用于返回被测app是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型App
				if (contextName.contains("WEBVIEW") || contextName.contains("webview")) {
					driver.context(contextName);
					System.out.println("跳转到web页 开始操作web页面");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author sys 切换至 NATIVE_APP
	 */
	protected void returnNativeApp() {
		if (!isAndroid) {
			return;
		}
		driver.context("NATIVE_APP");
	}

	/**
	 * 拍照选取照片
	 */
	protected void photo() {
		if (isAndroid) {
			// 点击拍照
			click("com.exiu.exiucarowner:id/btn_one");
			// 拍照
			click("com.android.camera:id/v6_shutter_button_internal");
			// 拍照确定
			click("com.android.camera:id/v6_btn_done");
			// 选取照片确定
			click("com.miui.gallery:id/ok");
		}

	}

	/**
	 * 选择性别
	 */
	protected void selectSex(String id) {
		if (isAndroid) {
			click(getId("性别"));
			click(getId(id));
			if (driver.findElementById(getId(id)) != null) {
				Back();
			}
		} else {
			click(getId("性别"));
			click(getId(id));
			click("common save n");
		}
	}

	/**
	 * 选择血型
	 * 
	 * @param id
	 */
	protected void selectBloodtype(String id) {
		if (isAndroid) {
			click(getId("血型"));
			click(getId(id));
			if (driver.findElementById(getId(id)) == null) {

			} else {
				Back();
			}

		} else {
			click(getId("血型"));
			click(getId(id));
		}

	}

	/**
	 * 上传图片
	 * 
	 * @param id
	 */
	protected void updatePhoto(String id) {
		if (isAndroid) {
			click(getId(id));
			WebElement photo = findElement(getId("上传图片"));
			if (photo == null) {
				System.out.println("图片在审核");
			} else {
				photo.click();
				click(getId("拍照"));
				click(getId("拍"));
				click(getId("拍照确定"));
				click(getId("拍照选取确定"));
			}

		}
	}

	/**
	 * carInfo 处理填写车辆信息
	 * 
	 * @param id1
	 * @param id2
	 */
	protected void carInfo(String id1, String id2) {
		click(id1);
		click(id2);
		if (isAndroid) {
			click("保存");
		} else {
			WebElement element4 = findElement("common save n"); // ios 保存按钮
			if (element4 != null) {
				element4.click();
			}
			WebElement element5 = findElement("确定");
			if (element5 != null) {
				element5.click();
			}
		}

	}

	/**
	 * 判断对象是否存在
	 * 
	 * @param id
	 *            被判断的对象
	 * @return
	 */
	protected boolean eleIsExist(String id) {
		WebElement el = findElement(id);
		if (el == null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 判断对象是否存在 zn
	 * 
	 * @param id
	 *            被判断的对象id
	 * @return true=存在 false=不存在
	 */
	protected boolean isExist(String id) {
		return findElement(id) != null;
	}

	

	/**
	 * 删除拨号页面输入的手机号
	 * 
	 * @param Phone
	 *            手机号
	 */
	protected void delPhoneNum(String Phone) {
		for (int i = 0; i < Phone.length();) {
			if (isAndroid) {
				click("com.exiu.exiucarowner:id/delete");
			} else {
				click("car phone dele");
			}
			i++;
		}

	}

	protected void clickTop(WebElement monthElement) {
		Point center = monthElement.getLocation();
		Dimension size = monthElement.getSize();
		center.x = center.x + size.getWidth() / 2;
		center.y = center.y + size.getHeight() / 2;
		int bottomY = center.getY() + size.getHeight() / 4;
		int topY = center.getY() - size.getHeight() / 4;
		driver.tap(1, center.getX(), topY, 100);
	}

	protected void clickBottom(WebElement monthElement) {
		Point center = monthElement.getLocation();
		Dimension size = monthElement.getSize();
		center.x = center.x + size.getWidth() / 2;
		center.y = center.y + size.getHeight() / 2;
		int bottomY = center.getY() + size.getHeight() / 4;
		int topY = center.getY() - size.getHeight() / 4;
		driver.tap(1, center.getX(), bottomY, 100);
	}

	/**
	 * 获取 toast 文本
	 * @param message toast 文本
	 * @return message toast 文本
	 */
	public String getToastMessage(String message) {
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"
				+ message + "')]")));
		message = ele.getText();
		return message;
	}
}
