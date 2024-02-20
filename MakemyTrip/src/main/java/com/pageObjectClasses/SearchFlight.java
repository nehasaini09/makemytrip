package com.pageObjectClasses;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class SearchFlight extends BaseClass {
	
	
	
	@FindBy(xpath="//div//label[@for='toCity']")
	WebElement arrivalTo ;
	
	@FindBy(xpath="//input[@placeholder='To']")
	WebElement arrivalBox;
	
	@FindBy(id="react-autowhatever-1-section-0-item-0")
	WebElement selectCity; 
	
	@FindBy(xpath ="//div//label[@for='fromCity']")
	WebElement  departureFrom ;
	
	@FindBy(xpath="//input[@placeholder='From']")
	WebElement departureBox;
	
	@FindBy(xpath="//div//p[@class='font14 appendBottom5 blackText']")
	List<WebElement> list;
	
	@FindBy(xpath="//div//label[@for='departure']")
	WebElement departureDate ;
	
	@FindBy(xpath="//div//label[@for='return']")
	WebElement ReturnDate ;
	
	@FindBy(xpath="//li[@data-cy='roundTrip']")
	WebElement roundTrip;
	
	@FindBy(xpath="//span[@aria-label='Next Month']")
	WebElement nextMonthButton;
	
	@FindBy(xpath="//a[text()='Search']")
	WebElement searchBtn;
	
	//Constructor
	public SearchFlight() {
		PageFactory.initElements( driver,this);
	}
	
    public void selectRoundTrip() {
		roundTrip.click();
	}
	public void addDepartureCity() {
		departureFrom.click();
		
	}
	public void selectDepartureCity() throws InterruptedException {
		departureBox.sendKeys("Phoenix");
		Thread.sleep(1000);
		selectCity.click();		
		
	}
		public void addArrivalCity() {
			arrivalTo.click();
			
		}
		
		public void selectArrivalCity() throws InterruptedException {
			arrivalBox.sendKeys("New York");
			Thread.sleep(1000);
			selectCity.click();		
					       
}
		
 public void selectDepartureDate() {
	 boolean dateFound = false;
 	String dateDeparture = "Fri Apr 05 2024";
 	while (!dateFound) {
 	    try {
 	        WebElement dateDep = driver.findElement(By.xpath("//*[@aria-label='" + dateDeparture + "']"));
 	        if (dateDep.isDisplayed()) {
 	            dateDep.click();
 	            dateFound = true;
 	        }
 	    } catch (Exception ex) {
 	        nextMonthButton.click();
 	    }
 	}
 	
 }
 	
 	public void selectReturnDate() {
 		 boolean dateFound = false;
 	 	String dateReturn = "Thu May 23 2024";
 	 	while (!dateFound) {
 	 	    try {
 	 	        WebElement dateDep = driver.findElement(By.xpath("//*[@aria-label='" + dateReturn + "']"));
 	 	        if (dateDep.isDisplayed()) {
 	 	            dateDep.click();
 	 	            dateFound = true;
 	 	        }
 	 	    } catch (Exception ex) {
 	 	        nextMonthButton.click();
 	 	    }
 	 	}
 }


public void clickOnSearch() {
	searchBtn.click();
}




}
