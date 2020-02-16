package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignupPage extends BaseTest {
	
	@AndroidFindBy (id = "in.rebase.app:id/sign_up_button") private MobileElement signupbutton;
	

	
	

public LanguagePage pressSignUpBtn() {
	
	click(signupbutton);
	return new LanguagePage();
	}

}
