package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RemoveProductsTest extends BaseTest {
	@Override
	@BeforeClass
	public void setup_Login() {
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Remove Product From Cart")
	@Description("Add 2 product and remove 1 from cart")
	public void tc01_removeProduct() {
		int numProductsBefore = productsPage.getNumOfItemsInCart();
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		productsPage.addToCart("iPod Shuffle");
		productsPage.addToCart("iPod Classic");
		homePage.clickShoppingCartBtn();
		shoppingCartPage.removeFromCart("iPod Shuffle");
		int numProductsAfter = productsPage.getNumOfItemsInCart();
		AssertJUnit.assertEquals(numProductsAfter, numProductsBefore+1);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Remove Product From Cart")
	@Description("Add another 2 products and remove 1 from menuPage cartBtn")
	public void tc02_removeProduct() {
		int numProductsBefore = productsPage.getNumOfItemsInCart();
		homePage.searchProduct("samsung");
		searchPage.addToCart("Samsung Galaxy");
		searchPage.addToCart("Samsung SyncMaster");
		homePage.clickShoppingCartBtn();
		waiting(1000);
		shoppingCartPage.removeFromCart("Samsung Galaxy");
		int numProductsAfter = productsPage.getNumOfItemsInCart();
		AssertJUnit.assertEquals(numProductsAfter, numProductsBefore+1);
		
	}
}
