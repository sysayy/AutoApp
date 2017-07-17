package com.exiu.developer;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import com.exiu.api.Account;
import com.exiu.api.AgeSelector;
import com.exiu.api.CarPlateInput;
import com.exiu.api.CarSelector;
import com.exiu.api.CategorySelector;
import com.exiu.api.CitySelector;
import com.exiu.api.DateTimePicker;
import com.exiu.api.Dial;
import com.exiu.api.InterestSelector;
import com.exiu.api.PersonPicker;
import com.exiu.api.Photo;
import com.exiu.api.ConversionNumber;
import com.exiu.api.SortFilter;
import com.exiu.developer.impl.AccountImpl;
import com.exiu.developer.impl.AgeSelectorImpl;
import com.exiu.developer.impl.CarPlateInputImpl;
import com.exiu.developer.impl.CarSelectorImpl;
import com.exiu.developer.impl.CategorySelectorImpl;
import com.exiu.developer.impl.CitySelectorImpl;
import com.exiu.developer.impl.ConversionNumberImpl;
import com.exiu.developer.impl.DateTimePickerImpl;
import com.exiu.developer.impl.DialImpl;
import com.exiu.developer.impl.InterestSelectImpl;
import com.exiu.developer.impl.PersonPickerImpl;
import com.exiu.developer.impl.PhotoImpl;
import com.exiu.developer.impl.SortFilterImpl;

public class BaseTestCase extends BaseTest {
	protected static final boolean isStandard = getTestTye();
	protected SortFilter sortFilter = new SortFilterImpl();
	protected CitySelector citySelector = new CitySelectorImpl();
	protected InterestSelector interestSeleect = new InterestSelectImpl();
	protected AgeSelector ageSelector = new AgeSelectorImpl();
	protected CategorySelector categorySelect = new CategorySelectorImpl();
	protected CarSelector carSelect = new CarSelectorImpl();
	protected CarPlateInput carPlateInput = new CarPlateInputImpl();
	protected Account account = new AccountImpl();
	protected Dial dial = new DialImpl();
	protected Photo photo = new PhotoImpl();
	protected ConversionNumber conversionNumber = new ConversionNumberImpl();
	protected PersonPicker personPicker = new PersonPickerImpl();
	protected DateTimePicker dateTimePicker = new DateTimePickerImpl();
	private static final String ResultsDir = UserDir + "/results";
	private static final String ParametersDir = UserDir + "/parameters";
	private static final String PhotoDir = UserDir + "/photo";
	private Properties parametersProperties = null;
	private static double Percent;

	public BaseTestCase() {
		super();
		initParameters();
	}

