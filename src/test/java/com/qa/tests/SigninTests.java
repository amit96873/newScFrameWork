package com.qa.tests;

import org.testng.annotations.Test;
import com.qa.BaseTest;
import com.qa.pages.LanguagePage;
import com.qa.pages.PermissionPage;
import com.qa.pages.SigninPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SigninTests extends BaseTest {
	SigninPage signinPage;
	LanguagePage languagePage;
	PermissionPage permissionpage;

	@BeforeClass
	public void beforeClass() {
		
	}

	@AfterClass
	public void afterClass() {
		
	}
	@BeforeMethod
	public void beforeMethod(Method m) {
		signinPage= new SigninPage();
		System.out.println("\n"+"******** starting test:"+m.getName() + "********");
	}

	@AfterMethod
	public void afterMethod() {
		
	}


	@Test
	public void checkSignInButton() {
		
		languagePage = signinPage.pressSignInBtn();
		String actualLanguageTitle = languagePage.getTitle();
		String expectedLangaugeTitle="Language";
		System.out.println("actual title - " + actualLanguageTitle + "\n" + "expected title - "+expectedLangaugeTitle);
		Assert.assertEquals(actualLanguageTitle, expectedLangaugeTitle);
		languagePage.pressEnglishLangBtn();
		permissionpage = languagePage.pressContinueBtnSignin();
		String actualpermissionTitle = permissionpage.getTitlepermission();
		String expectedpermissionTitle="Permissions";
		System.out.println("actual title - " + actualpermissionTitle + "\n" + "expected title - "+expectedpermissionTitle);
		Assert.assertEquals(actualpermissionTitle, expectedpermissionTitle);
		permissionpage.pressagreeAndContinuebtn();
		String actualaccessSmsTitle = permissionpage.getTitleSms();
		String expectedaccessSmsTitle="Allow SmartCoin to send and view SMS messages?";
		System.out.println("actual title - " + actualaccessSmsTitle + "\n" + "expected title - "+expectedaccessSmsTitle);
		Assert.assertEquals(actualaccessSmsTitle, expectedaccessSmsTitle);
		permissionpage.pressdenyButton();
		String actualaccessContatsTitle = permissionpage.getTitleContats();
		String expectedaccessContatsTitle="Allow SmartCoin to access your contacts?";
		System.out.println("actual title - " + actualaccessContatsTitle + "\n" + "expected title - "+expectedaccessContatsTitle);
		Assert.assertEquals(actualaccessContatsTitle, expectedaccessContatsTitle);
		permissionpage.pressdenyButton();
		String actualaccessPhoneCallsTitle = permissionpage.getTitlePhoneCall();
		String expectedaccessPhoneCallsTitle="Allow SmartCoin to make and manage phone calls?";
		System.out.println("actual title - " + actualaccessPhoneCallsTitle + "\n" + "expected title - "+expectedaccessPhoneCallsTitle);
		Assert.assertEquals(actualaccessPhoneCallsTitle, expectedaccessPhoneCallsTitle);
		permissionpage.pressdenyButton();
		String actualaccessLocationTitle = permissionpage.getTitleLocation();
		String expectedaccessLocationTitle="Allow SmartCoin to access this device's location?";
		System.out.println("actual title - " + actualaccessLocationTitle + "\n" + "expected title - "+expectedaccessLocationTitle);
		Assert.assertEquals(actualaccessLocationTitle, expectedaccessLocationTitle);
		
	
	}
	
	

	@Test
	public void checkHindiangBtn() {
		
		languagePage.pressHindiLangBtn();
		permissionpage=languagePage.pressContinueBtnSignin();
		String actualPermissionTitle = languagePage.getTitle();
		String expectedPermissionTitle="अपनी ओर से हमे इजाज़त दीजिए";
		System.out.println("actual title - " + actualPermissionTitle + "\n" + "expected title - "+expectedPermissionTitle);
		Assert.assertEquals(actualPermissionTitle, expectedPermissionTitle);
		
			}
	
	@Test
	public void checkEnglishBtn() {
		
		languagePage.pressHindiLangBtn();
		languagePage.pressContinueBtnSignin();
		String actualPermissionTitle = languagePage.getTitle();
		String expectedPermissionTitle="Permissions";
		System.out.println("actual title - " + actualPermissionTitle + "\n" + "expected title - "+expectedPermissionTitle);
		Assert.assertEquals(actualPermissionTitle, expectedPermissionTitle);
		
			}

	@Test
	public void checkOtherlangBtn() {
		
		languagePage.pressHindiLangBtn();
		languagePage.pressContinueBtnSignin();
		String actualPermissionTitle = languagePage.getTitle();
		String expectedPermissionTitle="Permissions";
		System.out.println("actual title - " + actualPermissionTitle + "\n" + "expected title - "+expectedPermissionTitle);
		Assert.assertEquals(actualPermissionTitle, expectedPermissionTitle);
		
			}
			

}
