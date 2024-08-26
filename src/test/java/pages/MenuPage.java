package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {
	@FindBy (css = "#top-links > ul > li.dropdown > a > span.hidden-xs.hidden-sm.hidden-md")
	private WebElement myAccountBtn;
	@FindBy (css = ".dropdown-menu.dropdown-menu-right > li:nth-child(2) > a")
	private WebElement loginBtn;
	@FindBy (css = ".dropdown.open > ul > li:nth-child(1) > a")
	private WebElement registerBtn;
	@FindBy (css = ".form-control.input-lg")
	private WebElement searchField;
	@FindBy (css = ".btn.btn-default.btn-lg")
	private WebElement searchBtn;
	@FindBy (css = "[title='Shopping Cart']")
	private WebElement shoppingCartBtn;
	@FindBy (css = "#cart-total")
	private WebElement cartBtn;
	@FindBy (css = "#wishlist-total")
	private WebElement wishListBtn;
	@FindBy (css = ".dropdown-menu-right > li:nth-child(5) > a")
	private WebElement logoutBtn;
	@FindBy (css = "#form-currency")
	private WebElement currencyBtn;
	@FindBy (css = ".fa.fa-phone")
	private WebElement contactUsBtn;

	public MenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openMyAccount() {
		click(myAccountBtn);
	}

	public void clickLoginBtn() {
		click(loginBtn);
	}

	public void clickRegisterBtn() {
		click(registerBtn);
	}

	public void searchProduct(String searchValue) {
		fillText(searchField, searchValue);
		waiting(1000);
		click(searchBtn);
	}

	public void clickShoppingCartBtn() {
		click(shoppingCartBtn);
	}

	public void clickCartBtn() {
		click(cartBtn);
	}

	public void clickWishListBtn() {
		click(wishListBtn);
	}

	public void clickLogoutBtn() {
		click(logoutBtn);
	}

	public void clickCurrencyBtn() {
		click(currencyBtn);
	}

	public void clickContactusBtn() {
		click(contactUsBtn);
	}

	public void chooseCategoryFromDropdownMenu (String name) {
		List<WebElement> categoriesArea = getDriver().findElements(By.cssSelector(".nav.navbar-nav > li"));
		for (WebElement btnArea : categoriesArea) {
			WebElement categoryName = btnArea.findElement(By.cssSelector(".nav.navbar-nav > li > a"));
			if (getText(categoryName).equalsIgnoreCase(name)) {
				mouseHovering(categoryName);
				WebElement allBtn = btnArea.findElement(By.cssSelector(".see-all"));
				click(allBtn);
				break;
			}
		}
	}

	public void chooseCategoryFromMenu (String name) {
		List<WebElement> categoriesArea = getDriver().findElements(By.cssSelector(".nav.navbar-nav > li"));
		for (WebElement btnArea : categoriesArea) {
			WebElement categoryName = btnArea.findElement(By.cssSelector(".nav.navbar-nav > li > a"));
			if (getText(categoryName).equalsIgnoreCase(name)) {
				click(btnArea);
				break;
			}
		}
	}

	public void removeFromCartOnMenuPage(String productName) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector(".table.table-striped > tbody > tr"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector(".table.table-striped > tbody > tr > .text-left > a"));
			if (productTitle.getText().contains(productName)) {
				click(area.findElement(By.cssSelector("[title='Remove']")));
				break;
			}
		}
	}

	public void chooseCurrency(String currency) {
		List<WebElement> currencyList = getDriver().findElements(By.cssSelector("#form-currency > div > ul"));
		for (WebElement currencyValue : currencyList) {
			WebElement currencyTitle = currencyValue.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block"));
			if (currencyTitle.getText().contains(currency)) {
				click(currencyValue.findElement(By.cssSelector("[type='button']")));
				break;
			}
		}
	}

	//Numbers of products in cart Validation
	public int getNumOfItemsInCart() {
		String cartNumText = getText(cartBtn);
		int cartNum = Integer.parseInt(cartNumText.split(" ")[0].trim());
		return cartNum;
	}


	// Numbers of products in wish list Validation
	public int getWishListProductNum_02() {
		String s = getText(wishListBtn);
		// הסרת כל מה שבא לפני הסוגריים הפותחים
		int startIndex = s.indexOf('(');
		// הסרת הסוגריים והמרה למספר
		int actualCount = Integer.parseInt(s.substring(startIndex + 1, s.length() - 1));
		return actualCount;
	}
	
	public double getCartPrice() {
		String text = getText(cartBtn);
		// הסרת כל מה שאינו ספרה או נקודה (הנחה שרק המחיר מכיל ספרות ונקודה)
		String priceString = text.replaceAll("[^0-9.]", "");
		double price = Double.parseDouble(priceString);
		return price;	
	}
	
}
