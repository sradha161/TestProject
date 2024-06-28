package com.facebook.genericpage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterPage {
	/*
	 * or, td, prop: These are instances of the Properties class, which is used in
	 * Java for handling key-value pairs, typically for managing configuration
	 * settings, test data, and locators (object repository).
	 */
	public static WebDriver driver;
	public Properties or; // locators
	public Properties td; // testdata
	public Properties prop; // config

	/*
	 * The constructor's main purpose is to initialize the or, td, prop objects with
	 * the properties loaded from properties file.By loading these properties into
	 * or, td, prop, other parts of your framework or tests can access and utilize
	 * these configurations easily
	 */

	public MasterPage() throws Exception {

		// Configuration Properties File Implementation

		/*
		 * FileInputStream ip = new FileInputStream(...): This line initializes a
		 * FileInputStream object named ip to read data from the
		 * configuration.properties file.
		 */
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\facebook\\repository\\configuration.properties");

		prop = new Properties(); // Initializes the Properties object named prop.

		prop.load(ip); // : Loads the properties from the FileInputStream (ip) into the prop object.
						// The load() method reads a property list (key and element pairs) from the
						// input stream.

		// Locators Properties File Implementation

		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\facebook\\repository\\locators.properties");
		or = new Properties(); // Initializes the Properties object named prop.
		or.load(fs);

		// TestData Properties File Implementation

		FileInputStream ts = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\facebook\\repository\\testdata.properties");
		td = new Properties(); // Initializes the Properties object named prop.
		td.load(ts);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\com\\facebook\\drivers\\chromedriver.exe");
			// Check the chromedriver.exe path in the project level
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\com.facebook.drivers\\geckodriver.exe");
			// Check the chromedriver.exe path in the project level
		}
		else {
			System.out.println("Open IE Browser");
		}
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));
	}

}