	protected void screenShoot(String name) throws Exception {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		name = this.getClass().getSimpleName() + "_" + name;
		File standardFile = new File(getRealPath(PhotoDir) + "/standard", name + ".jpg");
		if (!standardFile.getParentFile().exists()) {
			standardFile.getParentFile().mkdirs();
		}
		if (isStandard) {
			FileOutputStream fileOutputStream = new FileOutputStream(standardFile);
			fileOutputStream.write(screenshotAs);
			fileOutputStream.close();
		} else {
			File testFile = new File(getRealPath(PhotoDir) + "/test", name + ".jpg");
			if (!testFile.getParentFile().exists()) {
				testFile.getParentFile().mkdirs();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(testFile);
			fileOutputStream.write(screenshotAs);
			fileOutputStream.close();
			try {
				if (standardFile == null || !standardFile.exists() || standardFile.length() == 0) {
					throw new RuntimeException("请先设置标准图片");
				}
				// BufferedImage source = ImageIO.read(standardFile);
				// BufferedImage test = ImageIO.read(testFile);
				// boolean b = comparePhoto(source, test);
				// if (!b) {
				// throw new RuntimeException("图片比对失败:" + name);
				// }
				float compare = compare(standardFile, testFile);
				if (compare >= Percent) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>compare:" + compare);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Percent:" + Percent);
				} else {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>compare:" + compare);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Percent:" + Percent);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
					throw new RuntimeException("图片比对失败:" + name);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public float compare(File stand, File test) {
		BufferedImage bufileInput = null;
		try {
			bufileInput = ImageIO.read(stand);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		DataBuffer dafileInput = bufileInput.getData().getDataBuffer();

		int sizefileInput = dafileInput.getSize();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> sizefileInput:" + sizefileInput);

		BufferedImage bufileOutPut = null;
		try {
			bufileOutPut = ImageIO.read(test);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();
		int sizefileOutPut = dafileOutPut.getSize();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> sizefileOutPut:" + sizefileOutPut);
		float diff = 0;
		if (sizefileInput == sizefileOutPut) {
			for (int j = 0; j < sizefileInput; j++) {
				if (dafileInput.getElem(j) != dafileOutPut.getElem(j)) {

					diff++;
				}
			}
			return (sizefileInput - diff) / sizefileInput;

		} else {
			return 0;
		}
	}

	private boolean comparePhoto(BufferedImage source, BufferedImage test) {
		if (source.getWidth() != test.getWidth()) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> source.getWidth():" + source.getWidth());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> test.getWidth():" + test.getWidth());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> 宽度不匹配");
			return false;
		}
		if (source.getHeight() != test.getHeight()) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> source.getHeight():" + source.getHeight());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> test.getHeight():" + test.getHeight());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>> 高度不匹配");
			return false;
		}
		int width = source.getWidth();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> source.getWidth():" + source.getWidth());
		int height = source.getHeight();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> source.getHeight():" + source.getHeight());
		int numDiffPixels = 0;
		for (int y = 80; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (source.getRGB(x, y) != test.getRGB(x, y)) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>x :" + x);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>x :" + y);

					System.out.println(">>>>>>>>>>>>>>>>>>>>>>> source.getRGB(x, y):" + source.getRGB(x, y));
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>> test.getRGB(x, y):" + test.getRGB(x, y));
					numDiffPixels++;
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>> numDiffPixels:" + numDiffPixels);
				}
			}
		}
		double numberPixels = height * width;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> numberPixels = height * width:" + numberPixels);
		double diffPercent = numDiffPixels / numberPixels;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> diffPercent = numDiffPixels / numberPixels:" + diffPercent);
		return Percent <= 1.0D - diffPercent;
	}

	protected String getParameter(String key) {
		return parametersProperties.getProperty(key);
	}

	private static boolean getTestTye() {
		Properties properties = new Properties();
		try {
			File file = new File(Globle);
			InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(file), "UTF-8");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = properties.getProperty("isStandard");
		String percentString = properties.getProperty("photoPercent");
		Percent = Double.parseDouble(percentString) / 100;
		if ("true".equals(property)) {
			return true;
		}
		return false;
	}

	private void initParameters() {
		File file = new File(getRealPath(ParametersDir), this.getClass().getSimpleName() + ".properties");
		if (!file.exists()) {
			return;
		}
		try {
			parametersProperties = new Properties();
			InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(file), "UTF-8");
			parametersProperties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	protected void compare(String parameter, String root, String fieldName) {
		File dir = new File(getRealPath(ResultsDir));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, this.getClass().getSimpleName() + ".prorerties");
		Properties properties = getPropertiesFromFile(file);
		List<WebElement> findElements = findElements(root, fieldName);
		if (findElements != null) {
			List<String> list = new ArrayList<String>();
			for (WebElement webElement : findElements) {
				list.add(webElement.getText());
			}
			String result = list.toString();
			if (isStandard) {
				System.out.println("标准库：" + result);
				properties.setProperty(URLEncoder.encode(parameter), result);
				setPropertiesToFile(properties, file);
			} else {

				if (isAndroid) {

					if (result.equals(properties.getProperty(URLEncoder.encode(parameter)))) {
						System.out.println("Test ：" + result);
						System.out
								.println("properties result ：" + properties.getProperty(URLEncoder.encode(parameter)));
					} else {
						System.out.println("Failure ：" + result);
						System.out
								.println("properties result ：" + properties.getProperty(URLEncoder.encode(parameter)));
						throw new RuntimeException("比对失败");
					}

				} else {
					if (result.contains(properties.getProperty(URLEncoder.encode(parameter)))) {
						System.out.println("Test ：" + result);
						System.out
								.println("properties result ：" + properties.getProperty(URLEncoder.encode(parameter)));
					} else {
						System.out.println("Failure ：" + result);
						System.out
								.println("properties result ：" + properties.getProperty(URLEncoder.encode(parameter)));
						throw new RuntimeException("比对失败");
					}

				}

			}
		} else {
			System.out.println(root + "--------列表为空");
		}
	}
}
