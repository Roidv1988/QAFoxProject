package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ReviewTest extends BaseTest {
	@Override
	@BeforeClass
	public void setup_Login() {
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test (description = "Add A Review")
	@Description("Valid review test")
	public void tc01_reviewTest() {
		homePage.chooseCategoryFromMenu("Tablets");
		productsPage.enterToItemPage("Samsung Galaxy Tab 10.1");
		itemPage.ReviewWriting("Roi Dvide", "This is my very cool automation project");
		AssertJUnit.assertTrue(itemPage.getReviewSuccessMsg("Thank you for your review. It has been submitted to the webmaster for approval"));
	}
}
