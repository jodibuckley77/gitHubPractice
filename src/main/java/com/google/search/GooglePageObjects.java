package com.google.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GenericMethods;

public class GooglePageObjects {

	private static WebElement element;
	//private static GenericMethods gm;
	
/*		public GooglePageObjects(WebDriver driver){
		gm = new GenericMethods(driver);
		
	}*/

	public static WebElement googleSearchBtn(WebDriver driver) {
		element = GenericMethods.getElement(driver, "//input[@value='Google Search']", "xpath");
		return element;
	}

	public static WebElement iAmFeelingLuckyBtn(WebDriver driver) {
		element = GenericMethods.getElement(driver, "//input[@name='btnI']", "XPATH");
		return element;
	}
	
	public static WebElement searchTextField(WebDriver driver){
		element = GenericMethods.getElement(driver, "q", "name");
		return element;
	}
	
	public static WebElement englishVersionLink(WebDriver driver){
		element = GenericMethods.getElement(driver, "English", "linkText");
		return element;
	}
	
	public static WebElement aboutLink(WebDriver driver){
		element = GenericMethods.getElement(driver, "About", "linkText");
		return element;
	}
	

}
