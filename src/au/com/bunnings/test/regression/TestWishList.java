package au.com.bunnings.test.regression;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import au.com.bunnings.lib.ui.HomePage;
import au.com.bunnings.lib.ui.ProductPage;
import au.com.bunnings.lib.ui.SearchResultPage;
import au.com.bunnings.lib.ui.WishListPage;
import au.com.bunnings.lib.utils.CreateDriver;
import au.com.bunnings.lib.utils.DataHandlers;

public class TestWishList {
	// Create WebDriver Reference
	WebDriver driver;

	// Define Page Object Classes references
	HomePage homePage;
	SearchResultPage searchPage;
	ProductPage productPage;
	WishListPage wishListPage;

	@BeforeMethod
	public void preCondition() {
		// Initialize browser instance
		driver = CreateDriver.getBrowserInstance();

		// Initialize Referenced Page Object Classes
		homePage = new HomePage(driver);
		searchPage = new SearchResultPage(driver);
		productPage = new ProductPage(driver);
		wishListPage = new WishListPage(driver);
	}

	@AfterMethod
	public void postCondition() {
		//Close the browser
		driver.close();
	}

	@Test
	public void testWishListTC01() {

		//Go to HomePage
		homePage.waitForHomePageToLoad();
		
		//Close HomePage Pop-up
		homePage.getPopupCloseButton().click();

		//Read Search Term from Test Data Excel File
		String searchTerm = DataHandlers.getDataFromExcel("test-data", "TC001", 1, 1);

		//Enter Search Term in Search Textbox
		homePage.getSearchboxTextbox().sendKeys(searchTerm);

		//Click on Search Button
		homePage.getSearchButton().click();

		//Wait for Search Result Page to load
		searchPage.waitForSearchResultPageToLoad();

		//Scroll to Products listing section on Search Result Page
		JavascriptExecutor js_driver = (JavascriptExecutor) driver;
		js_driver.executeScript("window.scroll(0,500)");

		//Click on First Product from the Search Result
		searchPage.getsearchProductLink().click();

		//Wait for Product Detail Page to load
		productPage.waitForWishListButtonProductPageToLoad();

		//Get inNumber on Product Detail Page
		String inNumberProductPage = productPage.getINNumberText().getText();

		//Scroll on Product Detail Page to view WishList Button
		js_driver.executeScript("window.scroll(0,750)");

		//Click on Save to WishList Button
		productPage.getWishListButton().click();

		//Wait for WishList Page link to be enabled
		productPage.waitForWishListPageLinkProductPageToLoad();

		//Click on WishList Page link to navigate
		productPage.getWishListPageLink().click();

		//Wait for WishList Page to load
		wishListPage.waitForWishListPageToLoad();

		//Scroll to Products listing section on WishList Page
		js_driver.executeScript("window.scroll(0,750)");

		//Get inNumber on WishList Page
		String inNumberWishListPage = wishListPage.getINNumberText().getText();

		//Compare the inNumbers of Product Details Page & WishList Page
		Assert.assertEquals(inNumberWishListPage, inNumberProductPage, "Product is not matching");

	}

}
