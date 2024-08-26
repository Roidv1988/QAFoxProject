package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MenuPage {
	@FindBy (css = "#input-email")
	private WebElement emailField;
	@FindBy (css = "#input-password")
	private WebElement passwordField;
	@FindBy (css = "[value='Login']")
	private WebElement loginBtn;
	@FindBy (css = ".alert-dismissible")
	private WebElement errorMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void login (String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(loginBtn);
	}

	// Failed login Validation
	public String getErrorMsg() {
		String msg = getText(errorMsg);
		return msg;
	}
	
}
