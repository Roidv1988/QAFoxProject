package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends MenuPage {

	@FindBy (css = ".pull-right > a")
	private WebElement checkoutBtn;
	@FindBy (css = ".col-sm-offset-8 > .table-bordered > tbody > tr:nth-child(4) > td:nth-child(2)")
	private WebElement totalPrice;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickCheckoutBtn() {
		click(checkoutBtn);
	}

	public void removeFromCart(String name) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector("form > div > table > tbody > tr"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector("div > table > tbody > tr> td:nth-child(2) > a"));
			if (productTitle.getText().contains(name)) {
				click(area.findElement(By.cssSelector(".input-group-btn > .btn.btn-danger")));
				break;
			}
		}
	}

	//Price Validation
	public boolean priceValidation(String price) {
		String s = getText(totalPrice);
		if (s.equalsIgnoreCase(price)) {
			return true;
		} 
		return false;
	}
	
	//validation
	public double getTotalPrice() {
		String text = getText(totalPrice);
		// מסיר כל תו שאינו ספרה או נקודה
		String numberString = text.replaceAll("[^0-9.]", ""); 
		double actualValue = Double.parseDouble(numberString);
		return actualValue;
	}
	
	//validation
	public double getProductPrice(String name) {
		List<WebElement> productRows = getDriver().findElements(By.cssSelector("#content > form > div > table > tbody > tr"));
		
		for (WebElement productRow : productRows) {
			WebElement productTitle = productRow.findElement(By.cssSelector("#content > form > div > table > tbody > tr > .text-left > a"));
			if (productTitle.getText().equalsIgnoreCase(name)) {
				WebElement priceElement = productRow.findElement(By.cssSelector("#content > form > div > table > tbody > tr > .text-right"));
				waiting(1000);
				String priceText = priceElement.getText();
				String numberString = priceText.replaceAll("[^0-9.]", "");
	            try {
	                return Double.parseDouble(numberString);
	            } catch (NumberFormatException e) {
	                // טיפול בשגיאת המרה
	                System.err.println("Failed to parse price: " + priceText);
	                // החזר ערך ברירת מחדל או השלך חריגה
	            }
	        }
	    }
	    // המוצר לא נמצא
	    throw new NoSuchElementException("Product not found: " + name);
	}
}
