package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AddToCartTests extends BaseTest {
	@Override
	@BeforeClass
	public void setup_Login() {
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Add Product To Cart")
	@Description("Add product to cart by search line")
	public void tc01_addProductBySearch() {
		int numProductsBefore = productsPage.getNumOfItemsInCart();
		homePage.searchProduct("camera");
		searchPage.searchInDescription();
		searchPage.addToCart("Nikon");
		int numProductsAfter = productsPage.getNumOfItemsInCart();
		AssertJUnit.assertEquals(numProductsAfter, numProductsBefore+1);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Add Product To Cart")
	@Description("Add another 2 product")
	public void tc02_addProductBySearch() {
		int numProductsBefore = productsPage.getNumOfItemsInCart();
		homePage.searchProduct("sony");
		searchPage.searchInDescription();
		searchPage.addToCart("Sony");
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		productsPage.addToCart("iPod Shuffle");
		int numProductsAfter = productsPage.getNumOfItemsInCart();
		AssertJUnit.assertEquals(numProductsAfter, numProductsBefore+2);
	}

}
