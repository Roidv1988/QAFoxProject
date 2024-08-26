package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends MenuPage {

	@FindBy (css = "#input-name")
	private WebElement nameField;
	@FindBy (css = "#input-email")
	private WebElement emailField;
	@FindBy (css = "#input-enquiry")
	private WebElement enquiryField;
	@FindBy (css = ".btn.btn-primary")
	private WebElement submitBtn;
	@FindBy (css = "#content")
	private WebElement successMsg;
	@FindBy (css = ".text-danger")
	private WebElement errMsg;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void fillContactUsForm (String name, String email, String enuiry) {
		fillText(nameField, name);
		fillText(emailField, email);
		fillText(enquiryField, enuiry);
		click(submitBtn);
	}

	//Success Msg Validation
	public String getSuccessMsg() {
		String msg = getText(successMsg);
		return msg;
	}
	
	//Error Msg Validation
	public String getErrErrMsg() {
		String msg = getText(errMsg);
		return msg;
	}
}
