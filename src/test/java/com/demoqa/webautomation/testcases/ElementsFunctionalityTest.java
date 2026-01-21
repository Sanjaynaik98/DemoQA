package com.demoqa.webautomation.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demoqa.webautomation.pagebase.TestBase;
import com.demoqa.webautomation.pages.ElementsPage;
import com.demoqa.webautomation.pages.HomePage;
import com.demoqa.webautomation.utilities.Constants;
import com.demoqa.webautomation.utilities.DataProviders;

public class ElementsFunctionalityTest extends TestBase {

	private HomePage home;
	private ElementsPage elem;

	@BeforeMethod(alwaysRun = true)
	public void setUpHomePage() {
		logInfo("===== Initializing Home Page before test execution =====");
		home = new HomePage(getDriver());
		elem = home.clickOnElements();
		logInfo("Navigated to Elements module");

	}

	// ======================= TEXT BOX TESTS =======================

	@Test(priority = 1, dataProvider = "validFormData", dataProviderClass = DataProviders.class, groups = "textbox", description = "TC_001: Verify form submission with all valid data fields")
	public void verifyFormSubmissionWithValidData(HashMap<String, String> input) {

		logInfo("TC_001 STARTED: Verify Form Submission With Valid Data");

		elem.clickTextBox();
		logInfo("Navigated to Text Box section");

		elem.enterUserName(input.get("fullName"));
		logInfo("Entered Full Name");

		elem.enterEmail(input.get("email"));
		logInfo("Entered Email");

		elem.enterCurrentAddress(input.get("currentAddress"));
		logInfo("Entered Current Address");

		elem.enterPermanentAddress(input.get("permanentAddress"));
		logInfo("Entered Permanent Address");

		elem.clickSubmit();
		logInfo("Clicked Submit button");

		logInfo("Validating submitted form output");
		Assert.assertEquals(elem.getOutPutUserName(), input.get("fullName"), "Username mismatch");
		Assert.assertEquals(elem.getOutPutUserEmail(), input.get("email"), "Email mismatch");
		Assert.assertEquals(elem.getOutPutUserCurrentAddress(), input.get("currentAddress"),
				"Current Address mismatch");
		Assert.assertEquals(elem.getOutPutUserPermanentAddress(), input.get("permanentAddress"),
				"Permanent Address mismatch");

		logInfo("TC_001 PASSED: Form submitted successfully with valid data");
	}

	@Test(priority = 2, dataProvider = "validFormData", dataProviderClass = DataProviders.class, groups = "textbox", description = "TC_002: Verify form submission with only valid name field")
	public void verifyFormSubmissionWithValidName(HashMap<String, String> input) {

		logInfo("TC_002 STARTED: Verify Form Submission With Valid Name");
		elem.clickTextBox();
		logInfo("Navigated to Text Box section");

		logInfo("Entering only Full Name");
		elem.enterUserName(input.get("fullName"));

		elem.clickSubmit();
		logInfo("Clicked Submit button");

		Assert.assertEquals(elem.getOutPutUserName(), input.get("fullName"), "Username output mismatch");

		logInfo("TC_002 PASSED: Form submitted successfully with valid name");
	}

	@Test(priority = 3, dataProvider = "validFormData", dataProviderClass = DataProviders.class, groups = "textbox", description = "TC_003: Verify form submission with only valid email field")
	public void verifyFormSubmissionWithValidEmail(HashMap<String, String> input) {

		logInfo("TC_003 STARTED: Verify Form Submission With Valid Email");
		elem.clickTextBox();
		logInfo("Navigated to Text Box section");

		logInfo("Entering only Email");
		elem.enterEmail(input.get("email"));

		elem.clickSubmit();
		logInfo("Clicked Submit button");

		Assert.assertEquals(elem.getOutPutUserEmail(), input.get("email"), "Email output mismatch");

		logInfo("TC_003 PASSED: Form submitted successfully with valid email");
	}

	@Test(priority = 4, dataProvider = "validFormData", dataProviderClass = DataProviders.class, groups = "textbox", description = "TC_004: Verify form submission with only valid current address field")
	public void verifyFormSubmissionWithValidCurrentAddress(HashMap<String, String> input) {

		logInfo("TC_004 STARTED: Verify Form Submission With Valid Current Address");
		elem.clickTextBox();
		logInfo("Navigated to Text Box section");

		logInfo("Entering Current Address");
		elem.enterCurrentAddress(input.get("currentAddress"));

		elem.clickSubmit();
		logInfo("Clicked Submit button");

		Assert.assertEquals(elem.getOutPutUserCurrentAddress(), input.get("currentAddress"),
				"Current Address output mismatch");

		logInfo("TC_004 PASSED: Form submitted successfully with valid current address");
	}

	@Test(priority = 5, dataProvider = "validFormData", dataProviderClass = DataProviders.class, groups = "textbox", description = "TC_005: Verify form submission with only valid permanent address field")
	public void verifyFormSubmissionWithValidPermanentAddress(HashMap<String, String> input) {

		logInfo("TC_005 STARTED: Verify Form Submission With Valid Permanent Address");
		elem.clickTextBox();
		logInfo("Navigated to Text Box section");

		logInfo("Entering Permanent Address");
		elem.enterPermanentAddress(input.get("permanentAddress"));

		elem.clickSubmit();
		logInfo("Clicked Submit button");

		Assert.assertEquals(elem.getOutPutUserPermanentAddress(), input.get("permanentAddress"),
				"Permanent Address output mismatch");

		logInfo("TC_005 PASSED: Form submitted successfully with valid permanent address");
	}

	// ======================= CHECK BOX TESTS =======================

