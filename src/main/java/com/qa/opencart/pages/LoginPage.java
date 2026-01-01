package com.qa.opencart.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;

import com.qa.opencart.util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private static final Logger log = LogManager.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}


	// private locators
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By submit = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.xpath("(//a[text()='Forgotten Password'])[1]");

	// Public page actions - methods (features)

	@Step("Get the Login Page Title")
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_TIME_OUT);

	//	System.out.println("The Login Page Title is : " + title);
		log.info("The Login Page Title is : " + title);
		return title;
	}

	@Step("Get the Login Page URL")
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.DEFAULT_TIME_OUT);
		//System.out.println("The Login Page URL is : " + url);
	log.info("The Login Page URL is : " + url);
		return url;
	}

	@Step("Checking whether Forgot Pwd Link is displayed")
	public boolean forgotPwdLinkExists() {
		return eleUtil.doIsElementDisplayed(forgotPwdLink);
	}
	@Step("Checking whether user is able to login")
	public HomePage doLogin(String userName, String pwd) {
		//System.out.println("Application Credentials are: " + userName + " " + pwd);
		log.info("Application Credentials are: " + userName + " " + pwd);
		eleUtil.waitForElementVisible(email, AppConstants.DEFAULT_TIME_OUT).sendKeys(userName);
		eleUtil.doActionsSendKeys(password, pwd);
		eleUtil.doClick(submit);
		// driver.findElement(email).sendKeys(emailID);
		// driver.findElement(password).sendKeys(pwd);
		// driver.findElement(submit).click();
		// return driver.getTitle(); // This works fine.
		// String HomePageTitle = driver.getTitle();
		// return HomePageTitle; (NoSuchElementException error is coming due to
		// synchronization issue.
		// When used below wait, then this works fine.

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.titleContains(HomePageTitle));
		return new HomePage(driver);

	}

}
