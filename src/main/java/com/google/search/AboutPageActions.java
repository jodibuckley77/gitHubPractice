package com.google.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.search.AboutPageObjects;

public class AboutPageActions {
	
	//private AboutPageObjects aboutPageObj;
	private static WebElement element;

/*	public AboutPageActions(WebDriver driver){
		aboutPageObj = new AboutPageObjects(driver);
	}*/
	
	public static void clickOnOurCompanyTab(WebDriver driver){
		element = AboutPageObjects.Tab_OurCompany(driver);
		element.click();
	}
	
	public static void clickOnOurCommitmentTab(WebDriver driver){
		element = AboutPageObjects.Tab_OurCommitments(driver);
		element.click();
	}
	
	public static void clickOnOurProductsTab(WebDriver driver){
		element = AboutPageObjects.Tab_OurProducts(driver);
		element.click();
	}

}
