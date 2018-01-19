package com.google.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GenericMethods;

public class AboutPageObjects {
	
	//private static GenericMethods gm;
	private static WebElement element;

/*	public AboutPageObjects(WebDriver driver){
		gm = new GenericMethods(driver);
	}*/
	
	public static WebElement Tab_OurLatest(WebDriver driver){
		element = GenericMethods.getElement(driver, "Our latest", "linktext");
		return element;
	}
	
	public static WebElement Tab_OurCompany(WebDriver driver){
		element = GenericMethods.getElement(driver, "Our company", "linktext");
		return element;
	}
	
	public static WebElement Tab_OurCommitments(WebDriver driver){
		element = GenericMethods.getElement(driver, "Our commitments", "linktext");
		return element;
	}
	
	public static WebElement Tab_OurProducts(WebDriver driver){
		element = GenericMethods.getElement(driver, "Our productss", "linktext");
		return element;
	}

}
