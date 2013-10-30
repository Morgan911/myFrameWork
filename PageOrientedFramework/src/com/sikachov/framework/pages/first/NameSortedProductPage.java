package com.sikachov.framework.pages.first;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.pages.ProductPage;

public class NameSortedProductPage extends ProductPage {
	
	@FindBy(className = "span_active")
	WebElement activeLink;

	@Override
	public void tryToOpen() {
		MyPageFactory.getPage(driver, ProductPage.class).sortByName();
	}
	
	
	@Override
	public boolean isOnThisPage() {
		try {
			if(activeLink.getText().contains("название"))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}
}
