package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LogoutTest extends BaseTest {

	@Severity(SeverityLevel.MINOR)
	@Test (description = "Logout Test Validation")
	@Description("Logout test validation")
	public void tc01_logoutTest() {
		homePage.openMyAccount();
		homePage.clickLogoutBtn();
		String actual = logoutPage.getLogoutMsg();
		AssertJUnit.assertEquals(actual, "You have been logged off your account.");
		
	}
	
}
