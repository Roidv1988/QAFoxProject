package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends MenuPage {

	@FindBy (css = "[data-original-title='Remove']")
	private WebElement removeFromWishListBtn;

	public WishListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickRemoveFromWishListBtn(String name) {
		List<WebElement> areaList = getDriver().findElements(By.cssSelector(".table.table-bordered.table-hover > tbody > tr"));
		for (WebElement area : areaList) {
			WebElement productTitle = area.findElement(By.cssSelector(".table.table-bordered.table-hover > tbody > tr > .text-left > a"));
			if (getText(productTitle).equalsIgnoreCase(name)) {
				click(area.findElement(By.cssSelector("[data-original-title='Remove']")));
				break;
			}
		}
	}

}
