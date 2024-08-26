package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.DataProvider;
import utils.Utils;

public class LoginTests extends BaseTest {

	@Override
	@BeforeClass
	public void setup_Login() {
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test (dataProvider = "getData",  description = "Invalid Login")
	@Description("3 option of failed login tests")
	public void tc01_failedLogin(String email, String password) {
		homePage.openMyAccount();
		homePage.clickLoginBtn();
		
		// Read from DataProvider annotation
		loginPage.login(email, password);
		
		String actual = loginPage.getErrorMsg();
		AssertJUnit.assertEquals(actual, "Warning: No match for E-Mail Address and/or Password.");
	}

	@Severity(SeverityLevel.MINOR)
	@Test (description = "Valid Login")
	@Description("Valid email and password")
	public void tc02_validLogin() {
		homePage.openMyAccount();
		homePage.clickLoginBtn();
		
		//Read from data file 
		loginPage.login(Utils.readValue("validMail"), Utils.readValue("validPassword"));
		
		AssertJUnit.assertTrue(myAccountPage.isThisMyAccountPage());
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"roi@gmail.com", "abc1234"},
				{"roi@gmail.com", "Aa123456"},
				{"roidv1988@gmail.com", "abc1234"},	
		};
		return myData;
	}
}