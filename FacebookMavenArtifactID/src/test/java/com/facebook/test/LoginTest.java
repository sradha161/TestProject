package com.facebook.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.facebook.genericpage.MasterPage;
import com.facebook.pages.LoginPage;

public class LoginTest {

	@Test
	public void LoginTestPage() throws Exception
	{
	LoginPage lp = new LoginPage();
	lp.clickEmailOrPhoneno();
	lp.enterEmail();
	lp.enterPassword();
	lp.getFacebookText();
	lp.clickLoginButton();
	Thread.sleep(2000);
	lp.readExcelData("EmailOrPhone", 3, 1);
	Thread.sleep(2000);
	
	}

	@AfterTest
	public static void closeLoginPage()
	{
		MasterPage.driver.close();
	}

}
