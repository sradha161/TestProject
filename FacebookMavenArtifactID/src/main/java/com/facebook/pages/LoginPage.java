package com.facebook.pages;

import com.facebook.genericpage.CommonMethods;

public class LoginPage extends CommonMethods{

	public LoginPage() throws Exception
	{
		super();
	}

	//clickEmail or phoneno
	public void clickEmailOrPhoneno() {
		click("EmailOrPhone");
	}

	//Enter Email
	public void enterEmail() {
		EnterData("EmailOrPhone", "testData1");
	}
    //enter password
	public void enterPassword() {
		EnterData("Password", "testData2");
	}

	//Click Login Button
	public void clickLoginButton() {
		click("LoginButton");
	}
	public void getFacebookText() {
		getWebElemetText("FacebookText");

	}
}
