package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.util.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private static final Logger log = LogManager.getLogger(HomePage.class); 

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	


	// By Locators
		private By logoutLink = By.linkText("Logout");
		private By headers = By.cssSelector("div#content>h2");
		private By search = By.name("search");
		private By searchIcon = By.cssSelector("div#search button");

		// public page actions

		public String getHomePageTitle() {
			String title = 	eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE, AppConstants.DEFAULT_TIME_OUT);
		//	ChainTestListener.log("The Home Page Title is :  " + title);
			System.out.println("The Home Page Title is : " + title);
		log.info("The Home Page Title is : " + title);
			return title;
		}

		public String getHomePageURL() {
			String url =	eleUtil.waitForURLContains(AppConstants.HOME_PAGE_URL_FRACTION, AppConstants.DEFAULT_TIME_OUT);
		System.out.println("The Home Page URL is: " + url);
			log.info("The Home Page URL is: " + url);
			return url;
		}

		public boolean isLogoutLinkExist() {
			return eleUtil.doIsElementDisplayed(logoutLink);
			}

		public void logout() {
			if(isLogoutLinkExist())
			{
				eleUtil.doClick(logoutLink);
			}
			//Pending
		}

		public List<String> getHeadersList()
		{
			List<WebElement> headersList = eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_TIME_OUT);
			List<String> headerListValues = new ArrayList<>();
			for(WebElement e: headersList)
			{
				String values = e.getText();
				headerListValues.add(values);
			}
			return headerListValues;

		}
			public SearchResultsPage doSearch(String searchKey)
			{
			System.out.println("Enter the SearchKey: "+ searchKey);
				log.info("Enter the SearchKey: "+ searchKey);
				WebElement searchEle = eleUtil.waitForElementPresence(search, AppConstants.DEFAULT_TIME_OUT);
				searchEle.clear();
				searchEle.sendKeys(searchKey);
				eleUtil.doClick(searchIcon);
				return new SearchResultsPage(driver);


			}



		}



















