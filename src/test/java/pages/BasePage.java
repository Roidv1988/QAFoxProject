package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void fillText(WebElement el, String text) {
		waitForElementToBeClickable(el);
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		waitForElementToBeClickable(el);
		highlightElement(el, "yellow");
		el.click();
	}

	public String getText(WebElement el) {
		waitForElementToBeVisible(el);
		highlightElement(el, "orange");
		return el.getText();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void selectByValue(WebElement el, String text) {
		waitForElementToBeVisible(el);
		highlightElement(el, "yellow");
		Select s = new Select(el);
		s.selectByValue(text);
	}

	//mouse actions
	public void mouseHovering(WebElement el) {
		waitForElementToBeVisible(el);
		highlightElement(el, "pink");
		actions.moveToElement(el).build().perform();
	}
	
	public void waitForElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public void waitForElementToBeVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}	

	public void waiting(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	protected void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:" + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}


}
