package com.demoqa.webautomation.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Constants {

	// Application URLs
	public static final String BASE_URL = "https://demoqa.com/";
	public static final String LOGIN_URL = BASE_URL;

	// Timeouts (in seconds)
	public static final int IMPLICIT_WAIT = 10;
	public static final int EXPLICIT_WAIT = 20;
	public static final int PAGE_LOAD_TIMEOUT = 30;

	// Test Data
	public static final String VALID_USERNAME = "Admin";
	public static final String VALID_PASSWORD = "admin123";

	// Case sensitive
	public static final String UPPER_CASE_USERNAME = "ADMIN";

	// Login Header
	public static final String LOGIN_HEADER = "Login";
	// File Paths
	public static final String CONFIG_FILE_PATH = "src/main/resources/config/config.properties";
	public static final String TEST_DATA_PATH = "src/main/resources/testdata/";
	public static final String SCREENSHOT_PATH = "reports/screenshots/";
	public static final String EXTENT_REPORT_PATH = "reports/extent-reports/ExtentReport.html";
	public static final String LOG_FILE_PATH = "logs/application.log";

	// Browser Types
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String EDGE = "edge";

	// Error Messages
	public static final String LOGIN_ERROR_MESSAGE = "Invalid credentials";
	public static final String REQUIRED_FIELD_ERROR = "Required";

	// Titles Messages
	public static final String HOME_TITLE = "DEMOQA";
	public static final String ELEMENT_TITLE = "Elements";
	public static final String FORMS_TITLE = "Forms";
	public static final String ALERTS_TITLE = "Alerts, Frame & Windows";
	public static final String WIDGETS_TITLE = "Widgets";
	public static final String INTERACTIONS_TITLE = "Interactions";
	public static final String BOOK_STORE_TITLE = "Book Store Application";
	public static final String PASSWORD_CHANGED_SUCCESS = "Successfully Saved";
	public static final String FOOTER_TEXT = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";

	// Toggles Elements
	public static final String HOME = "Home";

	public static final String DESKTOP = "Desktop";
	public static final String NOTES = "Notes";
	public static final String COMMANDS = "Commands";

	public static final String DOCUMENTS = "Documents";
	public static final String WORKSPACE = "WorkSpace";
	public static final String REACT = "React";
	public static final String ANGULAR = "Angular";
	public static final String VEU = "Veu";

	public static final String OFFICE = "Office";
	public static final String PUBLIC = "Public";
	public static final String PRIVATE = "Private";
	public static final String CLASSIFIED = "Classified";
	public static final String GENERAL = "General";

	public static final String DOWNLOADS = "Downloads";
	public static final String WORD_FILE = "Word File.doc";
	public static final String EXCEL_FILE = "Excel File.doc";

	// Check-Box Names
	public static final List<String> CHECKBOX_NAMES = new ArrayList<>();

	static {
		CHECKBOX_NAMES.add("Home");
		CHECKBOX_NAMES.add("Desktop");
		CHECKBOX_NAMES.add("Notes");
		CHECKBOX_NAMES.add("Commands");

		CHECKBOX_NAMES.add("Documents");
		CHECKBOX_NAMES.add("WorkSpace");
		CHECKBOX_NAMES.add("React");
		CHECKBOX_NAMES.add("Angular");
		CHECKBOX_NAMES.add("Veu");

		CHECKBOX_NAMES.add("Office");
		CHECKBOX_NAMES.add("Public");
		CHECKBOX_NAMES.add("Private");
		CHECKBOX_NAMES.add("Classified");
		CHECKBOX_NAMES.add("General");

		CHECKBOX_NAMES.add("Downloads");
		CHECKBOX_NAMES.add("WordFile");
		CHECKBOX_NAMES.add("ExcelFile");
	}

	// Radio-Btn Names
	public static final String YES_RADIO = "Yes";
	public static final String IMPRESSIVE_RADIO = "Impressive";

	// Buttons Names
	public static final String DOUBLE_CLICK = "You have done a double click";
	public static final String RIGHT_CLICK = "You have done a right click";
	public static final String CLICK_ME = "You have done a dynamic click";
	
	//Download Directory
	public static final String DOWNLOADPATH=System.getProperty("user.dir") + File.separator + "downloads";
	
	public static final String UPLOADFILE="D:\\QA\\DemoQA\\downloads\\Downloaded_20260118_193135.jpeg";
	public static final String UPLOADEDFILE="Downloaded_20260118_193135.jpeg";
	
	public static final int WAIT_TIME=20;

	// Private constructor to prevent instantiation
	private Constants() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
}
