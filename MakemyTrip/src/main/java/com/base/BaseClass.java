package com.base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.utilites.ConfigReader;


public class BaseClass {
	
	public static WebDriver driver;
	public static ConfigReader config = new ConfigReader();
	public static String browserName = config.getBrowser();
	public static String url = config.getUrl();
	 
	
@BeforeTest
public void intializeBrowser() {
		
	if(browserName.equalsIgnoreCase("chrome")) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--disable-popup-blocking");
		driver= new ChromeDriver(option);
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
			}
	
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
	}

  		@AfterTest
    public void tearDown() {
    	driver.quit();
    }


}

