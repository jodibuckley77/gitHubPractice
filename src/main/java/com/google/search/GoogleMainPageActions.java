package com.google.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.search.GooglePageObjects;

public class GoogleMainPageActions {
	
	private static WebElement element;
	//private GooglePageObjects gp;
	
/*	public GoogleMainPageActions(WebDriver driver) {
		gp = new GooglePageObjects(driver);
	}*/
	
	public static void clickOnGoogleSearchBtn(WebDriver driver){
		element = GooglePageObjects.googleSearchBtn(driver);
		element.click();
	}
	
	public static void clickOnIAmFeelingLuckyBtn(WebDriver driver){
		element = GooglePageObjects.iAmFeelingLuckyBtn(driver);
		element.click();
		
	}
	
	public static void enterSearchString(WebDriver driver, String searchString){
		element = GooglePageObjects.searchTextField(driver);
		element.sendKeys(searchString);
	}

	public static void changeToEnglishLang(WebDriver driver){
		element = GooglePageObjects.englishVersionLink(driver);
		element.click();
		
	}
	
	public static void clickOnAboutLink(WebDriver driver){
		element = GooglePageObjects.aboutLink(driver);
		element.click();
	}
}
