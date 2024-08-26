package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends MenuPage {

	@FindBy (css = "#content > h2")
	private WebElement categoryTitle;
	@FindBy (css = "#input-sort")
	private WebElement selectSort;

	public ProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void addToCart(String name) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector(".col-xs-12"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector(".caption>h4"));
			if (productTitle.getText().equalsIgnoreCase(name)) {
				click(area.findElement(By.cssSelector(".button-group > [type='button'] > .fa.fa-shopping-cart")));
				break;
			}
		}
	}

	public void enterToItemPage(String name) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector(".col-xs-12"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector(".caption>h4>a"));
			if (productTitle.getText().equalsIgnoreCase(name)) {
				click(productTitle);
				break;
			}
		}
	}

	public void addToWishList(String name) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector(".col-xs-12"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector(".caption>h4"));
			if (productTitle.getText().equalsIgnoreCase(name)) {
				click(area.findElement(By.cssSelector("[data-original-title='Add to Wish List']")));
				break;
			}
		}
	}
	

	public void sortItemby(String sort) {
		Select SortSelect = new Select(selectSort);
		SortSelect.selectByVisibleText(sort);
	}

	//Category Page Validation
	public boolean isThisTheRightPage(String name) {
		String s = getText(categoryTitle);
		if (s.equalsIgnoreCase(name)) {
			return true;
		} 
		return false;
	}

	
	
	//Sort price from high to low validation
	public boolean findHighestPriceAndSort() {
		// מציאת כל המחירים בדף
		List<WebElement> productPrices = getDriver().findElements(By.cssSelector(".caption .price .price-tax"));

		// מציאת המחיר המקסימלי
		int maxPrice = Integer.MIN_VALUE; // מתחילים מהערך המינימלי של int
		for (WebElement priceElement : productPrices) {
			String priceText = priceElement.getText();
			int price = convertPriceToInt(priceText);
			maxPrice = Math.max(maxPrice, price);
		}

		// סידור לפי מחיר יורד
		waiting(500); 
		Select sortSelect = new Select(selectSort);
		sortSelect.selectByVisibleText("Price (High > Low)");
		waiting(500);

		// השוואת המחיר הראשון למחיר המקסימלי
		WebElement firstProductPrice = getDriver().findElements(By.cssSelector(".caption .price .price-tax")).get(0);
		String firstPriceText = firstProductPrice.getText();
		int actualPrice = convertPriceToInt(firstPriceText);

		if (actualPrice == maxPrice) {
			return true;
			//System.out.println("המחיר הראשון לאחר הסידור תואם למחיר המקסימלי");
		} else {
			return false;
			//System.out.println("ישנה אי התאמה בין המחירים");
		}
	}
	
	
	
	//Sort price from low to high validation
	public boolean findLowestPriceAndSort() {
		// מציאת כל המחירים בדף
		List<WebElement> productPrices = getDriver().findElements(By.cssSelector(".caption .price .price-tax"));

		// מציאת המחיר המינימלי
		int minPrice = Integer.MAX_VALUE; // מתחילים מהערך המקסימלי של int
		for (WebElement priceElement : productPrices) {
			String priceText = priceElement.getText();
			int price = convertPriceToInt(priceText);
			minPrice = Math.min(minPrice, price);
		}

		// סידור לפי מחיר יורד
		waiting(500); 
		Select selectCountry = new Select(selectSort);
		selectCountry.selectByVisibleText("Price (Low > High)");
		waiting(500);

		// השוואת המחיר הראשון למחיר המקסימלי
		WebElement firstProductPrice = getDriver().findElements(By.cssSelector(".caption .price .price-tax")).get(0);
		String firstPriceText = firstProductPrice.getText();
		int actualPrice = convertPriceToInt(firstPriceText);

		if (actualPrice == minPrice) {
			return true;
			//System.out.println("המחיר הראשון לאחר הסידור תואם למחיר המקסימלי");
		} else {
			return false;
			//System.out.println("ישנה אי התאמה בין המחירים");
		}
	}


	private int convertPriceToInt(String priceText) {
		try {
			String cleanedPriceText = priceText.replaceAll("[^\\d]", "");
			return Integer.parseInt(cleanedPriceText);
		} catch (NumberFormatException e) {
			System.out.println("שגיאה בהמרת המחיר למספר שלם: " + priceText);
			// ניתן להחזיר ערך ברירת מחדל או לטפל בשגיאה באופן אחר
			return 0; // למשל, נחזיר 0 במקרה של שגיאה
		}
	}


}
