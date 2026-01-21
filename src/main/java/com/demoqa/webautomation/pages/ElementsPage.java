package com.demoqa.webautomation.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.demoqa.webautomation.pagebase.PageBase;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ElementsPage extends PageBase {

	@FindBy(xpath = "//div[@class='header-text'][normalize-space(text())='Elements']")
	WebElement elementTitle;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Text Box')]")
	WebElement textBox;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Check Box')]")
	WebElement checkBox;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Radio Button')]")
	WebElement radioBtn;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Web Tables')]")
	WebElement webTable;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Buttons')]")
	WebElement buttons;

	@FindBy(xpath = "//ul[@class='menu-list']//span[text()='Links']")
	WebElement links;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Broken Links')]")
	WebElement brokenLinks;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Upload')]")
	WebElement uploadAndDownload;

	@FindBy(xpath = "//ul[@class='menu-list']//span[contains(text(),'Dynamic')]")
	WebElement dynamicProperties;

	@FindBy(xpath = "//h1[text()='Text Box']")
	WebElement textBoxHeader;

	@FindBy(xpath = "//input[@id='userName']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userEmail;

	@FindBy(xpath = "//textarea[@id='currentAddress']")
	WebElement currentAddress;

	@FindBy(xpath = "//textarea[@id='permanentAddress']")
	WebElement permanentAddress;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement submit;

	@FindBy(xpath = "//div[@id='output']//p[@id='name']")
	WebElement outPutName;
	@FindBy(xpath = "//div[@id='output']//p[@id='email']")
	WebElement outPutEmail;

	@FindBy(xpath = "//div[@id='output']//p[@id='currentAddress']")
	WebElement outPutCurrentAddress;

	@FindBy(xpath = "//div[@id='output']//p[@id='permanentAddress']")
	WebElement outPutParmanentAddress;

	@FindBy(xpath = "//div[@id='result']//span[@class='text-success']")
	List<WebElement> listOfCheckBoxSelected;

	@FindBy(xpath = "//span[@class='text-success']")
	WebElement radioBtnResult;

	@FindBy(xpath = "//label[@for='yesRadio']")
	WebElement yesRadioBtn;

	@FindBy(xpath = "//label[@for='impressiveRadio']")
	WebElement impressiveRadioBtn;

	@FindBy(xpath = "//button[@id='addNewRecordButton']")
	WebElement addNewRecordButton;

	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement registrationForm;

	@FindBy(xpath = "//div[@id='registration-form-modal']")
	WebElement registrationFormTitle;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userEmail1;

	@FindBy(xpath = "//input[@id='age']")
	WebElement age;

	@FindBy(xpath = "//input[@id='salary']")
	WebElement salary;

	@FindBy(xpath = "//input[@id='department']")
	WebElement department;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@id='searchBox']")
	WebElement searchBox;

	@FindBy(xpath = "//div[@class='rt-noData' and text()='No rows found']")
	WebElement NoRowFoundText;

	@FindBy(id = "doubleClickBtn")
	WebElement doubleClickBtn;

	@FindBy(id = "rightClickBtn")
	WebElement rightClickBtn;

	@FindBy(xpath = "//button[text()='Click Me']")
	WebElement clickMeBtn;

	@FindBy(xpath = "//p[@id='doubleClickMessage']")
	WebElement doubleClickVerifyMsg;

	@FindBy(xpath = "//p[@id='rightClickMessage']")
	WebElement rightClickVerifyMsg;

	@FindBy(xpath = "//p[@id='dynamicClickMessage']")
	WebElement clickMeVerifyMsg;

	@FindBy(xpath = "//a[contains(text(),'Click Here for Broken Link')]")
	WebElement brokenLink;

	@FindBy(xpath = "//a[contains(text(),'Click Here for Valid Link')]")
	WebElement validLink;

	@FindBy(xpath = "//a[@id='simpleLink']")
	WebElement simpleLink;

	@FindBy(xpath = "//a[@id='dynamicLink']")
	WebElement dynaimicLink;

	@FindBy(xpath = "//p[text()='Valid image']/following-sibling::img[@src='/images/Toolsqa.jpg']")
	WebElement validImage;

	@FindBy(xpath = "//img[@src='/images/Toolsqa_1.jpg']")
	WebElement inValidImage;

	@FindBy(xpath = "//a[@id='created']")
	WebElement createdLink;

	@FindBy(xpath = "//a[@id='no-content']")
	WebElement noContentLink;

	@FindBy(xpath = "//a[@id='moved']")
	WebElement movedLink;

	@FindBy(xpath = "//a[@id='bad-request']")
	WebElement badRequestLink;

	@FindBy(xpath = "//a[@id='unauthorized']")
	WebElement unauthorizedLink;

	@FindBy(xpath = "//a[@id='forbidden']")
	WebElement forbiddenLink;

	@FindBy(xpath = "//a[@id='invalid-url']")
	WebElement notFoundLink;

	@FindBy(xpath = "//p[@id='linkResponse']")
	WebElement linkResponseResult;

	@FindBy(xpath = "//a[text()='Download']")
	WebElement downloadBtn;

	@FindBy(xpath = "//input[@id='uploadFile']")
	WebElement uploadFileBtn;

	@FindBy(xpath = "//p[@id='uploadedFilePath']")
	WebElement uploadFilePath;

	@FindBy(xpath = "//p[normalize-space()='This text has random Id']")
	WebElement randomIdText;
	@FindBy(xpath = "//button[@id='enableAfter']")
	WebElement enableAfterBtn;

	@FindBy(xpath = "//button[@id='colorChange']")
	WebElement colorChangeBtn;

	@FindBy(xpath = "//button[@id='visibleAfter']")
	WebElement visibleAfterBtn;

	public ElementsPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String name) {
		enterText(userName, name);
	}

	public void enterEmail(String email) {
		enterText(userEmail, email);
	}

	public void enterCurrentAddress(String cAddress) {
		enterText(currentAddress, cAddress);
	}

	public void enterPermanentAddress(String pAddress) {
		enterText(permanentAddress, pAddress);
	}

	public void clickSubmit() {
		scrollAndClick(submit);
	}

	public String getOutPutUserName() {
		String outPutNameValue = getText(outPutName);
		return getTextAfterColon(outPutNameValue);
	}

	public String getOutPutUserEmail() {
		String outPutEmailValue = getText(outPutEmail);
		return getTextAfterColon(outPutEmailValue);
	}

	public String getOutPutUserCurrentAddress() {
		String outPutCurrentAddressValue = getText(outPutCurrentAddress);
		return getTextAfterColon(outPutCurrentAddressValue);
	}

	public String getOutPutUserPermanentAddress() {
		String outPutParmanentAddressValue = getText(outPutParmanentAddress);
		return getTextAfterColon(outPutParmanentAddressValue);
	}

	public void getHeader() {
		getText(textBoxHeader);
	}

	public void clickTextBox() {
		scrollAndClick(textBox);
	}

	public void clickCheckBox() {
		scrollAndClick(checkBox);
	}

	public void clickRadioBtn() {
		scrollAndClick(radioBtn);
	}

	public void clickWebTableBtn() {
		scrollAndClick(webTable);
	}

	public void clickButtonbtn() {
		scrollAndClick(buttons);
	}

	public void clickBrokenLinkbtn() {
		scrollAndClick(brokenLinks);
	}

	public void clickOnLinks() {
		scrollAndClick(links);
	}
	
	public void clickDynamicPropertiesBtn() {
		scrollAndClick(dynamicProperties);
	}

	public void clickOnUploadAndDownload() {
		scrollAndClick(uploadAndDownload);
	}

	public boolean isElementDisplayed() {
		return isDisplayed(elementTitle);
	}

	public String getElementTitle() {
		return getText(elementTitle);
	}

	public void getToggleByName(String nodeName) {
		By toggle = By.xpath("//span[text()='" + nodeName + "']/ancestor::label/preceding-sibling::button");
		scrollAndClick(toggle); // ✅ always uses PageBase method
	}

	public String getCheckBoxName(String checkBoxName) {
		By locator = By.xpath("//span[normalize-space()='" + checkBoxName + "']");
		waitForVisibility(locator);
		String checkBox = driver.findElement(locator).getText();
		return checkBox;
	}

	public boolean getCheckBoxVisibility(String checkBoxName) {
		By locator = By.xpath("//span[normalize-space()='" + checkBoxName + "']");
		waitForVisibility(locator);
		return driver.findElement(locator).isDisplayed();
	}

	public boolean getCheckBoxInVisibility(String checkBoxName) {
		By locator = By.xpath("//span[normalize-space()='" + checkBoxName + "']");
		return waitForInVisibility(locator);
	}

	public void clickCheckBox(String checkBoxName) {
		By checkBox = By.xpath("//span[@class='rct-title' and normalize-space()='" + checkBoxName
				+ "'] /ancestor::label //span[@class='rct-checkbox']");
		scrollAndClick(checkBox);
	}

	public boolean areAllExpectedCheckboxesSelected(List<String> expectedNames) {

		List<String> actualSelected = new ArrayList<>();

		for (WebElement checkbox : listOfCheckBoxSelected) {
			actualSelected.add(checkbox.getText().trim().toLowerCase());
		}

		logger.debug("Selected checkboxes: " + actualSelected);

		for (String expected : expectedNames) {
			String normalizedExpected = expected.toLowerCase();
			if (!actualSelected.contains(normalizedExpected)) {
				logger.error("Missing checkbox: " + expected);
				return false;
			}
		}

		return true;
	}

	public boolean areAllSelectedCheckboxesValid(List<String> expectedNames) {

		List<String> actualSelected = new ArrayList<>();

		for (WebElement checkbox : listOfCheckBoxSelected) {
			actualSelected.add(checkbox.getText().trim().toLowerCase());
		}

		logger.debug("Selected checkboxes from UI: " + actualSelected);

		if (actualSelected.isEmpty()) {
			logger.error("No checkboxes are selected in UI");
			return false;
		}

		List<String> normalizedExpected = expectedNames.stream().map(e -> e.toLowerCase()).toList();

		// Only rule: UI must not select anything invalid
		for (String actual : actualSelected) {
			if (!normalizedExpected.contains(actual)) {
				logger.error("Unexpected checkbox selected: " + actual);
				return false;
			}
		}

		return true;
	}

	public String selectYesRadioButton() {
		scrollAndClick(yesRadioBtn);
		logger.debug("Clicked on Yes radio button");
		String isSelected = radioBtnResult.getText();
		return isSelected;
	}

	public String selectImpressiveRadioButton() {
		scrollAndClick(impressiveRadioBtn);
		logger.debug("Clicked on Impressive radio button");
		String isSelected = radioBtnResult.getText();
		return isSelected;
	}

	public void addNewRecordBtn() {
		scrollAndClick(addNewRecordButton);
	}

	public boolean isRegistrationFormDisplayed() {
		return isDisplayed(registrationForm);
	}

	public boolean isRegistrationTitleDisplayed() {
		return isDisplayed(registrationFormTitle);
	}

	public boolean isRegistrationFirstNameDisplayed() {
		return isDisplayed(firstName);
	}

	public boolean isRegistrationLastNameDisplayed() {
		return isDisplayed(lastName);
	}

	public boolean isRegistrationEmailDisplayed() {
		return isDisplayed(userEmail1);
	}

	public boolean isRegistrationAgeDisplayed() {
		return isDisplayed(age);
	}

	public boolean isRegistrationSalaryDisplayed() {
		return isDisplayed(salary);
	}

	public boolean isRegistrationDepartmentDisplayed() {
		return isDisplayed(department);
	}

	public boolean isRegistrationSubmitBtnDisplayed() {
		return isDisplayed(submitBtn);
	}

	public void enterFirstName(String name) {
		enterText(firstName, name);
	}

	public void enterLastName(String lNames) {
		enterText(lastName, lNames);
	}

	public void enterUserEmail(String email) {
		enterText(userEmail1, email);
	}

	public void enterAge(String userAge) {
		enterText(age, userAge);
	}

	public void enterSalary(String salarys) {
		enterText(salary, salarys);
	}

	public void enterDepartment(String dep) {
		enterText(department, dep);
	}

	public void clickOnSubmit() {
		scrollAndClick(submitBtn);
	}

	public List<Map<String, String>> getAllTableDataFast() {

		List<Map<String, String>> tableData = new ArrayList<>();

		List<WebElement> firstNames = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][1]"));
		List<WebElement> lastNames = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][2]"));
		List<WebElement> ages = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][3]"));
		List<WebElement> emails = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][4]"));
		List<WebElement> salaries = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][5]"));
		List<WebElement> departments = driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][6]"));

		int rowCount = firstNames.size();

		for (int i = 0; i < rowCount; i++) {
			Map<String, String> row = new LinkedHashMap<>();
			row.put("firstName", firstNames.get(i).getText().trim());
			row.put("lastName", lastNames.get(i).getText().trim());
			row.put("age", ages.get(i).getText().trim());
			row.put("email", emails.get(i).getText().trim());
			row.put("salary", salaries.get(i).getText().trim());
			row.put("department", departments.get(i).getText().trim());

			tableData.add(row);
		}

		return tableData;
	}

	public Map<String, String> getRowDataByFirstName(String firstName) {

		List<Map<String, String>> tableData = getAllTableDataFast();

		for (Map<String, String> row : tableData) {
			if (row.get("firstName").equals(firstName)) {
				return row;
			}
		}
		return null;
	}

	public boolean isRecordPresentInTable(HashMap<String, String> expectedData) {

		List<Map<String, String>> uiTableData = getAllTableDataFast();

		for (Map<String, String> row : uiTableData) {
			if (row.get("firstName").equals(expectedData.get("firstName"))
					&& row.get("lastName").equals(expectedData.get("lastName"))
					&& row.get("email").equals(expectedData.get("email"))
					&& row.get("salary").equals(expectedData.get("salary"))
					&& row.get("department").equals(expectedData.get("department"))) {
				return true;
			}
		}
		return false;
	}

	public void clickOnEdit(String name) {
		By editIcon = By.xpath("//div[@class='rt-td' and text()='" + name
				+ "'] /ancestor::div[contains(@class,'rt-tr')] //span[contains(@id,'edit')]");
		WebElement edit = driver.findElement(editIcon);
		scrollAndClick(edit);
	}

	public String getFirstName() {
		return firstName.getDomProperty("value");
	}

	public String getLastName() {
		return lastName.getDomAttribute("value");
	}

	public String getUserEmail() {
		return userEmail1.getDomAttribute("value");
	}

	public String getAge() {
		return age.getDomAttribute("value");
	}

	public String getSalary() {
		return salary.getDomAttribute("value");
	}

	public String getDepartment() {
		return department.getDomAttribute("value");
	}

	public void clickOnDelete(String name) {
		By deleteIcon = By.xpath("//div[@class='rt-td' and text()='" + name
				+ "'] /ancestor::div[contains(@class,'rt-tr')] //span[contains(@id,'delete')]");
		WebElement delete = driver.findElement(deleteIcon);
		scrollAndClick(delete);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("//div[@role='row' and .//div[@role='gridcell' and text()='" + name + "']]")));
	}

	public boolean isRecordPresent(String firstName) {
		return driver.findElements(By.xpath("//div[@role='row' and .//div[text()='" + firstName + "']]")).size() > 0;

	}

	public void enterSearchBox(String searchText) {

		enterText(searchBox, searchText);
	}

	public boolean verifyOnlyMatchingRecordDisplayed(String firstName) {

		WebElement tableBody = driver.findElement(By.cssSelector("div.rt-tbody"));

		List<WebElement> rows = tableBody
				.findElements(By.xpath(".//div[contains(@class,'rt-tr') and not(contains(@class,'-padRow'))]"));

		for (WebElement row : rows) {

			String rowText = row.getText().trim();

			if (rowText.isEmpty()) {
				continue;
			}

			if (!rowText.contains(firstName)) {
				logger.warn("Unexpected record found in table: " + rowText);
				return false;
			}
		}

		return true;
	}

	public boolean noRowFoundIsDisplayed() {
		return isDisplayed(NoRowFoundText);

	}

	public String doubleClickVerify() {
		scrollToElement(doubleClickBtn);
		doubleClick(doubleClickBtn);
		return getText(doubleClickVerifyMsg);
	}

	public String rightClickVerify() {
		scrollToElement(rightClickBtn);
		rightClick(rightClickBtn);
		return getText(rightClickVerifyMsg);
	}

	public String clickMeVerify() {
		scrollToElement(clickMeBtn);
		click(clickMeBtn);
		return getText(clickMeVerifyMsg);
	}

	public String checkLinkOpenInNewTab() {
		return handleWindow(simpleLink);
	}

	public String checkDynamicLinkOpenInNewTab() {
		return handleWindow(dynaimicLink);
	}

	public Integer checkValidLink() {
		int responsCode = brokenLinkValidator(validLink);
		return responsCode;
	}

	public Integer checkBrokenLink() {

		int responsCode = brokenLinkValidator(brokenLink);
		return responsCode;
	}
	
	public String clickCreatedLinkAndGetResponse() {
	    scrollAndClick(createdLink);
	    return linkResponseResult.getText();
	}

	public String clickNoContentLinkAndGetResponse() {
	    scrollAndClick(noContentLink);
	    return linkResponseResult.getText();
	}

	public String clickMovedLinkAndGetResponse() {
	    scrollAndClick(movedLink);
	    return linkResponseResult.getText();
	}

	public String clickBadRequestLinkAndGetResponse() {
	    scrollAndClick(badRequestLink);
	    return linkResponseResult.getText();
	}

	public String clickUnauthorizedLinkAndGetResponse() {
	    scrollAndClick(unauthorizedLink);
	    return linkResponseResult.getText();
	}

	public String clickForbiddenLinkAndGetResponse() {
	    scrollAndClick(forbiddenLink);
	    return linkResponseResult.getText();
	}

	public String clickNotFoundLinkAndGetResponse() {
	    scrollAndClick(notFoundLink);
	    return linkResponseResult.getText();
	}


	public String validateLinkResponse(WebElement link) {
		scrollAndClick(link);
		String response = linkResponseResult.getText();
		return response;
	}

	private boolean isImageLoaded(WebElement img) {
		return (Boolean) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", img);
	}

	public boolean isValidImageLoaded() {
		return isImageLoaded(validImage);
	}

	public boolean isBrokenImageLoaded() {
		return isImageLoaded(inValidImage);
	}

	public void clickOnDownloadBtn() {
		scrollAndClick(downloadBtn);
	}

	public String uploadFile(String path) {
		uploadFileBtn.sendKeys(path);
		return getText(uploadFilePath);
	}

	public boolean verifyRandomIdTextDisplayed() {
		return randomIdText.isDisplayed();
	}

	public boolean verifyEnableAfter5Seconds() {
		wait.until(ExpectedConditions.elementToBeClickable(enableAfterBtn));
		return enableAfterBtn.isEnabled();
	}

	public boolean verifyColorChange() {
		String beforeClass = colorChangeBtn.getDomAttribute("class");

		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(colorChangeBtn, "class", beforeClass)));
		String afterClass = colorChangeBtn.getDomAttribute("class");

		return !beforeClass.equals(afterClass);

	}

	public boolean verifyVisibleAfter5Seconds() {
		waitForVisibility(visibleAfterBtn);
		return visibleAfterBtn.isDisplayed();
	}

}
