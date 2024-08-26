package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import pages.CheckoutPage;
import pages.CheckoutSuccessPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MyAccountPage;
import pages.ProductsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.WishListPage;
import utils.Utils;

public class BaseTest {
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	SearchPage searchPage;
	ShoppingCartPage shoppingCartPage;
	ItemPage itemPage;
	ProductsPage productsPage;
	WishListPage wishListPage;
	LogoutPage logoutPage;
	CheckoutPage checkoutPage;
	CheckoutSuccessPage checkoutSuccessPage;
	ContactUsPage contactUsPage;

	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utils.readValue("url"));
		waiting(2000);
	}
	
	@BeforeClass
	public void setupAPages() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccountPage = new MyAccountPage(driver);
		searchPage = new SearchPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
		itemPage = new ItemPage(driver);
		productsPage = new ProductsPage(driver);
		wishListPage = new WishListPage(driver);
		logoutPage = new LogoutPage(driver);
		checkoutPage = new CheckoutPage(driver);
		checkoutSuccessPage = new CheckoutSuccessPage(driver);
		contactUsPage = new ContactUsPage(driver);
	}
	
	@BeforeClass
	public void setup_Login() {
		homePage.openMyAccount();
		homePage.clickLoginBtn();
		loginPage.login("roidv1988@gmail.com", "Aa123456");
		myAccountPage.clickHomeBtn();
	}
	

	@AfterMethod
	@AfterClass
	public void tearDown() {
		// driver.quit();
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
	* This method will run after each test,
	* it will take screen shot only for tests that failed
	*/
	@AfterMethod
	public void failedTest(ITestResult result) {
	  //check if the test failed
		if (result.getStatus() == ITestResult.FAILURE ){
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//result.getname() method will give you current test case name. 
			//./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
		}
	}


}
