package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends MenuPage {
	
	@FindBy (css = "#content > p:nth-child(2)")
	private WebElement logoutMsg;

	public LogoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Logout Validation
	public String getLogoutMsg() {
		String msg = getText(logoutMsg);
		return msg;
	}
}