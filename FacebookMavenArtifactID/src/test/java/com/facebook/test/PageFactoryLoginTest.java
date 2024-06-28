package com.facebook.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.facebook.genericpage.CommonMethods;
import com.facebook.genericpage.MasterPage;
import com.facebook.pages.PageFactoryLogin;

public class PageFactoryLoginTest extends CommonMethods{


	public PageFactoryLoginTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void LoginTest() 
	{
		PageFactoryLogin pfc = PageFactory.initElements(driver, PageFactoryLogin.class);
		pfc.clickEmail();
		pfc.enterEmail();
		pfc.clickPassword();
		pfc.enterPassword();
		}
	
	@AfterTest
	public static void closeLoginPage()
	{
		MasterPage.driver.close();
	}



}
