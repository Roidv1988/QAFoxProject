package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CategoriesMenuTests extends BaseTest {

	@Override
	@BeforeClass
	public void setup_Login() {
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Enter To Category")
	@Description("Enter to category MP3 Players")
	public void tc01_CategoryOpeningTest() {
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		AssertJUnit.assertTrue(productsPage.isThisTheRightPage("MP3 Players"));
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Enter To Category")
	@Description("Enter to category Components")
	public void tc02_CategoryOpeningTest() {
		waiting(500);
		homePage.chooseCategoryFromDropdownMenu("Components");
		AssertJUnit.assertTrue(productsPage.isThisTheRightPage("Components"));
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Enter To Category")
	@Description("Enter to category Software")
	public void tc03_CategoryOpeningTest() {
		homePage.chooseCategoryFromMenu("Software");
		AssertJUnit.assertTrue(productsPage.isThisTheRightPage("Softwares"));
	}
}
