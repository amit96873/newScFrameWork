package com.qa;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	protected static HashMap<String, String> strings=new HashMap<String, String>();
	InputStream inputStream;
	InputStream stringsis;
	TestUtils utils;
	public BaseTest() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

  @Parameters({"platformName", "platformVersion", "devicename"})
  @BeforeTest
  public void beforeTest(String platformName, String platformVersion, String deviceName) throws Exception {
	  
	  try {
		    props = new Properties();
		    String propFileName = "config.properties";
		    String xmlFileName="strings/strings.xml";
		    inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		    props.load(inputStream);
		    stringsis=getClass().getClassLoader().getResourceAsStream(xmlFileName);
		    utils = new TestUtils();
		    strings=utils.paseStringXML(stringsis);
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
			dc.setCapability("appPackage", props.getProperty("androidAppPackage"));
			dc.setCapability("appActivity", props.getProperty("androidAppActivity"));
			URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
			dc.setCapability("app", appUrl);
			URL url = new URL(props.getProperty("appiumURL"));
			driver = new AndroidDriver<WebElement>(url,dc);
			String sessionId = driver.getSessionId().toString();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw e;
		     }finally {
		    	 if(inputStream !=null) {
		    		 inputStream.close();
		    	 }
		    	 if(stringsis !=null) {
		    		 stringsis.close();
		    	 }
		     }
			
		}
 
 
 public void waitForVisibility(MobileElement e) {
	 
	 WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
	 wait.until(ExpectedConditions.visibilityOf(e));
 }
 
 public void click(MobileElement e) {
	 
	 waitForVisibility(e);
	 e.click();
 }
 
 public void sendkeys(MobileElement e, String txt) {
	 waitForVisibility(e);
	 e.sendKeys(txt);
 }
 
 
 public String getAttribute(MobileElement e, String attribute) {
	  waitForVisibility(e);
	return  e.getAttribute(attribute);
 }
  

 
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
