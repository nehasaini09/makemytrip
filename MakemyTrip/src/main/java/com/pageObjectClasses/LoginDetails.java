package com.pageObjectClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.BaseClass;

public class LoginDetails extends BaseClass{
	
	Controller control = new Controller();
	
	    @FindBy(xpath="//div//input[@placeholder='Mobile No']")
	    WebElement mobileNo;
	    
	    @FindBy(xpath="//div//input[@placeholder='Email']")
	    WebElement email;
	    
	    @FindBy(xpath="//button[@class='lato-black button buttonPrimary extraPadBtn fontSize16 ']")
	    WebElement continu;
	    
	    @FindBy(xpath="(//div)[175]")
	    WebElement dobDate;
	    
	    @FindBy(xpath="//div[@id='react-select-4-option-1']")
	    WebElement dobDateSel;
	    
	    @FindBy(xpath="(//div)[186]")
	    WebElement dobMonth;
	    
	    @FindBy(id="react-select-5-option-2")
	    WebElement dobMonthSel;
	    
	    @FindBy(xpath="(//div)[197]")
	    WebElement dobYear;
	    
	    @FindBy(xpath="//div[@id='react-select-6-option-35']")
	    WebElement dobYearSel;
	    
	    @FindBy(xpath="(//div[@class='dropdown__control css-yk16xz-control'])[6]")
	    WebElement expDate;
	    
	    @FindBy(xpath="(//div[@class='dropdown__control css-yk16xz-control'])[7]")
	    WebElement expMonth;
	    
	    @FindBy(xpath="(//div[@class='dropdown__control css-yk16xz-control'])[8]")
	    WebElement expYear;
	    
	    @FindBy(xpath="//div//button[@class='loginBtn']")
	    WebElement loginBtn;
	    
	    @FindBy(xpath="//div//input[@name='username']")
	    WebElement username;
	    
	    @FindBy(xpath="//div//button[@data-cy='continueBtn']")
	    WebElement continueBtn;
	    
	    @FindBy(xpath="//input[@placeholder='Minimum 6 characters.']")
	    WebElement pwsd;
	    
	    @FindBy(xpath="//div//button[@type='submit']")
	    WebElement login;
	    
	    @FindBy(xpath="//input[@placeholder='Passport No']")
	    WebElement passportNo;
	       
	    @FindBy(xpath="(//input[@value='false'])[1]")
	    WebElement checkbox;
	    
	    @FindBy(xpath="(//div[contains(@class,'adultList')]//input[@type='checkbox'])")
	    WebElement addDob;
	    
	    @FindBy(className ="dropdown__option")
	    List<WebElement> passportCountry;
	    
	    @FindBy(xpath="//span[@class='lato-black append-right5 dollar']")
	    WebElement finalPrice1;
	    
	    @FindBy(xpath="//button[text()='CONFIRM']")
	    WebElement confirmBtn;
	    
	    @FindBy(xpath="//button[text()='Proceed to pay']")
	    WebElement proceedToPayBtn;
	    
	    BookFlight b=new BookFlight();
	    
	    public LoginDetails() {
	    	PageFactory.initElements(driver,this);
	    }
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    JavascriptExecutor script = (JavascriptExecutor) driver;
	    Actions actions = new Actions(driver);
	    
	    
	    public void passDetails() throws InterruptedException 
	    {
	    	 wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
	         wait.until(ExpectedConditions.elementToBeClickable(continu));
	         actions.doubleClick(continu).perform();
	         
	         Thread.sleep(2000);
	         checkbox.click();   
	          }
	    
	    public void comparePrice() throws InterruptedException {
	    	String bookingPrice = b.price;
	    	System.out.println(bookingPrice);
	    	//Thread.sleep(1000);
	    	wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
	    	wait.until(ExpectedConditions.visibilityOf(finalPrice1));
	    	String finalPrice = finalPrice1.getText();
	    	System.out.println("After login price :"+finalPrice);
	   Assert.assertEquals(bookingPrice,finalPrice);
	    }
	    
	    public void addDates() throws InterruptedException {
	    	wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
	    	script.executeScript("window.scroll(0,1900)");
	    	addDob.click();
	    	
	    	dobDate.click();
	    	dobDateSel.click();
	    	dobMonth.click();
	    	dobMonthSel.click();
	    	
	    	dobYear.click();
	    	dobYearSel.click();
	    	
	    	passportNo.click();
	    	driver.findElement(By.xpath("//input[@placeholder='Passport No']")).sendKeys("G1145674");
	    	
	    	driver.findElement(By.xpath("//div[contains(text(),'Passport Issuing Country')]")).click();
	    	control.forMethod(passportCountry, "India");
	    	expDate.click();
	    	control.forMethod(passportCountry, "02");
	    	expMonth.click();
	    	control.forMethod(passportCountry, "Feb");
	    	expYear.click();
	    	control.forMethod(passportCountry, "2026");
	    	 }
	    
	    public void addPhoneandEmail() {
	    	wait.until(ExpectedConditions.elementToBeClickable(continu)) ;
	    	 
	    	 mobileNo.sendKeys("8019205917");	
	         email.sendKeys("aryasen09@yahoo.com");
	         wait.until(ExpectedConditions.elementToBeClickable(continu));
	         actions.doubleClick(continu).perform();
	         confirmBtn.click();
	          }
	    public void paymentMethod() {
	    	wait.until(ExpectedConditions.visibilityOf(proceedToPayBtn));
	    	proceedToPayBtn.click();
	    	
	    }
	
	   public void loginDetails() throws InterruptedException {   
		  
		   loginBtn.click();
		   username.sendKeys("aryasen09@yahoo.com");
		   wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		   actions.doubleClick(continueBtn).perform();
		    pwsd.click();
		   if(pwsd.isEnabled()) {
			   
		    driver.findElement(By.xpath("//input[@placeholder='Minimum 6 characters.']")).sendKeys(config.getPwsd());
		   }
	       login.click();
	   
	   }
	
	
	

}
