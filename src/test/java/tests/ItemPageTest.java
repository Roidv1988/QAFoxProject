package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ItemPageTest extends BaseTest {

	@Override
	@BeforeClass
	public void setup_Login() {
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Item Page Tests")
	@Description("Item page validation")
	public void tc01_itemPageTest() {
		homePage.chooseCategoryFromMenu("Tablets");
		productsPage.enterToItemPage("Samsung Galaxy Tab 10.1");
		AssertJUnit.assertTrue(itemPage.isThisItemPage("Samsung Galaxy Tab 10.1"));
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test (description = "Item Page Tests")
	@Description("Add to cart validation from item page")
	public void tc02_itemPageTest() {
		homePage.chooseCategoryFromMenu("Phones & PDAs");
		productsPage.enterToItemPage("iPhone");
		itemPage.clickAddToCartbtn();
		AssertJUnit.assertTrue(itemPage.getSuccessMsg("Success: You have added"));
	}
	

}
