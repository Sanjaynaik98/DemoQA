package com.demoqa.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.webautomation.pagebase.PageBase;

public class FormPage extends PageBase{

	@FindBy(xpath = "//div[@class='header-text'][normalize-space(text())='Forms']")
	WebElement formTitle;
	public FormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public boolean isFormDisplayed() {
		return isDisplayed(formTitle);
	}

	public String getFormTitle() {
		return getText(formTitle);
	}

}
