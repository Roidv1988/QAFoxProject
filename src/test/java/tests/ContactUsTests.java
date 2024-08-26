package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContactUsTests extends BaseTest {
	
	@Override
	@BeforeClass
	public void setup_Login() {
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test (description = "Contact Us Proccess")
	@Description("Valid contact us proccess")
	public void tc01_contactUsTest() {
		homePage.clickContactusBtn();
		contactUsPage.fillContactUsForm("Roi Dvide", "roidv1988@gmail.com", "My automation works very well so far :)");
		String actual = contactUsPage.getSuccessMsg();
		AssertJUnit.assertEquals(actual, "Your request has been sent successfully! We will contact you as soon as possible");
	}

	@Severity(SeverityLevel.MINOR)
	@Test (description = "Invalid Contact Us Proccess")
	@Description("Invalid contact us proccess - empty name")
	public void tc02_contactUsTest() {
		homePage.clickContactusBtn();
		contactUsPage.fillContactUsForm("", "roidv1988@gmail.com", "My automation works very well so far :)");
		String actual = contactUsPage.getErrErrMsg();
		AssertJUnit.assertEquals(actual, "Name must be between 3 and 32 characters!");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test (description = "Invalid Contact Us Proccess")
	@Description("Invalid contact us proccess - empty enquiry")
	public void tc03_contactUsTest() {
		homePage.clickContactusBtn();
		contactUsPage.fillContactUsForm("Roi Dvide", "roidv1988@gmail.com", "Hello");
		String actual = contactUsPage.getErrErrMsg();
		AssertJUnit.assertEquals(actual, "Enquiry must be between 10 and 3000 characters!");
	}
}
