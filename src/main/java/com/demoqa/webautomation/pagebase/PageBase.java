package com.demoqa.webautomation.pagebase;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoqa.webautomation.utilities.WaitHelper;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * Base class for all page objects. Contains reusable Selenium helper methods
 * and wait logic.
 */
public class PageBase {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WaitHelper waitHelper;
	protected static final Logger logger = LogManager.getLogger(PageBase.class);

	public PageBase(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.waitHelper = new WaitHelper(driver);
		PageFactory.initElements(driver, this);
	}

	/** Wait for element visibility */
	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		waitHelper.waitForElementToBeVisible(element);
	}

	public void waitForInVisibility(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
		waitHelper.waitForElementToBeVisible(element);
	}

	public void waitForVisibility(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

//    public void waitForInVisibility(By loactor) {
//    	wait.until(ExpectedConditions.invisibilityOfElementLocated(loactor));
//    }

	public boolean waitForInVisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/** Wait for element to be clickable and click */
	public void waitForElementToBeClickableAndClick(WebElement element) {
		waitHelper.waitForElementToBeClickable(element);
		element.click();
	}

	/** Generic click method */
	public void click(WebElement element) {
		try {
			waitHelper.waitForElementToBeClickable(element);
			element.click();
		} catch (Exception e) {
			throw e;
		}
	}

	protected boolean isDisplayed(WebElement element) {
		try {
			waitHelper.waitForElementToBeVisible(element);
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			return false;
		}
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	protected boolean isSelected(WebElement element) {
		try {
			boolean selected = element.isSelected();

			return selected;
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean isSelected(By locator) {
		try {
			boolean selected = driver.findElement(locator).isSelected();
			return selected;
		} catch (Exception e) {
			return false;
		}
	}

	protected String getText(WebElement element) {
		try {
			waitHelper.waitForElementToBeVisible(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			throw e;
		}
	}

	/** Enter text into a field */
	public void enterText(WebElement element, String text) {
		try {
			waitHelper.waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			throw e;
		}
	}

	/** Select from dropdown by visible text */
	public void selectByVisibleText(WebElement dropdown, String visibleText) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}

	/** Wait until alert appears */
	public void waitForAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/** Accept alert if present */
	public void acceptAlert() {
		try {
			waitForAlert();
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("No alert present.");
		}
	}

	/** Scroll to element and click */
	public void scrollAndClick(WebElement element) {
	    try {
	        // Scroll element to center (avoids sticky footer ads)
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
	                element
	        );

	        wait.until(ExpectedConditions.visibilityOf(element));
	        wait.until(ExpectedConditions.elementToBeClickable(element));

	        try {
	            element.click(); // normal click
	        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
	            // fallback JS click if intercepted by ads/overlay
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	        }

	    } catch (Exception e) {
	        throw new RuntimeException("Failed to click element: " + e.getMessage(), e);
	    }
	}


	public void scrollAndClick(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();

		} catch (Exception e) {
			System.out.println("Error while scrolling/clicking: " + e.getMessage());
		}
	}

	/** Click element using JavaScript */
	public void clickUsingJS(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("JS click failed for: " + element);
			e.printStackTrace();
		}
	}

	/** Wait for full page load */
	public void waitForPageLoad() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}

	/** Format date from dd-MM-yyyy to yyyy-MM-dd */
	public String formatDate(String date) throws ParseException {
		SimpleDateFormat input = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate = input.parse(date);
		return output.format(parsedDate);
	}

	public static String getTextAfterColon(String text) {
		if (text == null || !text.contains(":")) {
			return "";
		}
		return text.split(":", 2)[1].trim();
	}

	/** Get current page URL */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/** Navigate back */
	public void navigateBack() {
		driver.navigate().back();
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public Integer brokenLinkValidator(WebElement a) {

		String link = a.getDomProperty("href");

		if (link == null || link.isEmpty()) {
			return -1; // invalid link
		}

		try {
			URL url = new URL(link);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.connect();

			return con.getResponseCode(); // ✅ return actual response code

		} catch (Exception e) {
			return 0; // exception occurred
		}
	}

	public String handleWindow(WebElement element) {
		String parentId = driver.getWindowHandle();
		scrollAndClick(element);
		Set<String> windowIds = driver.getWindowHandles();
		for (String id : windowIds) {
			if (!id.equals(parentId)) {
				driver.switchTo().window(id);
				break;
			}
		}

		String title = driver.getTitle();
		return title;

	}

	public void cleanDownloadFolder(String downloadPath) {

		File folder = new File(downloadPath);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				String name = file.getName();

				if (name.endsWith(".crdownload") || name.endsWith(".tmp")) {
					file.delete();
				}
			}
		}
	}

	// ✅ Rename latest downloaded file with random name
	public  String renameLatestDownloadedFile(String downloadPath, int waitSeconds) throws Exception {

		File folder = new File(downloadPath);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		File latestFile = null;
		long latestModified = 0;

		for (int i = 0; i < waitSeconds; i++) {

			File[] files = folder.listFiles();
			if (files != null) {
				for (File file : files) {

					String name = file.getName();

					// ✅ ignore temp + in-progress + already renamed files
					if (name.endsWith(".crdownload") || name.endsWith(".tmp") || name.startsWith("Downloaded_")) {
						continue;
					}

					if (file.isFile() && file.length() > 0 && file.lastModified() > latestModified) {
						latestModified = file.lastModified();
						latestFile = file;
					}
				}
			}

			if (latestFile != null)
				break;

			Thread.sleep(1000);
		}

		if (latestFile == null)
			return null;

		String oldName = latestFile.getName();
		String extension = "";

		int dotIndex = oldName.lastIndexOf(".");
		if (dotIndex != -1) {
			extension = oldName.substring(dotIndex);
		}

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String randomName = "Downloaded_" + timeStamp + extension;


		Path source = latestFile.toPath();
		Path target = new File(downloadPath + File.separator + randomName).toPath();

		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

		return randomName;
	}

	// ✅ Verify file exists
	public  boolean isFileExists(String folderPath, String fileName) {
		File file = new File(folderPath + File.separator + fileName);
		return file.exists();
	}
}
