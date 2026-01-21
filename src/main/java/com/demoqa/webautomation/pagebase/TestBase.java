package com.demoqa.webautomation.pagebase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.demoqa.webautomation.utilities.ConfigReader;
import com.demoqa.webautomation.utilities.ExtentReportManager;

public class TestBase {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public Logger logger = LogManager.getLogger(TestBase.class);

	// Get current WebDriver instance
	public static WebDriver getDriver() {
		return driver.get();
	}

	// Set WebDriver for the current thread
	private static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	// ================================================================
	// WebDriver Setup Section
	// ================================================================
	@Parameters({ "os", "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("windows") String os,
            @Optional("chrome") String browser) throws IOException {

		disableSeleniumCdpWarnings();
		// Get URL from ConfigReader
		String url = ConfigReader.getUrl();

		// Get execution environment from ConfigReader
		String executionEnv = ConfigReader.getProperty("execution_env");

		if (executionEnv != null && executionEnv.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// OS setup
			if (os.equalsIgnoreCase("windows"))
				capabilities.setPlatform(Platform.WIN11);
			else if (os.equalsIgnoreCase("linux"))
				capabilities.setPlatform(Platform.LINUX);
			else
				throw new IllegalArgumentException("Unsupported OS: " + os);

			// Browser setup
			if (browser.equalsIgnoreCase("chrome"))
				capabilities.setBrowserName("chrome");
			else if (browser.equalsIgnoreCase("edge"))
				capabilities.setBrowserName("MicrosoftEdge");
			else if (browser.equalsIgnoreCase("firefox"))
				capabilities.setBrowserName("firefox");
			else
				throw new IllegalArgumentException("Unsupported Browser: " + browser);

			WebDriver remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
			setDriver(remoteDriver);

		} else { // Local execution
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				configureDownloadDir(options);
				configureChromeOptions(options);

				// Add headless mode if enabled
				if (ConfigReader.isHeadless()) {
					options.addArguments("--headless=new");
				}

				setDriver(new ChromeDriver(options));

			} else if (browser.equalsIgnoreCase("edge")) {
				// Optional: Only required if EdgeDriver is not in PATH
				// System.setProperty("webdriver.edge.driver",
				// "C:\\WebDrivers\\msedgedriver.exe");

				EdgeOptions options = new EdgeOptions();
				configureDownloadDir(options);

				// Add headless mode if enabled
				if (ConfigReader.isHeadless()) {
					options.addArguments("--headless=new");
				}

				setDriver(new EdgeDriver(options));

			} else if (browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions options = new FirefoxOptions();

				// Add headless mode if enabled
				if (ConfigReader.isHeadless()) {
					options.addArguments("--headless");
				}

				setDriver(new FirefoxDriver(options));
			} else {
				throw new IllegalArgumentException("No matching browser: " + browser);
			}
		}

		// WebDriver config using ConfigReader
		if (ConfigReader.shouldMaximize()) {
			getDriver().manage().window().maximize();
		}

		// Use timeouts from ConfigReader
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getTimeout()));
		// getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));

		getDriver().get(url);
	}

	// ================================================================
	// Browser Configuration Helpers
	// ================================================================
	private void configureDownloadDir(ChromeOptions options) {
		String downloadDir = System.getProperty("user.dir") + File.separator + "downloads";
		File folder = new File(downloadDir);
		if (!folder.exists())
			folder.mkdirs();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadDir);
		prefs.put("download.prompt_for_download", false);
		prefs.put("safebrowsing.enabled", true);
		options.setExperimentalOption("prefs", prefs);
	}

	private void configureDownloadDir(EdgeOptions options) {
		String downloadDir = System.getProperty("user.dir") + File.separator + "downloads";
		File folder = new File(downloadDir);
		if (!folder.exists())
			folder.mkdirs();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadDir);
		prefs.put("download.prompt_for_download", false);
		prefs.put("safebrowsing.enabled", "false");
		options.setExperimentalOption("prefs", prefs);
	}

	private void configureChromeOptions(ChromeOptions options) {

		// uBlock Origin extension
		File uBlockExtension = new File("C:\\Users\\SANJAY\\Downloads\\uBlock-Origin-Chrome-Web-Store.crx");

		if (uBlockExtension.exists()) {
			options.addExtensions(uBlockExtension);
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		} else {
			throw new RuntimeException("uBlock extension file not found");
		}
	}

	// ================================================================
	// Teardown
	// ================================================================
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove(); // Prevent memory leaks
		}
	}

	// ================================================================
	// Screenshot Utility
	// ================================================================
	public static String captureScreen(String testName) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots/";
		String screenshotPath = screenshotDir + testName + "_" + timestamp + ".png";

		try {
			// Create directory if it doesn't exist
			File dir = new File(screenshotDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			// Take screenshot and copy it to target location
			File source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenshotPath));

			// Return a relative path for Extent report
			return "./screenshots/" + testName + "_" + timestamp + ".png";

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Optional: Disable Selenium CDP warnings (uses java.util.logging)
	private void disableSeleniumCdpWarnings() {
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.SEVERE);
		java.util.logging.Logger.getLogger("org.openqa.selenium.devtools").setLevel(java.util.logging.Level.SEVERE);
		java.util.logging.Logger.getLogger("org.openqa.selenium.chromium").setLevel(java.util.logging.Level.SEVERE);
	}
	
	public void logInfo(String message) {
	    logger.info(message); // console log

	    if (ExtentReportManager.getTest() != null) {
	        ExtentReportManager.getTest().info(message); // extent log
	    }
	}

}
