package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.facebook.genericpage.CommonMethods;


public class PageFactoryLogin {

	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailOrPhone;

	@FindBy(xpath = "//input[@id='pass']")
	WebElement Password;

	public void clickEmail() {
		EmailOrPhone.click();
		//click("EmailOrPhone");
	}

	public void enterEmail() {
		EmailOrPhone.sendKeys("sradha161");
		//EnterData("EmailOrPhone", "testData1");
	}

	public void clickPassword() {
		Password.click();
		//click("Password");
	}

	public void enterPassword() {
		//EnterData("Password", "testData1");
		Password.sendKeys("123423");
	}
}
