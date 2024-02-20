package tests;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjectClasses.LoginDetails;

public class LoginTest extends BaseClass{
	
	
	@Test
	public void login() throws InterruptedException {
		LoginDetails login = new LoginDetails();
		
		login.passDetails();
		login.addDates();
		login.addPhoneandEmail();
		login.paymentMethod();
		
		//login.loginDetails();
		login.comparePrice();
		
	}

}
