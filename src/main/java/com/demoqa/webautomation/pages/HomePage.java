package com.demoqa.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.webautomation.pagebase.PageBase;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//img[contains(@src,'Toolsqa')]")
	WebElement logo;

	@FindBy(xpath = "//img[@class='banner-image']")
	WebElement bannerImage;

	@FindBy(xpath = "//h5[text()='Elements']/ancestor::div[contains(@class,'card mt-4')]")
	WebElement elements;

	@FindBy(xpath = "//h5[text()='Forms']/ancestor::div[contains(@class,'card mt-4')]")
	WebElement forms;

	@FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'card mt-4')]")
	WebElement alerts;

	@FindBy(xpath = "//h5[text()='Widgets']/ancestor::div[contains(@class,'card mt-4')]")
	WebElement widgets;

	@FindBy(xpath = "//h5[text()='Interactions']/ancestor::div[contains(@class,'card mt-4')]")
	WebElement interactions;
	@FindBy(xpath = "//h5[normalize-space()='Book Store Application']/ancestor::div[contains(@class,'card mt-4')]")
	WebElement bookStore;
	@FindBy(xpath = "//footer//span[contains(text(),'2013')]")
	WebElement footerTitle;

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean isLogoDisplayed() {
		return isDisplayed(logo);
	}

	public boolean isBannerImageDisplayed() {
		return isDisplayed(bannerImage);
	}

	public ElementsPage clickOnElements() {
		scrollAndClick(elements);
		return new ElementsPage(driver);
	}

	public FormPage clickOnForms() {
		scrollAndClick(forms);
		return new FormPage(driver);
	}

	public AlertsPage clickOnAlert() {
		scrollAndClick(alerts);
		return new AlertsPage(driver);
	}
	
	public WidgetsPage clickOnWidget() {
		scrollAndClick(widgets);
		return new WidgetsPage(driver);
	}

	public InteractionsPage clickOnInteraction() {
		scrollAndClick(interactions);
		return new InteractionsPage(driver);
	}
	public BookStorePage clickOnBookStore() {
		scrollAndClick(bookStore);
		return new BookStorePage(driver);
	}
	
	public String getFooteTitle() {
		String footTitle =footerTitle.getText();
		return footTitle;
	}
}
