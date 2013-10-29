package com.sikachov.framework.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.factories.MyPageFactory;

public class MainPage extends Page {

	private static final String PRODUCT_LINK_TEXT = "Вентиляторы";
	@FindBy(css = ".banner_hit")
	public WebElement banner;
	@FindBy(linkText = PRODUCT_LINK_TEXT)
	public WebElement productLink;

	@Override
	public void tryToOpen() {
		throw new ElementNotVisibleException(
				"Главная страница не открылась или проверочного элемента banner нет.");
	}

	@Override
	public boolean isOnThisPage() {
		if (banner.isDisplayed())
			return true;
		return false;
	}

	public void goToProductPage() {
		productLink.click();
	}

}
