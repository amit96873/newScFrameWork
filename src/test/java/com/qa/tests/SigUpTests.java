package com.qa.tests;

import org.testng.annotations.Test;
import com.qa.BaseTest;
import com.qa.pages.LanguagePage;
import com.qa.pages.PermissionPage;
import com.qa.pages.RegisterNameMobileNumberPage;
import com.qa.pages.SignupPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class SigUpTests extends BaseTest {
	SignupPage signupPage;
	LanguagePage languagePage;
	PermissionPage permissionpage;
	RegisterNameMobileNumberPage registrationpage;
	InputStream datais;
	JSONObject loginuser;

	@BeforeClass
	public void beforeClass() throws Exception {
		try {
      String dataFileName = "data/loginuser.json";
      datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
      JSONTokener tokener= new JSONTokener(datais);
      loginuser = new JSONObject(tokener);
      
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}finally {
	if(datais!=null) {
		datais.close();
	}
		
	       }
	}
	@AfterClass
	public void afterClass() {

	}
	@BeforeMethod
	public void beforeMethod(Method m) {
		signupPage= new SignupPage();
		System.out.println("\n"+"******** starting test:"+m.getName() + "********");
	}

	@AfterMethod
	public void afterMethod() {

	}

	@Test
	public void checkSignUpButton() {

		languagePage = signupPage.pressSignUpBtn();
		String actualLanguageTitle = languagePage.getTitle();
		String expectedLangaugeTitle=strings.get("Language_Page_Title");
		System.out.println("actual title - " + actualLanguageTitle + "\n" + "expected title - "+expectedLangaugeTitle);
		Assert.assertEquals(actualLanguageTitle, expectedLangaugeTitle);
		languagePage.pressEnglishLangBtn();
		registrationpage = languagePage.pressContinueBtnSignup();
		String actualregistrationTitle = registrationpage.getTitle();
		String expectedregistrationTitle=strings.get("RegistrationFullnameMobilenumber_Page_Title");
		System.out.println("actual title - " + actualregistrationTitle + "\n" + "expected title - "+expectedregistrationTitle);
		Assert.assertEquals(actualregistrationTitle, expectedregistrationTitle);
		registrationpage.pressUpFullName();
		registrationpage.enterFullName(loginuser.getJSONObject("validuser").getString("full_name"));
		registrationpage.pressUpMobileNumber();
		registrationpage.enterMobileNumber(loginuser.getJSONObject("validuser").getString("Mobile_Number"));
		registrationpage.pressUpRegContinueBtn();
		permissionpage = registrationpage.pressRegContinueBtn();
		String actualpermissionTitle = permissionpage.getTitlepermission();
		String expectedpermissionTitle=strings.get("Permission_Page_Title");
		System.out.println("actual title - " + actualpermissionTitle + "\n" + "expected title - "+expectedpermissionTitle);
		Assert.assertEquals(actualpermissionTitle, expectedpermissionTitle);


	}





}
