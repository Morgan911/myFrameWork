package com.sikachov.framework.pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.factories.MyPageFactory;

public class MainPage extends Page {

	private static final String PRODUCT_LINK_TEXT = "�����������";
	@FindBy(css = ".banner_hit")
	public WebElement banner;
	@FindBy(linkText = PRODUCT_LINK_TEXT)
	public WebElement productLink;

	@Override
	public void tryToOpen() {
		throw new ElementNotVisibleException(
				"������� �������� �� ��������� ��� ������������ �������� banner ���.");
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
