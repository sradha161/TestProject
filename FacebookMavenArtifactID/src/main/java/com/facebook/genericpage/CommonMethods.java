package com.facebook.genericpage;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods extends MasterPage {

	public CommonMethods() throws Exception {
		super();
	}

	// click Method
	public void click(String xpathKey) {
		driver.findElement(By.xpath(or.getProperty(xpathKey))).click();
		//driver.findElement(By.xpath(xpathKey)).click();
	}

	// EnterData
	public void EnterData(String xpath, String Testdata) {
		driver.findElement(By.xpath(or.getProperty(xpath))).sendKeys(td.getProperty(Testdata));
		//driver.findElement(By.xpath(xpath)).sendKeys(td.getProperty(Testdata));
	}

	// clearData
	public void clearData(String xpathKey) {
		driver.findElement(By.xpath(or.getProperty(xpathKey))).clear();

	}

	// MouseOver
	public void moveToElement(String xpathKey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(or.getProperty(xpathKey)))).build().perform();
	}

	// Click list of web element & concept of radio button
	public void clickListElement(String xpathKey, String testData) {

		List<WebElement> listOfWebElements = driver.findElements(By.xpath(or.getProperty(xpathKey)));
		for (WebElement listOfWebElement : listOfWebElements) {
			if (listOfWebElement.getText().equalsIgnoreCase(testData)) {
				listOfWebElement.click();
			}
		}
	}

	// Select dropdown values
	public void selectDropdownValue(String xpathKey, String testData1, String testData2) {

		WebElement ele = driver.findElement(By.xpath(or.getProperty(xpathKey)));
		Select webele = new Select(ele);
		webele.selectByVisibleText(td.getProperty(testData1));
		webele.selectByValue(td.getProperty(testData2));
	}


	//Retrieve value of any web element
	public void getWebElemetText(String xpathKey)
	{
	String getTextOfWebElement	= driver.findElement(By.xpath(or.getProperty(xpathKey))).getText();
	System.out.println(getTextOfWebElement);
	}

	//Reading Excel Data
	public void readExcelData(String xpathKey, int rowNo, int coloumnNo) throws Exception {

		File src = new File(".\\src\\main\\java\\com\\facebook\\data\\ATB Topics Sheet - Automation Tester _ TheTestingAcademy.xlsx");
		FileInputStream fis	= new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Software Testing Basics");
		System.out.println(sh.getSheetName());
		String abc = sh.getRow(rowNo).getCell(coloumnNo).getStringCellValue();
		driver.findElement(By.xpath(or.getProperty(xpathKey))).sendKeys(abc);
	}

}
