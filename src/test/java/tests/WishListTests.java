package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class WishListTests extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Test (description = "Add Product To Wish List")
	@Description("Add to wish list from products page")
	public void tc01_addToWishList() {
		int wishListNumBefore = homePage.getWishListProductNum_02();
		homePage.chooseCategoryFromDropdownMenu("MP3 Players");
		productsPage.addToWishList("iPod Classic");
		waiting(500);
		int wishListNumAfter = homePage.getWishListProductNum_02();
		AssertJUnit.assertEquals(wishListNumAfter, wishListNumBefore+1);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test (description = "Add Product To Wish List")
	@Description("Add to wish list from products page")
	public void tc02_addToWishList() {
		int wishListNumBefore = homePage.getWishListProductNum_02();
		homePage.chooseCategoryFromMenu("Tablets");
		productsPage.addToWishList("Samsung Galaxy Tab 10.1");
		waiting(500);
		int wishListNumAfter = homePage.getWishListProductNum_02();
		AssertJUnit.assertEquals(wishListNumAfter, wishListNumBefore+1);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test (description = "Remove Product To Wish List")
	@Description("Remove 1 product from wish list page")
	public void tc03_removeFromWishList() {
		int wishListNumBefore = homePage.getWishListProductNum_02();
		homePage.clickWishListBtn();
		wishListPage.clickRemoveFromWishListBtn("Samsung Galaxy Tab 10.1");
		waiting(500);
		int wishListNumAfter = homePage.getWishListProductNum_02();
		AssertJUnit.assertEquals(wishListNumAfter, wishListNumBefore-1);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test (description = "Add Product To Wish List")
	@Description("Add to wish list validation from item page")
	public void tc04_itemPageTest() {
		int wishListNumBefore = homePage.getWishListProductNum_02();
		homePage.chooseCategoryFromDropdownMenu("Laptops & Notebooks");
		productsPage.enterToItemPage("MacBook Pro");
		itemPage.clickWishListBtn();
		waiting(500);
		int wishListNumAfter = homePage.getWishListProductNum_02();
		AssertJUnit.assertEquals(wishListNumAfter, wishListNumBefore+1);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test (description = "Clear Wish List")
	@Description("Clear the wish list for regression tests")
	public void tc05_itemPageTest() {	
		homePage.clickWishListBtn();
		int wishListNumBefore_2 = homePage.getWishListProductNum_02();
		wishListPage.clickRemoveFromWishListBtn("MacBook Pro");
		wishListPage.clickRemoveFromWishListBtn("iPod Classic");
		waiting(500);
		int wishListNumAfter_2 = homePage.getWishListProductNum_02();
		AssertJUnit.assertEquals(wishListNumAfter_2, wishListNumBefore_2-2);
	}

}
