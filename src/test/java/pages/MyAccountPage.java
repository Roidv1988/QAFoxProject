package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends MenuPage {

	@FindBy (css = "#content > h2:nth-child(1)")
	private WebElement myAccountTile;
	@FindBy (css = ".fa.fa-home")
	private WebElement homeBtn;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickHomeBtn() {
		click(homeBtn);
	}
	
	// Login Page Validation
	public boolean isThisMyAccountPage() {
		String s = getText(myAccountTile);
		if (s.equalsIgnoreCase("My Account")) {
			return true;
		}
		return false;
	}

}
