package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class PriceTest extends BaseTest {
	@Override
	@BeforeClass
	public void setup_Login() {
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Price Test Validation")
	@Description("Add 1 product and check the price")
	public void tc01_priceTest() {
		double priceBefore = homePage.getCartPrice();
		homePage.chooseCategoryFromDropdownMenu("Desktops");
		productsPage.addToCart("HTC Touch HD");
		homePage.clickShoppingCartBtn();
		double priceAfter = shoppingCartPage.getTotalPrice();
		AssertJUnit.assertEquals(priceAfter, priceBefore+priceAfter);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Price Test Validation")
	@Description("Add another product and check the price")
	public void tc02_priceTest() {
		double priceBefore = shoppingCartPage.getTotalPrice();
		homePage.chooseCategoryFromMenu("Cameras");
		productsPage.addToCart("Nikon D300");
		homePage.clickShoppingCartBtn();
		waiting(500);
		double productPrice = shoppingCartPage.getProductPrice("Nikon D300");
		double priceAfter = shoppingCartPage.getTotalPrice();
		AssertJUnit.assertEquals(priceAfter, priceBefore+productPrice);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Price Test Validation")
	@Description("Remove 1 product and check the price")
	public void tc03_priceTest() {
		double priceBefore = shoppingCartPage.getTotalPrice();
		double productPrice = shoppingCartPage.getProductPrice("HTC Touch HD");
		homePage.clickCartBtn();
		shoppingCartPage.removeFromCartOnMenuPage("HTC Touch HD");
		waiting(500);
		double priceAfter = shoppingCartPage.getTotalPrice();
		AssertJUnit.assertEquals(priceAfter, priceBefore-productPrice);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Price Currency Test Validation")
	@Description("Change to euro and check the price")
	public void tc04_priceTest() {
		shoppingCartPage.clickCurrencyBtn();
		shoppingCartPage.chooseCurrency("Euro");
		AssertJUnit.assertTrue(shoppingCartPage.priceValidation("90.49€"));
	}

	@Severity(SeverityLevel.MINOR)
	@Test (description = "Sort Price Test Validation")
	@Description("Sort item by price from high to low")
	public void tc05_sortItemByPrice() {
		homePage.chooseCategoryFromMenu("Phones & PDAs");
		AssertJUnit.assertTrue(productsPage.findHighestPriceAndSort());
	}

	@Severity(SeverityLevel.MINOR)
	@Test (description = "Sort Price Test Validation")
	@Description("Sort item by price from low to high")
	public void tc06_sortItemByPrice() {
		AssertJUnit.assertTrue(productsPage.findLowestPriceAndSort());
	}
}
