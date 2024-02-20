package com.pageObjectClasses;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class BookFlight extends BaseClass{
	
	Controller control = new Controller();
	
	static String price;
	
	@FindBy(xpath=" (//button[text()='Book Now'])[1]")
    WebElement bookBtn;
	
    @FindBy(xpath="(//div[@class='textRight flexOne'])[1]")
     WebElement totalPrice;
    
    //@FindBy(xpath="//button[@class='buttonPrimary buttonBig  lato-black button']")
	//WebElement bookBtnConfirm;
    
    @FindBy(xpath="//button[@class='addTravellerBtn']")
    WebElement addAdultBtn;
    
    @FindBy(xpath="//input[@type='checkbox']")
    WebElement addAdultChkbox;
    
    @FindBy(xpath=" //input[@placeholder='First & Middle Name']")
    WebElement firstName;
    
    @FindBy(xpath=" //input[@placeholder='Last Name']")
    WebElement lastName;
    
    @FindBy(xpath="//label//input[@value='MALE']")
   WebElement gender;
       
    @FindBy(xpath="//div[@class='dropdown__value-container css-1hwfws3']")
    WebElement wheelchairBtn;
    
    @FindBy(xpath="//div[contains(text(),'Nationality')]")
    WebElement nationality;
    
    @FindBy(id="react-select-3-option-1")
    WebElement nationalitySelBtn;
    
    @FindBy(xpath="//div[contains(text(),'Passport Issuing Country')]")
    WebElement passportCountry;
    
    @FindBy(id="react-select-8-option-1")
    WebElement passCountry;
    
    @FindBy(xpath="//span//input[@type='checkbox']")
    WebElement checkBox;
    
    
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    JavascriptExecutor script = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);
    
     public BookFlight() 
     {
    	PageFactory.initElements( driver,this);
      }
    
    
     public  String getPrice() {
    	 script.executeScript("window.scroll(0,300)");
		price = totalPrice.getText().substring(2);
    	 System.out.println("Booking Price :"+price);
    	return price;
    	 
     }
    public void clickOnBookBtn() 
    {
    	wait.until(ExpectedConditions.visibilityOf(bookBtn));
    	control.click(bookBtn);		    
    }
   
    public void switchWindows() throws InterruptedException  
     {
    	Set<String> windows = driver.getWindowHandles();
    	Iterator<String> it = windows.iterator();
    	String parentId = it.next();
    	String childId = it.next(); 
    	driver.switchTo().window(childId);
        script.executeScript("window.scroll(0,2000)");
        wait.until(ExpectedConditions.visibilityOf(addAdultBtn));
    	control.click(addAdultBtn);
    	if(!addAdultChkbox.isEnabled()){
    		control.click(addAdultChkbox); 		
    		//Thread.sleep(2000);
    	}
    	passengerInfo();
    	
    
         }
    public void passengerInfo() throws InterruptedException 
       {
   		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    	firstName.sendKeys("Sam");
    	lastName.sendKeys("Smith");
    	control.click(gender);
    	
    	nationality.click();
    	wait.until(ExpectedConditions.visibilityOf(nationalitySelBtn));
    	nationalitySelBtn.click();
    	       	
}
}