	@Test(priority = 6, groups = "checkbox", description = "TC_006: Verify Home folder expand and collapse functionality")
	public void verifyHomeFolderExpandCollapse() {

		logInfo("TC_006 STARTED - Verify Home Folder Expand Collapse");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		boolean checkBoxVisible = elem.getCheckBoxVisibility(Constants.DESKTOP);
		logInfo("Checked Desktop visibility after expand: " + checkBoxVisible);

		Assert.assertTrue(checkBoxVisible, "Desktop should be visible after expanding");

		elem.getToggleByName(Constants.HOME);
		logInfo("Collapsed Home folder");

		boolean isDesktopInvisible = elem.getCheckBoxInVisibility(Constants.DESKTOP);
		logInfo("Checked Desktop invisibility after collapse: " + isDesktopInvisible);

		Assert.assertTrue(isDesktopInvisible, "Desktop should be hidden after collapsing");

		logInfo("TC_006 PASSED - Home folder expand & collapse verified");
	}

	@Test(priority = 7, groups = "checkbox", description = "TC_007: Verify clicking Home checkbox selects all child checkboxes")
	public void verifyHomeSelectsAllCheckboxes() {

		logInfo("TC_007 STARTED - Verify clicking Home selects all checkboxes");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.clickCheckBox(Constants.HOME);
		logInfo("Clicked on Home checkbox");

		boolean result = elem.areAllExpectedCheckboxesSelected(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for all checkboxes selected: " + result);

		Assert.assertTrue(result, "Not all child checkboxes are selected");

		logInfo("TC_007 PASSED - Home checkbox selects all child checkboxes successfully");
	}

	@Test(priority = 8, groups = "checkbox", description = "TC_008: Verify clicking Desktop checkbox selects all its child checkboxes")
	public void verifyDesktopSelectsAllChildCheckboxes() {
		logInfo("TC_008 STARTED - Verify clicking Desktop selects all child checkboxes");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");
		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");
		elem.clickCheckBox(Constants.DESKTOP);
		logInfo("Clicked on Desktop checkbox");
		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for all checkboxes selected: " + result);

		Assert.assertTrue(result, "Not all child checkboxes are selected");

		logInfo("TC_008 PASSED - Desktop checkbox selects all child checkboxes successfully");

	}

	@Test(priority = 9, groups = "checkbox", description = "TC_009: Verify clicking Documents checkbox selects all its child checkboxes")
	public void verifyDocumentsSelectsAllChildCheckboxes() {

		logInfo("TC_009 STARTED - Verify clicking Documents selects all child checkboxes");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.clickCheckBox(Constants.DOCUMENTS);
		logInfo("Clicked on Documents checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Documents did not select all its child checkboxes");

		logInfo("TC_009 PASSED - Documents checkbox selects all its child checkboxes successfully");
	}

	@Test(priority = 10, groups = "checkbox", description = "TC_010: Verify clicking Downloads checkbox selects all its child checkboxes")
	public void verifyDownloadsSelectsAllChildCheckboxes() {

		logInfo("TC_010 STARTED - Verify clicking Downloads selects all child checkboxes");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.clickCheckBox(Constants.DOWNLOADS);
		logInfo("Clicked on Downloads checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Downloads did not select all its child checkboxes");

		logInfo("TC_010 PASSED - Downloads checkbox selects all its child checkboxes successfully");
	}

	@Test(priority = 11, groups = "checkbox", description = "TC_011: Verify clicking Workspace checkbox selects all its child checkboxes")
	public void verifyWorkspaceSelectsAllChildCheckboxes() {

		logInfo("TC_011 STARTED - Verify clicking Workspace selects all child checkboxes");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.clickCheckBox(Constants.WORKSPACE);
		logInfo("Clicked on Workspace checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Workspace did not select all its child checkboxes");

		logInfo("TC_011 PASSED - Workspace checkbox selects all its child checkboxes successfully");
	}

	@Test(priority = 12, groups = "checkbox", description = "TC_012: Verify clicking Office checkbox selects all its child checkboxes")
	public void verifyOfficeSelectsAllChildCheckboxes() {

		logInfo("TC_012 STARTED - Verify clicking Office selects all child checkboxes");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.clickCheckBox(Constants.OFFICE);
		logInfo("Clicked on Office checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Office did not select all its child checkboxes");

		logInfo("TC_012 PASSED - Office checkbox selects all its child checkboxes successfully");
	}

	@Test(priority = 13, groups = "checkbox", description = "TC_013: Verify clicking Notes checkbox selects it correctly")
	public void verifyClickOnNotesCheckbox() {

		logInfo("TC_013 STARTED - Verify clicking Notes selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DESKTOP);
		logInfo("Expanded Desktop folder");

		elem.clickCheckBox(Constants.NOTES);
		logInfo("Clicked on Notes checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Notes checkbox selection is incorrect");

		logInfo("TC_013 PASSED - Notes checkbox selected successfully");
	}

	@Test(priority = 14, groups = "checkbox", description = "TC_014: Verify clicking Commands checkbox selects it correctly")
	public void verifyClickOnCommandsCheckbox() {

		logInfo("TC_014 STARTED - Verify clicking Commands selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DESKTOP);
		logInfo("Expanded Desktop folder");

		elem.clickCheckBox(Constants.COMMANDS);
		logInfo("Clicked on Commands checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Commands checkbox selection is incorrect");

		logInfo("TC_014 PASSED - Commands checkbox selected successfully");
	}

	@Test(priority = 15, groups = "checkbox", description = "TC_015: Verify clicking React checkbox selects it correctly")
	public void verifyClickOnReactCheckbox() {

		logInfo("TC_015 STARTED - Verify clicking React selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.WORKSPACE);
		logInfo("Expanded Workspace folder");

		elem.clickCheckBox(Constants.REACT);
		logInfo("Clicked on React checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "React checkbox selection is incorrect");

		logInfo("TC_015 PASSED - React checkbox selected successfully");
	}

	@Test(priority = 16, groups = "checkbox", description = "TC_016: Verify clicking Angular checkbox selects it correctly")
	public void verifyClickOnAngularCheckbox() {

		logInfo("TC_016 STARTED - Verify clicking Angular selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.WORKSPACE);
		logInfo("Expanded Workspace folder");

		elem.clickCheckBox(Constants.ANGULAR);
		logInfo("Clicked on Angular checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Angular checkbox selection is incorrect");

		logInfo("TC_016 PASSED - Angular checkbox selected successfully");
	}

	@Test(priority = 17, groups = "checkbox", description = "TC_017: Verify clicking Veu checkbox selects it correctly")
	public void verifyClickOnVeuCheckbox() {

		logInfo("TC_017 STARTED - Verify clicking Veu selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.WORKSPACE);
		logInfo("Expanded Workspace folder");

		elem.clickCheckBox(Constants.VEU);
		logInfo("Clicked on Veu checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Veu checkbox selection is incorrect");

		logInfo("TC_017 PASSED - Veu checkbox selected successfully");
	}

	@Test(priority = 18, groups = "checkbox", description = "TC_018: Verify clicking Public checkbox selects it correctly")
	public void verifyClickOnPublicCheckbox() {

		logInfo("TC_018 STARTED - Verify clicking Public selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.OFFICE);
		logInfo("Expanded Office folder");

		elem.clickCheckBox(Constants.PUBLIC);
		logInfo("Clicked on Public checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Public checkbox selection is incorrect");

		logInfo("TC_018 PASSED - Public checkbox selected successfully");
	}

	@Test(priority = 19, groups = "checkbox", description = "TC_019: Verify clicking Private checkbox selects it correctly")
	public void verifyClickOnPrivateCheckbox() {

		logInfo("TC_019 STARTED - Verify clicking Private selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.OFFICE);
		logInfo("Expanded Office folder");

		elem.clickCheckBox(Constants.PRIVATE);
		logInfo("Clicked on Private checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Private checkbox selection is incorrect");

		logInfo("TC_019 PASSED - Private checkbox selected successfully");
	}

	@Test(priority = 20, groups = "checkbox", description = "TC_020: Verify clicking Classified checkbox selects it correctly")
	public void verifyClickOnClassifiedCheckbox() {

		logInfo("TC_020 STARTED - Verify clicking Classified selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.OFFICE);
		logInfo("Expanded Office folder");

		elem.clickCheckBox(Constants.CLASSIFIED);
		logInfo("Clicked on Classified checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Classified checkbox selection is incorrect");

		logInfo("TC_020 PASSED - Classified checkbox selected successfully");
	}

	@Test(priority = 21, groups = "checkbox", description = "TC_021: Verify clicking General checkbox selects it correctly")
	public void verifyClickOnGeneralCheckbox() {

		logInfo("TC_021 STARTED - Verify clicking General selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.OFFICE);
		logInfo("Expanded Office folder");

		elem.clickCheckBox(Constants.GENERAL);
		logInfo("Clicked on General checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "General checkbox selection is incorrect");

		logInfo("TC_021 PASSED - General checkbox selected successfully");
	}

	@Test(priority = 22, groups = "checkbox", description = "TC_022: Verify clicking Word File checkbox selects it correctly")
	public void verifyClickOnWordFileCheckbox() {

		logInfo("TC_022 STARTED - Verify clicking Word File selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.DOWNLOADS);
		logInfo("Expanded Downloads folder");

		elem.clickCheckBox(Constants.WORD_FILE);
		logInfo("Clicked on Word File checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Word File checkbox selection is incorrect");

		logInfo("TC_022 PASSED - Word File checkbox selected successfully");
	}

	@Test(priority = 23, groups = "checkbox", description = "TC_023: Verify clicking Excel File checkbox selects it correctly")
	public void verifyClickOnExcelFileCheckbox() {

		logInfo("TC_023 STARTED - Verify clicking Excel File selects the checkbox");

		elem.clickCheckBox();
		logInfo("Navigated to Check Box section");

		elem.getToggleByName(Constants.HOME);
		logInfo("Expanded Home folder");

		elem.getToggleByName(Constants.DOCUMENTS);
		logInfo("Expanded Documents folder");

		elem.getToggleByName(Constants.DOWNLOADS);
		logInfo("Expanded Downloads folder");

		elem.clickCheckBox(Constants.EXCEL_FILE);
		logInfo("Clicked on Excel File checkbox");

		boolean result = elem.areAllSelectedCheckboxesValid(Constants.CHECKBOX_NAMES);
		logInfo("Verification result for selected checkboxes: " + result);

		Assert.assertTrue(result, "Excel File checkbox selection is incorrect");

		logInfo("TC_023 PASSED - Excel File checkbox selected successfully");
	}

	@Test(priority = 24, groups = "radio", description = "TC_024: Verify Yes radio button can be selected successfully")
	public void verifyYesRadioButtonSelected() {

		logInfo("TC_024 STARTED - Verify Yes radio button selection");

		elem.clickRadioBtn();
		logInfo("Navigated to Radio Button section");

		String selectedValue = elem.selectYesRadioButton();
		logInfo("Clicked on Yes radio button");

		logInfo("UI confirmation message: " + selectedValue);

		Assert.assertEquals(selectedValue, Constants.YES_RADIO, "Yes radio button selection message is incorrect");

		logInfo("TC_024 PASSED - Yes radio button selected successfully");
	}

	@Test(priority = 25, groups = "radio", description = "TC_025: Verify Impressive radio button can be selected successfully")
	public void verifyImpressiveRadioButtonSelected() {

		logInfo("TC_025 STARTED - Verify Impressive radio button selection");

		elem.clickRadioBtn();
		logInfo("Navigated to Radio Button section");

		String selectedValue = elem.selectImpressiveRadioButton();
		logInfo("Clicked on Impressive radio button");

		logInfo("UI confirmation message: " + selectedValue);

		Assert.assertEquals(selectedValue, Constants.IMPRESSIVE_RADIO,
				"Impressive radio button selection message is incorrect");

		logInfo("TC_025 PASSED - Impressive radio button selected successfully");
	}

	@Test(priority = 26, groups = "webtable", description = "TC_026: Verify Add button opens registration form with all required fields")
	public void verifyAddButtonOpensRegistrationForm() {

		logInfo("TC_026 STARTED - Verify Add button opens Registration form");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables section");

		elem.addNewRecordBtn();
		logInfo("Clicked on Add New Record button");

		Assert.assertTrue(elem.isRegistrationFormDisplayed(), "Registration form is not displayed");
		logInfo("Registration form is displayed");

		Assert.assertTrue(elem.isRegistrationTitleDisplayed(), "Registration form title is not displayed");
		logInfo("Registration title is displayed");

		Assert.assertTrue(elem.isRegistrationFirstNameDisplayed(), "First Name field is not displayed");
		logInfo("First Name field is displayed");

		Assert.assertTrue(elem.isRegistrationLastNameDisplayed(), "Last Name field is not displayed");
		logInfo("Last Name field is displayed");

		Assert.assertTrue(elem.isRegistrationEmailDisplayed(), "Email field is not displayed");
		logInfo("Email field is displayed");

		Assert.assertTrue(elem.isRegistrationAgeDisplayed(), "Age field is not displayed");
		logInfo("Age field is displayed");

		Assert.assertTrue(elem.isRegistrationSalaryDisplayed(), "Salary field is not displayed");
		logInfo("Salary field is displayed");

		Assert.assertTrue(elem.isRegistrationDepartmentDisplayed(), "Department field is not displayed");
		logInfo("Department field is displayed");

		Assert.assertTrue(elem.isRegistrationSubmitBtnDisplayed(), "Submit button is not displayed");
		logInfo("Submit button is displayed");

		logInfo("TC_026 PASSED - Registration form opened successfully with all fields visible");
	}

	@Test(priority = 27, dataProvider = "registrationFormValidData", dataProviderClass = DataProviders.class, groups = "webtable", description = "TC_027: Verify adding a new record to web table with all valid data")
	public void verifyAddingNewRecordWithAllValidData(HashMap<String, String> input) {

		logInfo("TC_027 STARTED - Verify adding new record with valid data");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables section");

		elem.addNewRecordBtn();
		logInfo("Clicked on Add New Record button");

		logInfo("Entering Registration Form details:");
		logInfo("First Name: " + input.get("firstName"));
		logInfo("Last Name: " + input.get("lastName"));
		logInfo("Email: " + input.get("email"));
		logInfo("Age: " + input.get("age"));
		logInfo("Salary: " + input.get("salary"));
		logInfo("Department: " + input.get("department"));

		elem.enterFirstName(input.get("firstName"));
		elem.enterLastName(input.get("lastName"));
		elem.enterUserEmail(input.get("email"));
		elem.enterAge(input.get("age"));
		elem.enterSalary(input.get("salary"));
		elem.enterDepartment(input.get("department"));

		elem.clickOnSubmit();
		logInfo("Clicked on Submit button");

		logInfo("Validating if newly added record is present in Web Table");

		boolean isRecordAdded = elem.isRecordPresentInTable(input);

		if (isRecordAdded) {
			logInfo("Record successfully found in Web Table for: " + input.get("firstName") + " "
					+ input.get("lastName"));
		} else {
			logger.error("Record NOT found in Web Table for: " + input.get("firstName") + " " + input.get("lastName"));
		}

		Assert.assertTrue(isRecordAdded, "Added record is not found in Web Table");

		logInfo("TC_027 PASSED - Verify adding new record with valid data");
	}

	@Test(priority = 28, dataProvider = "preDefinedWebTableData", dataProviderClass = DataProviders.class, groups = "webtable", description = "TC_028: Verify Edit button opens the correct record with accurate data")
	public void verifyEditButtonOpensRecordWithCorrectData(HashMap<String, String> input) {

		logInfo("TC_028 STARTED - Verify Edit button opens record with correct data");

		logInfo("Clicked on Elements module");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables page");

		logInfo("Clicking Edit for record with First Name: " + input.get("firstName"));
		elem.clickOnEdit(input.get("firstName"));

		logInfo("Validating Registration Form is displayed");
		Assert.assertTrue(elem.isRegistrationFormDisplayed(), "Registration form is not displayed");

		logInfo("Validating Registration Form title is displayed");
		Assert.assertTrue(elem.isRegistrationTitleDisplayed(), "Registration form title is not displayed");

		logInfo("Fetching values from Registration Form");

		String firstName = elem.getFirstName();
		String lastName = elem.getLastName();
		String email = elem.getUserEmail();
		String age = elem.getAge();
		String salary = elem.getSalary();
		String department = elem.getDepartment();

		logInfo("Validating form data against expected values");
		logInfo("Expected First Name: " + input.get("firstName") + " | Actual: " + firstName);
		logInfo("Expected Last Name: " + input.get("lastName") + " | Actual: " + lastName);
		logInfo("Expected Email: " + input.get("email") + " | Actual: " + email);
		logInfo("Expected Age: " + input.get("age") + " | Actual: " + age);
		logInfo("Expected Salary: " + input.get("salary") + " | Actual: " + salary);
		logInfo("Expected Department: " + input.get("department") + " | Actual: " + department);

		Assert.assertEquals(firstName, input.get("firstName"), "First Name mismatch");
		Assert.assertEquals(lastName, input.get("lastName"), "Last Name mismatch");
		Assert.assertEquals(email, input.get("email"), "Email mismatch");
		Assert.assertEquals(age, input.get("age"), "Age mismatch");
		Assert.assertEquals(salary, input.get("salary"), "Salary mismatch");
		Assert.assertEquals(department, input.get("department"), "Department mismatch");

		logInfo("TC_028 COMPLETED - Edit button opens correct record");
	}

	@Test(priority = 29, dataProvider = "editWithValidName", dataProviderClass = DataProviders.class, groups = "webtable", description = "TC_029: Verify editing an existing record in the web table")
	public void verifyEditingExistingRecord(HashMap<String, String> editData, HashMap<String, String> validName) {

		logInfo("TC_029 STARTED - Verify Editing Existing Record");

		logInfo("Clicked on Elements module");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables page");

		logInfo("Fetching existing record for First Name: " + validName.get("firstName"));
		Map<String, String> beforeEdit = elem.getRowDataByFirstName(validName.get("firstName"));

		Assert.assertNotNull(beforeEdit, "Record not found before editing");
		logInfo("Record found before editing: " + beforeEdit);

		logInfo("Clicking Edit icon for First Name: " + validName.get("firstName"));
		elem.clickOnEdit(validName.get("firstName"));

		Assert.assertTrue(elem.isRegistrationFormDisplayed(), "Registration form is not displayed");
		Assert.assertTrue(elem.isRegistrationTitleDisplayed(), "Registration form title is not displayed");
		logInfo("Registration form opened successfully");

		logInfo("Updating Salary to: " + editData.get("salary"));
		elem.enterSalary(editData.get("salary"));

		logInfo("Updating Department to: " + editData.get("department"));
		elem.enterDepartment(editData.get("department"));

		elem.clickSubmit();
		logInfo("Clicked on Submit button");

		logInfo("Fetching updated record for First Name: " + validName.get("firstName"));
		Map<String, String> afterEdit = elem.getRowDataByFirstName(validName.get("firstName"));

		Assert.assertNotNull(afterEdit, "Record not found after editing");
		logInfo("Record found after editing: " + afterEdit);

		Assert.assertEquals(afterEdit.get("salary"), editData.get("salary"), "Salary was not updated correctly");
		Assert.assertEquals(afterEdit.get("department"), editData.get("department"),
				"Department was not updated correctly");

		Assert.assertEquals(afterEdit.get("firstName"), beforeEdit.get("firstName"), "First Name should not change");
		Assert.assertEquals(afterEdit.get("lastName"), beforeEdit.get("lastName"), "Last Name should not change");
		Assert.assertEquals(afterEdit.get("age"), beforeEdit.get("age"), "Age should not change");
		Assert.assertEquals(afterEdit.get("email"), beforeEdit.get("email"), "Email should not change");

		logInfo("TC_029 PASSED - Record edited and validated successfully");
	}

	@Test(priority = 30, dataProvider = "validName", dataProviderClass = DataProviders.class, groups = "webtable", description = "TC_030: Verify deleting an existing record from the web table")
	public void verifyDeleteExistingRecord(HashMap<String, String> validName) {

		logInfo("TC_030 STARTED - Verify Delete Existing Record");

		logInfo("Step 1: Clicked on Elements module");

		elem.clickWebTableBtn();
		logInfo("Step 2: Navigated to Web Tables page");

		String firstName = validName.get("firstName");
		logInfo("Test Data - First Name to delete: " + firstName);

		logInfo("Step 3: Fetching existing record before delete");
		Map<String, String> beforeDelete = elem.getRowDataByFirstName(firstName);

		Assert.assertNotNull(beforeDelete, "FAIL: Record not found before delete");
		logInfo("Record found before delete: " + beforeDelete);

		logInfo("Step 4: Clicking Delete icon for record");
		elem.clickOnDelete(firstName);
		logInfo("Delete icon clicked successfully");

		logInfo("Step 5: Verifying record is removed from table");
		boolean recordPresentAfterDelete = elem.isRecordPresent(firstName);

		Assert.assertFalse(recordPresentAfterDelete, "FAIL: Record still present after delete");

		logInfo("Record successfully deleted for First Name: " + firstName);
		logInfo("TC_030 COMPLETED - Verify Delete Existing Record");
	}

	@Test(priority = 31, dataProvider = "preDefinedWebTableData", dataProviderClass = DataProviders.class, groups = "searchBox", description = "TC_031: Verify search functionality with valid first name")
	public void verifySearchWithValidFirstName(HashMap<String, String> searchData) {

		logInfo("TC_031 STARTED - Verify Search Functionality With Valid Name");

		logInfo("Clicked on Elements module");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables page");

		String searchName = searchData.get("firstName");
		logInfo("Search keyword entered: " + searchName);

		elem.enterSearchBox(searchName);
		logInfo("Search text entered in search box");

		logInfo("Verifying filtered table results");

		boolean isOnlyMatchingRecordDisplayed = elem.verifyOnlyMatchingRecordDisplayed(searchName);

		Assert.assertTrue(isOnlyMatchingRecordDisplayed, "FAIL: Table contains records other than searched name");

		logInfo("Only matching record is displayed for search keyword: " + searchName);
		logInfo("TC_031 COMPLETED - Verify Search Functionality With Valid Name");
	}

	@Test(priority = 32, dataProvider = "preDefinedWebTableData", dataProviderClass = DataProviders.class, groups = "searchBox", description = "TC_032: Verify search functionality with valid last name")
	public void verifySearchWithValidLastName(HashMap<String, String> searchData) {

		logInfo("TC_032 STARTED - Verify Search Functionality With Valid Last Name");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables page");

		String searchName = searchData.get("lastName");
		logInfo("Entering search keyword (Last Name): " + searchName);

		elem.enterSearchBox(searchName);
		logInfo("Search keyword entered successfully");

		logInfo("Validating table results for search keyword");

		boolean isOnlyMatchingRecordDisplayed = elem.verifyOnlyMatchingRecordDisplayed(searchName);

		Assert.assertTrue(isOnlyMatchingRecordDisplayed, "FAIL: Table contains records other than searched last name");

		logInfo("Search results validated successfully. Only matching record is displayed");
		logInfo("TC_032 COMPLETED - Verify Search Functionality With Valid Last Name");
	}

	@Test(priority = 33, dataProvider = "preDefinedWebTableData", dataProviderClass = DataProviders.class, groups = "searchBox", description = "TC_033: Verify search functionality with valid email address")
	public void verifySearchWithValidEmail(HashMap<String, String> searchData) {

		logInfo("TC_033 STARTED - Verify Search Functionality With Valid Email");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables page");

		String searchEmail = searchData.get("email");
		logInfo("Entering search keyword (Email): " + searchEmail);

		elem.enterSearchBox(searchEmail);
		logInfo("Search keyword entered successfully");

		logInfo("Validating table results for searched email");

		boolean isOnlyMatchingRecordDisplayed = elem.verifyOnlyMatchingRecordDisplayed(searchEmail);

		Assert.assertTrue(isOnlyMatchingRecordDisplayed, "FAIL: Table contains records other than searched email");

		logInfo("Search results validated successfully. Only matching record is displayed");
		logInfo("TC_033 COMPLETED - Verify Search Functionality With Valid Email");
	}

	@Test(priority = 34, dataProvider = "preDefinedWebTableData", dataProviderClass = DataProviders.class, groups = "searchBox", description = "TC_034: Verify search functionality with valid department name")
	public void verifySearchWithValidDepartment(HashMap<String, String> searchData) {
		logInfo("TC_034 STARTED - Verify Search Functionality With Valid Department");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables page");

		String searchDepartment = searchData.get("department");
		logInfo("Entering search keyword (Department): " + searchDepartment);

		elem.enterSearchBox(searchDepartment);
		logInfo("Search keyword entered successfully");

		logInfo("Validating table results for searched department");

		boolean isOnlyMatchingRecordDisplayed = elem.verifyOnlyMatchingRecordDisplayed(searchDepartment);

		Assert.assertTrue(isOnlyMatchingRecordDisplayed, "FAIL: Table contains records other than searched department");

		logInfo("Search results validated successfully. Only matching record is displayed");
		logInfo("TC_034 COMPLETED - Verify Search Functionality With Valid Department");
	}

	@Test(priority = 35, dataProvider = "registrationFormValidData", dataProviderClass = DataProviders.class, groups = "webtable", description = "TC_035: Verify search with no matching results displays appropriate message")
	public void verifySearchWithNoMatchingResults(HashMap<String, String> input) {

		logInfo("TC_035 STARTED - Verify Search Functionality With No Matching Results");

		elem.clickWebTableBtn();
		logInfo("Navigated to Web Tables page");

		String searchFirstName = input.get("firstName");
		logInfo("Entering search keyword (First Name): " + searchFirstName);

		elem.enterSearchBox(searchFirstName);
		logInfo("Search keyword entered successfully");

		logInfo("Validating that no matching records are displayed");

		Assert.assertTrue(elem.noRowFoundIsDisplayed(),
				"FAIL: 'No rows found' message is not displayed for invalid search");

		logInfo("'No rows found' message is displayed as expected");
		logInfo("TC_035 COMPLETED - Verify Search Functionality With No Matching Results");
	}

	@Test(priority = 36, description = "TC_036: Verify double click functionality on button")
	public void verifyDoubleClickFunctionality() {

		logInfo("TC_036 STARTED - Verify Double Click Functionality");

		elem.clickButtonbtn();
		logInfo("Navigated to Buttons page");

		String doubleClick = elem.doubleClickVerify();
		logInfo("Performed double click action");

		Assert.assertEquals(doubleClick, Constants.DOUBLE_CLICK,
				"FAIL: Double click message is not displayed as expected");

		logInfo("Double click message is displayed as expected");
		logInfo("TC_036 COMPLETED - Verify Double Click Functionality");
	}

	@Test(priority = 37, description = "TC_037: Verify right click functionality on button")
	public void verifyRightClickFunctionality() {

		logInfo("TC_037 STARTED - Verify Right Click Functionality");

		elem.clickButtonbtn();
		logInfo("Navigated to Buttons page");

		String rightClick = elem.rightClickVerify();
		logInfo("Performed right click action");

		Assert.assertEquals(rightClick, Constants.RIGHT_CLICK,
				"FAIL: Right click message is not displayed as expected");

		logInfo("Right click message is displayed as expected");
		logInfo("TC_037 COMPLETED - Verify Right Click Functionality");
	}

	@Test(priority = 38, description = "TC_038: Verify Click Me button functionality")
	public void verifyClickMeFunctionality() {

		logInfo("TC_038 STARTED - Verify Click Me Button Functionality");

		elem.clickButtonbtn();
		logInfo("Navigated to Buttons page");

		String clickMe = elem.clickMeVerify();
		logInfo("Clicked on Click Me button");

		Assert.assertEquals(clickMe, Constants.CLICK_ME, "FAIL: Click Me message is not displayed as expected");

		logInfo("Click Me message is displayed as expected");
		logInfo("TC_038 COMPLETED - Verify Click Me Button Functionality");
	}

	@Test(priority = 39, description = "TC_039: Verify Home link opens in new tab")
	public void verifyLinkOpenInNewTab() {

		logInfo("TC_039 STARTED - Verify Home Link Opens In New Tab");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String title = elem.checkLinkOpenInNewTab();
		logInfo("Switched to new tab and captured title: " + title);

		Assert.assertEquals(title, Constants.HOME_TITLE, "FAIL: Home link is not opened in new tab / title mismatch");

		logInfo("Home link opened in new tab successfully and title matched");
		logInfo("TC_039 COMPLETED - Verify Home Link Opens In New Tab");
	}

	@Test(priority = 40, description = "TC_040: Verify dynamic link opens in new tab")
	public void verifyDynamicLinkOpenInNewTab() {

		logInfo("TC_040 STARTED - Verify Dynamic Link Opens In New Tab");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String title = elem.checkDynamicLinkOpenInNewTab();
		logInfo("Switched to new tab and captured title: " + title);

		Assert.assertEquals(title, Constants.HOME_TITLE,
				"FAIL: Dynamic link is not opened in new tab / title mismatch");

		logInfo("Dynamic link opened in new tab successfully and title matched");
		logInfo("TC_040 COMPLETED - Verify Dynamic Link Opens In New Tab");
	}

	@Test(priority = 41, description = "TC_041: Verify Created link returns 201 response code")
	public void verifyCreatedLinkAndGetResponseCode() {

		logInfo("TC_041 STARTED - Verify Created Link Response");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String response = elem.clickCreatedLinkAndGetResponse();
		logInfo("Created Link Response: " + response);

		Assert.assertTrue(response.contains("201"), "FAIL: Created link status code mismatch");
		Assert.assertTrue(response.contains("Created"), "FAIL: Created link status text mismatch");

		logInfo("Created link response verified successfully");
		logInfo("TC_041 COMPLETED - Verify Created Link Response");
	}

	@Test(priority = 42, description = "TC_042: Verify No Content link returns 204 response code")
	public void verifyNoContentAndGetResponseCode() {

		logInfo("TC_042 STARTED - Verify No Content Link Response");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String response = elem.clickNoContentLinkAndGetResponse();
		logInfo("No Content Link Response: " + response);

		Assert.assertTrue(response.contains("204"), "FAIL: No Content link status code mismatch");
		Assert.assertTrue(response.contains("No Content"), "FAIL: No Content link status text mismatch");

		logInfo("No Content link response verified successfully");
		logInfo("TC_042 COMPLETED - Verify No Content Link Response");
	}

	@Test(priority = 43, description = "TC_043: Verify Moved link returns 301 response code")
	public void verifyMovedAndGetResponseCode() {

		logInfo("TC_043 STARTED - Verify Moved Link Response");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String response = elem.clickMovedLinkAndGetResponse();
		logInfo("Moved Link Response: " + response);

		Assert.assertTrue(response.contains("301"), "FAIL: Moved link status code mismatch");
		Assert.assertTrue(response.contains("Moved Permanently"), "FAIL: Moved link status text mismatch");

		logInfo("Moved link response verified successfully");
		logInfo("TC_043 COMPLETED - Verify Moved Link Response");
	}

	@Test(priority = 44, description = "TC_044: Verify Bad Request link returns 400 response code")
	public void verifyBadRequestAndGetResponseCode() {

		logInfo("TC_044 STARTED - Verify Bad Request Link Response");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String response = elem.clickBadRequestLinkAndGetResponse() ;
		logInfo("Bad Request Link Response: " + response);

		Assert.assertTrue(response.contains("400"), "FAIL: Bad Request link status code mismatch");
		Assert.assertTrue(response.contains("Bad Request"), "FAIL: Bad Request link status text mismatch");

		logInfo("Bad Request link response verified successfully");
		logInfo("TC_044 COMPLETED - Verify Bad Request Link Response");
	}

	@Test(priority = 45, description = "TC_045: Verify Unauthorized link returns 401 response code")
	public void verifyUnAuthorizedAndGetResponseCode() {

		logInfo("TC_045 STARTED - Verify Unauthorized Link Response");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String response = elem.clickUnauthorizedLinkAndGetResponse();
		logInfo("Unauthorized Link Response: " + response);

		Assert.assertTrue(response.contains("401"), "FAIL: Unauthorized link status code mismatch");
		Assert.assertTrue(response.contains("Unauthorized"), "FAIL: Unauthorized link status text mismatch");

		logInfo("Unauthorized link response verified successfully");
		logInfo("TC_045 COMPLETED - Verify Unauthorized Link Response");
	}

	@Test(priority = 46, description = "TC_046: Verify Forbidden link returns 403 response code")
	public void verifyForbiddenAndGetResponseCode() {

		logInfo("TC_046 STARTED - Verify Forbidden Link Response");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String response = elem.clickForbiddenLinkAndGetResponse();
		logInfo("Forbidden Link Response: " + response);

		Assert.assertTrue(response.contains("403"), "FAIL: Forbidden link status code mismatch");
		Assert.assertTrue(response.contains("Forbidden"), "FAIL: Forbidden link status text mismatch");

		logInfo("Forbidden link response verified successfully");
		logInfo("TC_046 COMPLETED - Verify Forbidden Link Response");
	}

	@Test(priority = 47, description = "TC_047: Verify Not Found link returns 404 response code")
	public void verifyNotFoundAndGetResponseCode() {

		logInfo("TC_047 STARTED - Verify Not Found Link Response");

		elem.clickOnLinks();
		logInfo("Navigated to Links page");

		String response = elem.clickNotFoundLinkAndGetResponse();
		logInfo("Not Found Link Response: " + response);

		Assert.assertTrue(response.contains("404"), "FAIL: Not Found link status code mismatch");
		Assert.assertTrue(response.contains("Not Found"), "FAIL: Not Found link status text mismatch");

		logInfo("Not Found link response verified successfully");
		logInfo("TC_047 COMPLETED - Verify Not Found Link Response");
	}

	@Test(priority = 48, description = "TC_048: Verify valid image loads successfully")
	public void verifyValidImage() {

		logInfo("TC_048 STARTED - Verify Valid Image Is Loaded");

		elem.clickBrokenLinkbtn();
		logInfo("Navigated to Broken Links - Images page");

		boolean isImageDisplayed = elem.isValidImageLoaded();
		logInfo("Valid Image Loaded Status: " + isImageDisplayed);

		Assert.assertTrue(isImageDisplayed, "FAIL: Valid image is not loaded properly");

		logInfo("Valid image loaded successfully");
		logInfo("TC_048 COMPLETED - Verify Valid Image Is Loaded");
	}

	@Test(priority = 49, description = "TC_049: Verify broken image does not load")
	public void verifyInValidImage() {

		logInfo("TC_049 STARTED - Verify Broken Image Is Not Loaded");

		elem.clickBrokenLinkbtn();
		logInfo("Navigated to Broken Links - Images page");

		boolean isImageDisplayed = elem.isBrokenImageLoaded();
		logInfo("Broken Image Loaded Status: " + isImageDisplayed);

		Assert.assertFalse(isImageDisplayed, "FAIL: Broken image is loading (Expected broken)");

		logInfo("Broken image validated successfully (not loaded)");
		logInfo("TC_049 COMPLETED - Verify Broken Image Is Not Loaded");
	}

	@Test(priority = 50, description = "TC_050: Verify valid link returns response code less than 400")
	public void verifyValidLinkFunctionality() {

		logInfo("TC_050 STARTED - Verify Valid Link Functionality");

		elem.clickBrokenLinkbtn();
		logInfo("Navigated to Broken Links page");

		int responseCode = elem.checkValidLink();
		logInfo("Fetched response code for Valid Link: " + responseCode);

		Assert.assertTrue(responseCode < 400, "FAIL: Valid Link is Broken! Response Code: " + responseCode);

		logInfo("PASS: Valid Link is working fine. Response Code: " + responseCode);
		logInfo("TC_050 COMPLETED - Verify Valid Link Functionality");
	}

	@Test(priority = 51, description = "TC_051: Verify broken link returns response code 400 or above")
	public void verifyBrokenLinkFunctionality() {

		logInfo("TC_051 STARTED - Verify Broken Link Functionality");

		elem.clickBrokenLinkbtn();
		logInfo("Navigated to Broken Links page");

		int responseCode = elem.checkBrokenLink();
		logInfo("Fetched response code for Broken Link: " + responseCode);

		Assert.assertTrue(responseCode >= 400, "FAIL: Link is NOT broken! Response Code: " + responseCode);

		logInfo("PASS: Broken Link is correctly identified. Response Code: " + responseCode);
		logInfo("TC_051 COMPLETED - Verify Broken Link Functionality");
	}

	@Test(priority = 52, description = "TC_052: Verify file download functionality")
	public void verifyDownloadFunctionality() throws Exception {

		logInfo("TC_052 STARTED - Verify Download Functionality");

		elem.clickOnUploadAndDownload();
		logInfo("Navigated to Upload and Download page");

		elem.clickOnDownloadBtn();
		logInfo("Clicked on Download button");

		String newFileName = elem.renameLatestDownloadedFile(Constants.DOWNLOADPATH, Constants.WAIT_TIME);
		logInfo("Downloaded file renamed to: " + newFileName);

		Assert.assertNotNull(newFileName, "FAIL: File not downloaded / rename failed");

		boolean filePresent = elem.isFileExists(Constants.DOWNLOADPATH, newFileName);
		logInfo("File present in downloads folder: " + filePresent);

		Assert.assertTrue(filePresent, "FAIL: Renamed file not found in downloads folder");

		logInfo("File downloaded and verified successfully");
		logInfo("TC_052 COMPLETED - Verify Download Functionality");
	}

	@Test(priority = 53, description = "TC_053: Verify file upload functionality")
	public void verifyUploadFileFunctionality() {

		logInfo("TC_053 STARTED - Verify Upload File Functionality");

		elem.clickOnUploadAndDownload();
		logInfo("Navigated to Upload and Download page");

		logInfo("Uploading file from path: " + Constants.UPLOADFILE);

		String fileUploadStatus = elem.uploadFile(Constants.UPLOADFILE);
		logInfo("Uploaded File Status Message: " + fileUploadStatus);
		Assert.assertTrue(fileUploadStatus.contains(Constants.UPLOADEDFILE),"FAIL: Uploaded file name is not displayed correctly");
		logInfo("File uploaded successfully and file name verified");
		logInfo("TC_053 COMPLETED - Verify Upload File Functionality");
	}

	@Test(priority = 54, description = "TC_054: Verify random ID text is displayed on dynamic properties page")
	public void verifyRandomIdText() {

		logInfo("TC_054 STARTED - Verify Random Id Text");

		elem.clickDynamicPropertiesBtn();
		logInfo("Navigated to Dynamic Properties page");

		boolean status = elem.verifyRandomIdTextDisplayed();
		logInfo("Random Id Text Displayed: " + status);

		Assert.assertTrue(status, "FAIL: Random Id text is not displayed");

		logInfo("Random Id text verified successfully");
		logInfo("TC_054 COMPLETED - Verify Random Id Text");
	}

	@Test(priority = 55, description = "TC_055: Verify button becomes enabled after 5 seconds")
	public void verifyEnableAfter5Seconds() {

		logInfo("TC_055 STARTED - Verify Enable After 5 Seconds Functionality");

		elem.clickDynamicPropertiesBtn();
		logInfo("Navigated to Dynamic Properties page");

		boolean result = elem.verifyEnableAfter5Seconds();
		logInfo("Enable After 5 Seconds Result: " + result);

		Assert.assertTrue(result, "FAIL: Button did not become enabled after 5 seconds");

		logInfo("Enable After 5 Seconds verified successfully");
		logInfo("TC_055 COMPLETED - Verify Enable After 5 Seconds Functionality");
	}

	@Test(priority = 56, description = "TC_056: Verify button color changes dynamically")
	public void verifyColorChangeButton() {

		logInfo("TC_056 STARTED - Verify Color Change Functionality");

		elem.clickDynamicPropertiesBtn();
		logInfo("Navigated to Dynamic Properties page");

		boolean changed = elem.verifyColorChange();
		logInfo("Color Change Status: " + changed);

		Assert.assertTrue(changed, "FAIL: Button color did not change");

		logInfo("Color change verified successfully");
		logInfo("TC_056 COMPLETED - Verify Color Change Functionality");
	}

	@Test(priority = 57, description = "TC_057: Verify button becomes visible after 5 seconds")
	public void verifyVisibleAfter5Seconds() {

		logInfo("TC_057 STARTED - Verify Visible After 5 Seconds Functionality");

		elem.clickDynamicPropertiesBtn();
		logInfo("Navigated to Dynamic Properties page");

		boolean visible = elem.verifyVisibleAfter5Seconds();
		logInfo("Visible After 5 Seconds Button Displayed: " + visible);

		Assert.assertTrue(visible, "FAIL: Visible After 5 Seconds button is not displayed");

		logInfo("Visible After 5 Seconds verified successfully");
		logInfo("TC_057 COMPLETED - Verify Visible After 5 Seconds Functionality");
	}

}