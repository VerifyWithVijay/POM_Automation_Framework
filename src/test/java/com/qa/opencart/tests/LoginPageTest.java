package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.constants.AppError;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: design login page for open cart")
@Story("US 101: design the various features of open cart login page")
@Feature("Feature 50: Login Page Feature")
@Owner("Vijay Ravindra Kamisetty")

public class LoginPageTest extends BaseTest {

	@Description("checking login page title....")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void LoginPageTitleTest()
	{
		String actTitle = loginPage.getLoginPageTitle();
		ChainTestListener.log("The Login Page Title is : " + actTitle);
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND_ERROR);
	}

	@Description("checking forgot password link....")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void LoginPageURLTest()
	{
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION), AppError.URL_NOT_FOUND_ERROR);
	}


	@Description("checking login page title....")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void forgotPwdLinkExistTest()
	{
		Assert.assertTrue(loginPage.forgotPwdLinkExists(), AppError.ELEMENT_NOT_FOUND_ERROR);

	}

	@Description("Verifying  user is able to login with correct credentials....")
	@Severity(SeverityLevel.BLOCKER)
	@Test (priority = Integer.MAX_VALUE)
	public void loginTest()
	{
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getHomePageTitle(),AppConstants.HOME_PAGE_TITLE ,AppError.TITLE_NOT_FOUND_ERROR);

	}


}
