package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends MenuPage {

	@FindBy (css = "[value='guest']")
	private WebElement guestCheckoutCheckbox;
	@FindBy (css = "[value='Continue']")
	private WebElement step1ContinueBtn;
	@FindBy (css = "#input-payment-firstname")
	private WebElement firstNameField;
	@FindBy (css = "#input-payment-lastname")
	private WebElement lastNameField;
	@FindBy (css = "#input-payment-email")
	private WebElement emailField;
	@FindBy (css = "#input-payment-telephone")
	private WebElement telephoneField;
	@FindBy (css = "#input-payment-address-1")
	private WebElement address1Field;
	@FindBy (css = "#input-payment-city")
	private WebElement cityField;
	@FindBy (css = "#input-payment-postcode")
	private WebElement postCodeField;
	@FindBy (css = "#input-payment-country")
	private WebElement countryField;
	@FindBy (css = "#input-payment-zone")
	private WebElement stateField;
	@FindBy (css = "#button-guest:nth-child(1)")
	private WebElement step2ContinueBtn;
	@FindBy (css = ".panel-body > p > .form-control")
	private WebElement step4AddCommentField;
	@FindBy (css = "#button-shipping-method:nth-child(1)")
	private WebElement step4ContinueBtn;
	@FindBy (css = ".panel-body > p .form-control")
	private WebElement step5AddCommentField;
	@FindBy (css = "[name='agree']")
	private WebElement termsAndConditionCheckbox;
	@FindBy (css = ".pull-right #button-payment-method")
	private WebElement step5ContinueBtn;
	@FindBy (css = ".pull-right #button-confirm")
	private WebElement confirmOrderBtn;
	@FindBy (css = ".alert-danger.alert-dismissible")
	private WebElement termsErrMsg;
	@FindBy (css = ".form-group.required.has-error > div")
	private WebElement billingErrMsg;


	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	public void checkoutProcessStep1() {
		click(guestCheckoutCheckbox);
		click(step1ContinueBtn);
	}
	
	public void checkoutProcessStep2(String firstname, String lastname, String email, String telephone, String address1, String city, String postcode, String counrty, String regionState) {
		fillText(firstNameField, firstname);
		fillText(lastNameField, lastname);
		fillText(emailField, email);
		fillText(telephoneField, telephone);
		fillText(address1Field, address1);
		fillText(cityField, city);
		fillText(postCodeField, postcode);
		waiting(500);
		Select selectCountry = new Select(countryField);
		selectCountry.selectByVisibleText(counrty);
		waiting(500);
		Select selectRegion = new Select(stateField);
		selectRegion.selectByVisibleText(regionState);
		click(step2ContinueBtn);
	}
		
	public void checkoutProcessStep4(String step4comments) {
		fillText(step4AddCommentField, step4comments);
		click(step4ContinueBtn);
	}

	public void clickTermsAndConditionCheckbox() {
		click(termsAndConditionCheckbox);
	}

	public void clickStep5ContinueBtn() {
		click(step5ContinueBtn);
	}

	public void clickConfirmOrderBtn() {
		click(confirmOrderBtn);
	}

	//Terms & Conditions Error Msg Validation
	public String getTermsErrMsg() {
		String msg = getText(termsErrMsg);
		return msg;
	}

	//Billing Details Error Msg Validation
		public String getBillingErrMsg() {
			String msg = getText(billingErrMsg);
			return msg;
		}
}

