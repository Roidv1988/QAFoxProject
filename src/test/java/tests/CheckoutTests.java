package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CheckoutTests extends BaseTest {

	@Override
	@BeforeClass
	public void setup_Login() {
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Valid Checkout Test")
	@Description("Valid checkout test whithout clicking Term & Conditions on step 5")
	public void tc_01_checkoutTest() {
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		productsPage.addToCart("iPod Shuffle");
		homePage.clickShoppingCartBtn();
		shoppingCartPage.clickCheckoutBtn();
		checkoutPage.checkoutProcessStep1();
		checkoutPage.checkoutProcessStep2("Roi", "Dvide", "roidv1988@gmail.com", "052-1234567", "Dalya Rabikovich 5", "Rosh Haayin", "4840098", "Israel", "Sharon");
		checkoutPage.checkoutProcessStep4("I love writing automations, This is very cool");		
		checkoutPage.clickStep5ContinueBtn();
		String actual = checkoutPage.getTermsErrMsg();
		AssertJUnit.assertEquals(actual, "Warning: You must agree to the Terms & Conditions!");
	}


	@Severity(SeverityLevel.NORMAL)
	@Test (description = "Valid Checkout Test")
	@Description("Continue checkout test after clicking Term & Conditions on step 5")
	public void tc_02_checkoutTest() {
		checkoutPage.clickTermsAndConditionCheckbox();
		checkoutPage.clickStep5ContinueBtn();
		checkoutPage.clickConfirmOrderBtn();
		String actual = checkoutSuccessPage.getSuccessMsg();
		AssertJUnit.assertEquals(actual, "Your order has been placed!");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test (description = "Invalid Checkout Test")
	@Description("Checkout test with invalid first name")
	public void tc_03_checkoutTest() {
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		productsPage.addToCart("iPod Shuffle");
		homePage.clickShoppingCartBtn();
		shoppingCartPage.clickCheckoutBtn();
		checkoutPage.checkoutProcessStep1();
		checkoutPage.checkoutProcessStep2("", "Dvide", "roidv1988@gmail.com", "052-1234567", "Dalya Rabikovich 5", "Rosh Haayin", "4840098", "Israel", "Sharon");
		String actual = checkoutPage.getBillingErrMsg();
		AssertJUnit.assertEquals(actual, "First Name must be between 1 and 32 characters!");
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test (description = "Invalid Checkout Test")
	@Description("Checkout test with invalid last name")
	public void tc_04_checkoutTest() {
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		productsPage.addToCart("iPod Shuffle");
		homePage.clickShoppingCartBtn();
		shoppingCartPage.clickCheckoutBtn();
		checkoutPage.checkoutProcessStep1();
		checkoutPage.checkoutProcessStep2("Roi", "Dvideeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", "roidv1988@gmail.com", "052-1234567", "Dalya Rabikovich 5", "Rosh Haayin", "4840098", "Israel", "Sharon");
		String actual = checkoutPage.getBillingErrMsg();
		AssertJUnit.assertEquals(actual, "Last Name must be between 1 and 32 characters!");
	}

	@Severity(SeverityLevel.MINOR)
	@Test (description = "Invalid Checkout Test")
	@Description("Checkout test with invalid email")
	public void tc_05_checkoutTest() {
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		productsPage.addToCart("iPod Shuffle");
		homePage.clickShoppingCartBtn();
		shoppingCartPage.clickCheckoutBtn();
		checkoutPage.checkoutProcessStep1();
		checkoutPage.checkoutProcessStep2("Roi", "Dvide", "roidv1988#gmail.com", "052-1234567", "Dalya Rabikovich 5", "Rosh Haayin", "4840098", "Israel", "Sharon");
		String actual = checkoutPage.getBillingErrMsg();
		AssertJUnit.assertEquals(actual, "E-Mail address does not appear to be valid!");
	}
}
