package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends MenuPage {
	@FindBy (css="#description")
	private WebElement searchInDescriptionCheckbox;
	@FindBy (css=".btn.btn-primary")
	private WebElement searchBtn;
	@FindBy (css=".button-group > [type='button'] > .fa.fa-shopping-cart")
	private WebElement addToCartBtn;

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void searchInDescription() {
		click(searchInDescriptionCheckbox);
		click(searchBtn);
	}

	public void addToCart(String name) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector(".col-xs-12"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector(".caption>h4"));
			if (productTitle.getText().contains(name)) {
				click(area.findElement(By.cssSelector(".button-group > [type='button'] > .fa.fa-shopping-cart")));
				break;
			}
		}
	}
	
	public void chooseProduct(String name) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector(".col-xs-12"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector(".caption>h4"));
			if (productTitle.getText().contains(name)) {
				productTitle.click();
				break;
			}
		}
	}

}
