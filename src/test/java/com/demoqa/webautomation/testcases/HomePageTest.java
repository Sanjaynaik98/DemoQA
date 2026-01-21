package com.demoqa.webautomation.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.demoqa.webautomation.pagebase.TestBase;
import com.demoqa.webautomation.pages.AlertsPage;
import com.demoqa.webautomation.pages.BookStorePage;
import com.demoqa.webautomation.pages.ElementsPage;
import com.demoqa.webautomation.pages.FormPage;
import com.demoqa.webautomation.pages.HomePage;
import com.demoqa.webautomation.pages.InteractionsPage;
import com.demoqa.webautomation.pages.WidgetsPage;
import com.demoqa.webautomation.utilities.Constants;

public class HomePageTest extends TestBase {

	private HomePage home;

	@BeforeMethod
	public void setUpHomePage() {
		logger.info("Initializing Home Page before test execution");
		home = new HomePage(getDriver());
	}

	@Test
	public void verifyHomePageLoadsSuccessfully() {

		logger.info("TC_001 - Test Started: Verify Home Page Loads Successfully");

		Assert.assertTrue(home.isLogoDisplayed(), "TOOLSQA logo is not displayed on Home Page");

		Assert.assertEquals(home.getTitle(), Constants.HOME_TITLE, "Home Page title does not match expected value");

		logger.info("TC_001 - Test Completed Successfully");
	}

	@Test
	public void verifyToolsQABannerIsDisplayed() {

		logger.info("TC_002 - Test Started: Verify TOOLSQA Banner Is Displayed");

		Assert.assertTrue(home.isBannerImageDisplayed(), "TOOLSQA banner image is not displayed on Home Page");

		logger.info("TC_002 - Test Completed Successfully");
	}

	@Test
	public void verifyElementsTileNavigation() {

		logger.info("TC_003 - Test Started: Verify Elements Tile Navigation");

		ElementsPage elementsPage = home.clickOnElements();

		Assert.assertEquals(elementsPage.getElementTitle(), Constants.ELEMENT_TITLE,
				"Elements Page title does not match expected value");

		logger.info("TC_003 - Test Completed Successfully");
	}

	@Test
	public void verifyFormsTileNavigation() {

		logger.info("TC_004 - Test Started: Verify Forms Tile Navigation");

		FormPage formPage = home.clickOnForms();

		Assert.assertEquals(formPage.getFormTitle(), Constants.FORMS_TITLE,
				"Forms Page title does not match expected value");

		logger.info("TC_004 - Test Completed Successfully");
	}

	@Test
	public void verifyAlertsFrameWindowsTileNavigation() {

		logger.info("TC_005 - Test Started: Verify Alerts, Frame & Windows Tile Navigation");

		AlertsPage alertsPage = home.clickOnAlert();

		Assert.assertEquals(alertsPage.getAlertTitle(), Constants.ALERTS_TITLE,
				"Alerts, Frame & Windows Page title does not match expected value");

		logger.info("TC_005 - Test Completed Successfully");
	}

	@Test
	public void verifyWidgetsTileNavigation() {

		logger.info("TC_006 - Test Started: Verify Widgets Tile Navigation");

		WidgetsPage widgetsPage = home.clickOnWidget();

		Assert.assertEquals(widgetsPage.getWidgetTitle(), Constants.WIDGETS_TITLE,
				"Widgets Page title does not match expected value");

		logger.info("TC_006 - Test Completed Successfully");
	}

	@Test
	public void verifyInteractionsTileNavigation() {

		logger.info("TC_007 - Test Started: Verify Interactions Tile Navigation");

		InteractionsPage interactionsPage = home.clickOnInteraction();

		Assert.assertEquals(interactionsPage.getInteractionTitle(), Constants.INTERACTIONS_TITLE,
				"Interactions Page title does not match expected value");

		logger.info("TC_007 - Test Completed Successfully");
	}

	@Test
	public void verifyBookStoreApplicationNavigation() {

		logger.info("TC_008 - Test Started: Verify Book Store Application Navigation");

		BookStorePage bookStorePage = home.clickOnBookStore();

		Assert.assertEquals(bookStorePage.getBookStoreTitle(), Constants.BOOK_STORE_TITLE,
				"Book Store Application Page title does not match expected value");

		logger.info("TC_008 - Test Completed Successfully");
	}

	@Test
	public void verifyFooterCopyrightText() {

		logger.info("TC_009 - Test Started: Verify Footer Copyright Text");

		String actualFooterText = home.getFooteTitle();

		Assert.assertEquals(actualFooterText, Constants.FOOTER_TEXT,
				"Footer copyright text does not match expected value");

		logger.info("TC_009 - Test Completed Successfully");
	}

}
