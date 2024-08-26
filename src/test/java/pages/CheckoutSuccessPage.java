package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccessPage extends MenuPage {
	
	@FindBy (css = "#content h1")
	private WebElement checkoutSuccessMsg;

	public CheckoutSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Checkout Success Validation
	public String getSuccessMsg() {
		String msg = getText(checkoutSuccessMsg);
		return msg;
	}

}
