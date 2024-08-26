package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends MenuPage {

	@FindBy (css = ".col-sm-4 > h1")
	private WebElement productTitle;
	@FindBy (css = ".col-sm-4 #button-cart")
	private WebElement addToCartBtn;
	@FindBy (css = ".alert.alert-success.alert-dismissible")
	private WebElement addToCartSuccessMsg;
	@FindBy (css = ".btn.btn-default .fa.fa-heart")
	private WebElement wishListBtn;
	@FindBy (css = ".rating > p > a:nth-child(7)")
	private WebElement reviewWritingBtn;
	@FindBy (css = "#input-name")
	private WebElement reviewYourNameField;
	@FindBy (css = "#input-review")
	private WebElement reviewYourReviewField;
	@FindBy (css = "[type='radio']:nth-child(6)")
	private WebElement reviewRatingBtnGood5;
	@FindBy (css = "#button-review")
	private WebElement reviewContinueBtn;
	@FindBy (css = ".alert-success.alert-dismissible")
	private WebElement reviewSuccessMsg;

	public ItemPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickAddToCartbtn() {
		click(addToCartBtn);
	}
	
	public void clickWishListBtn() {
		click(wishListBtn);
	}
	
	public void ReviewWriting(String yourName, String yourReview) {
		click(reviewWritingBtn);
		fillText(reviewYourNameField, yourName);
		fillText(reviewYourReviewField, yourReview);
		click(reviewRatingBtnGood5);
		click(reviewContinueBtn);
	}
	
	//Products page validation
	public boolean isThisItemPage(String expectedTitle) {
		String s = getText(productTitle);
		if (s.equalsIgnoreCase(expectedTitle)) {
			return true;
		} 
		return false;
	}

	// Add to cart success msg validation
	public boolean getSuccessMsg(String expectedMsg) {
		String s = getText(addToCartSuccessMsg);
		if (s.contains(expectedMsg)) {
			return true;
		}
		return false;
	}
	
	// Reveiw writing success msg validation
	public boolean getReviewSuccessMsg(String expectedMsg) {
		String s = getText(reviewSuccessMsg);
		if (s.contains(expectedMsg)) {
			return true;
		}
		return false;
	}
	
}
