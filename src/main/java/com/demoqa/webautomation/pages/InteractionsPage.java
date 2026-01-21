package com.demoqa.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.webautomation.pagebase.PageBase;

public class InteractionsPage extends PageBase {

	@FindBy(xpath = "//div[@class='header-text'][normalize-space(text())='Interactions']")
	WebElement interactionTitle;
	public InteractionsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isInteractionDisplayed() {
		return isDisplayed(interactionTitle);
	}

	public String getInteractionTitle() {
		return getText(interactionTitle);
	}


}
