package tests;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjectClasses.BookFlight;


public class BookFlightTest extends BaseClass{
	
	@Test
	public void BookFlight() throws InterruptedException {
	
	BookFlight book = new BookFlight();

	book.clickOnBookBtn();
	book.getPrice();
	book.switchWindows();
	
}
}