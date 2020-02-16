
package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterNameMobileNumberPage extends BaseTest {
	
	@AndroidFindBy (id = "in.rebase.app:id/primary_action_text") private MobileElement regcontinuebutton;	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Need Instant Loan? Register with us...' and @index='1']") private MobileElement registernamenumtitletxt;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Full Name' and @index='2']") private MobileElement upfullnamelayer;
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Mobile Number' and @index='2']") private MobileElement upmobilenumberlayer;
	@AndroidFindBy (id = "in.rebase.app:id/name") private MobileElement fullnameTxtFld;
	@AndroidFindBy (id = "in.rebase.app:id/mobile_number") private MobileElement mobileNumberTxtFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]") private MobileElement upregistrationandcontinuebutton;
	
	
	
	public String getTitle() {
		return getAttribute(registernamenumtitletxt, "text");
	}
	
	public RegisterNameMobileNumberPage pressUpFullName() {
		
		click(upfullnamelayer);
		return this;
		}
public RegisterNameMobileNumberPage enterFullName(String fullname) {
	sendkeys(fullnameTxtFld, fullname);
	return this;

	}
public RegisterNameMobileNumberPage pressUpMobileNumber() {
	
	click(upmobilenumberlayer);
	return this;
	}

public RegisterNameMobileNumberPage enterMobileNumber(String mobileNumber) {
	sendkeys(mobileNumberTxtFld, mobileNumber);
    return this;
	}
public RegisterNameMobileNumberPage pressUpRegContinueBtn() {
	
	click(upregistrationandcontinuebutton);
	return this;
	}

public PermissionPage pressRegContinueBtn() {
	
click(regcontinuebutton);
return new PermissionPage();
}
}
