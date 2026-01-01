package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;

//@Listeners(ChainTestListener.class)
public class BaseTest {
	WebDriver driver;
	DriverFactory df;

	protected Properties prop;

	protected LoginPage loginPage;
	protected HomePage homePage;
	protected SearchResultsPage searchResultsPage;
	protected ProductInfoPage productInfoPage;

	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName)
	{
		df = new DriverFactory();
		prop = df.initProp();
		if(browserName != null)
		{
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
	    loginPage = new LoginPage(driver);
		 
	}

	 /*  @AfterMethod    // This method will capture the screenshots for all the tests
	    public void attachScreenshot()
	    {
			// ChainTestListener.embed(File, mimeType);
			ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
	    } */
	   
	   @AfterMethod  // This method will capture the screenshots only for Failed tests
	    public void attachScreenshot(ITestResult result)
	    {
			if (!result.isSuccess()){
			ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
			}
	    }



	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
