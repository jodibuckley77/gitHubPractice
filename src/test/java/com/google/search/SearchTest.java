package com.google.search;

import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.LaunchBrowser;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class SearchTest {
  private WebDriver driver;
  private WebElement element;
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = LaunchBrowser.launchChrome();
  }

@Test
  public void searchBharath() {
	
	GoogleMainPageActions.changeToEnglishLang(driver);
	GoogleMainPageActions.enterSearchString(driver, "Bharath");
	GoogleMainPageActions.clickOnGoogleSearchBtn(driver);
	element = driver.findElement(By.name("q"));
	String value = element.getAttribute("value");
	Assert.assertEquals("Bharath", value);
  }

@Test
public void searchEmaratech() {
	
	GoogleMainPageActions.changeToEnglishLang(driver);
	GoogleMainPageActions.enterSearchString(driver, "Emaratech");
	GoogleMainPageActions.clickOnGoogleSearchBtn(driver);
	element = driver.findElement(By.name("q"));
	String value = element.getAttribute("value");
	Assert.assertEquals("Emaratech", value);
}

@Test
public void clickProductsTab() {
	
	GoogleMainPageActions.changeToEnglishLang(driver);
	GoogleMainPageActions.clickOnAboutLink(driver);
	AboutPageActions.clickOnOurProductsTab(driver);
}


  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
