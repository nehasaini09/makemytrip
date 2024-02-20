package tests;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjectClasses.SearchFlight;

public class SearchFlightTest extends BaseClass {

	@Test
	public void searchForFlight() throws InterruptedException {
	SearchFlight sf = new SearchFlight();
	sf.selectRoundTrip();
	sf.addDepartureCity();
	sf.selectDepartureCity();
	sf.addArrivalCity();
	sf.selectArrivalCity();
	sf.selectDepartureDate();
	sf.selectReturnDate();
	sf.clickOnSearch();
	}
	
	
}
