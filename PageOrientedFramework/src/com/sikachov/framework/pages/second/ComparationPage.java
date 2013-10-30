package com.sikachov.framework.pages.second;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.pages.Page;
import com.sikachov.framework.pages.ProductPage;

public class ComparationPage extends Page {

	private String isOnElement = "//html/body/div[2]/div[3]/div/div[4]/div[2]/div/div[2]/table/tbody/tr/th/div/span/a";
	int productNum = 2;
	
	@FindBy(className = "")
	List<WebElement> sameParams;
	@FindBy(className = "different")
	List<WebElement> differentParams;

	@Override
	public boolean isOnThisPage() {
		try {
			driver.findElement(By.xpath(isOnElement));
			return true;
		} catch (Exception e) {
			System.out.println("FFFF");
			return false;
		}

	}

	@Override
	public void tryToOpen() {
		ProductPage p = MyPageFactory.getPage(driver, ProductPage.class);
		List<WebElement> l = p.getWebElementProducts(productNum);
		for(WebElement w : l){
			w.findElement(By.className("compare_add_link")).click();
		}
		l.get(0).findElement(By.className("head-compare-link")).click();
	}

}
