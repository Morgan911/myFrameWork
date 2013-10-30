package com.sikachov.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.factories.MyPageFactory;

public class MainPage extends Page {

	private static final String PRODUCT_LINK_TEXT = "Микроволновки";
	@FindBy(css = ".banner_hit")
	public WebElement banner;
	@FindBy(linkText = PRODUCT_LINK_TEXT)
	public WebElement productLink;

	@Override
	public void tryToOpen() {
		
	}

	@Override
	public boolean isOnThisPage() {
		try{
			driver.findElement(By.cssSelector(".banner_hit"));
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public void goToProductPage() {
		productLink.click();
	}

}
