package com.demoqa.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.webautomation.pagebase.PageBase;

public class AlertsPage extends PageBase {
	
	@FindBy(xpath = "//div[@class='header-text'][normalize-space(text())='Alerts, Frame & Windows']")
	WebElement alertsTitle;

	public AlertsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public boolean isAlertDisplayed() {
		return isDisplayed(alertsTitle);
	}

	public String getAlertTitle() {
		return getText(alertsTitle);
	}

}
