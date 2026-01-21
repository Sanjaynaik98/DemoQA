package com.demoqa.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demoqa.webautomation.pagebase.PageBase;

public class BookStorePage extends PageBase {

	@FindBy(xpath = "//div[@class='header-text'][normalize-space(text())='Book Store Application']")
	WebElement bookStoreTitle;
	public BookStorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isBookStoreDisplayed() {
		return isDisplayed(bookStoreTitle);
	}

	public String getBookStoreTitle() {
		return getText(bookStoreTitle);
	}

}
