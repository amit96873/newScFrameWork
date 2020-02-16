package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SigninPage extends BaseTest {
	

	@AndroidFindBy (id = "in.rebase.app:id/sign_in_button") private MobileElement signinbutton;

	
	
public LanguagePage pressSignInBtn() {
		
	click(signinbutton);
	return new LanguagePage();
	}


}
