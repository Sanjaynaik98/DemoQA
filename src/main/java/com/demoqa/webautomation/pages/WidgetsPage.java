package com.demoqa.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.webautomation.pagebase.PageBase;

public class WidgetsPage extends PageBase {

	@FindBy(xpath = "//div[@class='header-text'][normalize-space(text())='Widgets']")
	WebElement widgetTitle;

	public WidgetsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isWidgetDisplayed() {
		return isDisplayed(widgetTitle);
	}

	public String getWidgetTitle() {
		return getText(widgetTitle);
	}

}
