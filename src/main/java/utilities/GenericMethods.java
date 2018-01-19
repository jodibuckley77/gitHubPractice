package utilities;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	/*
	 * public GenericMethods(WebDriver driver) { this.driver = driver; }
	 */

	private static Logger log = LogManager.getLogger(GenericMethods.class.getName());

	public static WebElement getElement(WebDriver driver, String locator, String type) {
		type = type.toLowerCase();

		if (type.equals("id")) {
			log.info("Element found with Id: " + locator);
			return driver.findElement(By.id(locator));
		}

		else if (type.equals("name")) {
			log.info("Element found with name: " + locator);
			return driver.findElement(By.name(locator));
		}

		else if (type.equals("xpath")) {
			log.info("Element found with xpath: " + locator);
			return driver.findElement(By.xpath(locator));

		} else if (type.equals("linktext")) {
			log.info("Element found with linktext: " + locator);
			return driver.findElement(By.linkText(locator));

		} else if (type.equals("partiallinktext")) {
			log.info("Element found with partial link text: " + locator);
			return driver.findElement(By.partialLinkText(locator));
		}

		else if (type.equals("css")) {
			log.info("Element found with css selector: " + locator);
			return driver.findElement(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			log.info("Element found with class name: " + locator);
			return driver.findElement(By.className(locator));
		} else if (type.equals("tagname")) {
			log.info("Element found with class name: " + locator);
			return driver.findElement(By.tagName(locator));
		} else
			log.info("locator type is not supported");
		return null;
	}

	public static List<WebElement> getElementList(WebDriver driver, String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();

		if (type.equals("id")) {
			elementList = driver.findElements(By.id(locator));
		} else if (type.equals("name")) {
			elementList = driver.findElements(By.name(locator));
		}

		else if (type.equals("xpath")) {
			elementList = driver.findElements(By.xpath(locator));

		} else if (type.equals("linktext")) {
			elementList = driver.findElements(By.linkText(locator));

		} else if (type.equals("partiallinktext")) {
			elementList = driver.findElements(By.partialLinkText(locator));
		}

		else if (type.equals("css")) {
			elementList = driver.findElements(By.cssSelector(locator));
		} else if (type.equals("classname")) {
			elementList = driver.findElements(By.className(locator));
		} else if (type.equals("tagname")) {
			elementList = driver.findElements(By.tagName(locator));
		}

		else
			log.info("locator type is not supported");

		if (elementList.isEmpty()) {
			log.error("Element not found with " + type + ": " + locator);
		} else {
			log.info("Element found with " + type + ": " + locator);
		}

		return elementList;
	}

	public static Boolean isElementPresent(WebDriver driver, String locator, String type) {
		List<WebElement> elementList = getElementList(driver, locator, type);
		if (elementList.size() > 0) {
			return true;
		} else
			return false;

	}

	public static int NumberOfElementsPresent(WebDriver driver, String locator, String type) {
		List<WebElement> elementList = getElementList(driver, locator, type);
		int size = elementList.size();
		return size;
	}

	public static List<WebElement> clickableLinks(WebDriver driver) {

		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));

		for (WebElement e : elements) {
			if (e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		System.out.println("Total number of Clickable links present on the page: " + linksToClick.size());
		return linksToClick;
	}

	public static String linkStatus(URL url) {
		// http://download.java.net/jdk7/archive/b123/docs/api/java/net/HttpURLConnection.html#getResponseMessage%28%29
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static void sleep(int sec) {

		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static WebElement waitTillVisibilityOfElement(WebDriver driver, By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}

	public static WebElement waitTillElementIsClickable(WebDriver driver, By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;

	}

	public static Boolean waitTillURLContains(WebDriver driver, String urlString, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		Boolean elementBooleanValue = wait.until(ExpectedConditions.urlContains(urlString));
		return elementBooleanValue;

	}

	public static void selectDateFromCalenderPopup(WebDriver driver, String locator, String dateValue) {
		List<WebElement> calMonth = driver.findElements(By.xpath(locator));
		List<WebElement> validDates = new ArrayList<WebElement>();

		for (WebElement e : calMonth) {
			String dateAttribute = e.getAttribute("aria-hidden");

			if (dateAttribute != "true" || dateAttribute == null) {
				validDates.add(e);
			}
		}

		for (WebElement date : validDates) {
			if (date.getText().equals(dateValue)) {
				date.click();
				break;

			}
		}

	}
	
	public static void takeScreenShotNow(WebDriver driver, String filePath) {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		GenericMethods time = new GenericMethods();
		try {

			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdir();
			}

			String path = filePath + "\\Image_(" + time.getTime() + ").png";
			FileUtils.copyFile(sourceFile, new File(path));
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Error in taking screenshot.");
		}
	}
	
	public String getTime() {

		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH_mm_ss");
		return sdf.format(cal.getTime());
	}
}
