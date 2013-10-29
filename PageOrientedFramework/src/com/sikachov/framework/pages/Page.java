package com.sikachov.framework.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	public WebDriver driver;
	
	
	private String link = "";
	
	public abstract boolean isOnThisPage();
	
	public abstract void tryToOpen();
	
	public boolean isElementPresent(By by){
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		boolean res = driver.findElement(by).getSize().height > 0;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return res;
	}
	
	public WebDriverWait wait_(){
		return new WebDriverWait(driver, 10);
	}
	
	public void goToMainPage(){
		
	}
	
	

}
