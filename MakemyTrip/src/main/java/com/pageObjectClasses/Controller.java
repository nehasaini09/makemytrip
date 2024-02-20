package com.pageObjectClasses;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class Controller extends BaseClass {
	
	 public void clickDropdownMenu(WebElement dropdownElement) {
	        try {
	            dropdownElement.click();
	        } catch (StaleElementReferenceException e) {
	            WebElement element= dropdownElement;
	               element.click();
	        }
	    }
	
	 public void forMethod(List<WebElement> e,String s) {
	    	for(WebElement list : e) {
	    		String text= list.getText();
	    		if(text.equalsIgnoreCase(s)) {
	    			list.click();
	    			break;
	    		}
	    		
	    	}
	 }
	 public void click(WebElement element) {
		 element.click();
		 
		 
	
	
	 }
}
