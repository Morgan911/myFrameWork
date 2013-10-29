package com.sikachov.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.IsElementPresent;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.objects.Product;

public class ProductPage extends Page{
	
	private static final String sortByNameLink = "название"; 
	private static final String sortByPriceLink = "цена"; 
	private static final String pageSubHeader = "page-subheader"; 
	
	@FindBy(linkText = sortByNameLink)
	WebElement sortByName;
	@FindBy(linkText = sortByPriceLink)
	WebElement sortByPrice;
	@FindBy(id = pageSubHeader)
	WebElement subHeader;
	@FindBy(className = "item")
	List<WebElement> products;
	
	

	@Override
	public void tryToOpen() {
		MyPageFactory.getPage(driver, MainPage.class).goToProductPage();
	}

	@Override
	public boolean isOnThisPage() {
		if(isElementPresent(By.id("page-subheader"))){
			return true;
		}
		
		return false;
	}
		
	
	public List<Product> getProducts(){ 
		List<Product> prods = new ArrayList<Product>();
		for(WebElement product: products){
			prods.add(convertRowToProduct(product));
		}
		return prods;
	}
	
	private Product convertRowToProduct(WebElement element){
		String name = element.findElement(By.className("name")).getText();
		String price = element.findElement(By.className("price")).getText();
		System.out.println(name + " - " + price);
		Product tmp = new Product(name, price);
		return tmp;
	}
}
