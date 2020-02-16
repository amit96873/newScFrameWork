package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LanguagePage extends BaseTest {
	
	@AndroidFindBy (xpath = "//android.widget.RadioButton[@text='English' and @index='0']") private MobileElement englishlanguagebutton;
	@AndroidFindBy (xpath = "//android.widget.RadioButton[@text='हिंदी' and @index='1']") private MobileElement hindilanguagebutton;
	@AndroidFindBy (xpath = "//android.widget.RadioButton[@text='ಕನ್ನಡ' and @index='1']") private MobileElement otherlanguagebutton;
	@AndroidFindBy (id = "in.rebase.app:id/primary_action_text") private MobileElement continuebutton;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Language' and @index='0']") private MobileElement languagetitletxt;

	
	public String getTitle() {
		return getAttribute(languagetitletxt, "text");
	}
	
	
public LanguagePage pressOtherLangBtn() {
		
	click(otherlanguagebutton);
	return this;
	}
public LanguagePage pressHindiLangBtn() {
	
	click(hindilanguagebutton);
	return this;
	}
public LanguagePage pressEnglishLangBtn() {
	
	click(englishlanguagebutton);
	return this;
	}
public PermissionPage pressContinueBtnSignin() {
	
	click(continuebutton);
	return new PermissionPage();
	}
public RegisterNameMobileNumberPage pressContinueBtnSignup() {
	
	click(continuebutton);
	return new RegisterNameMobileNumberPage();
	}
}
