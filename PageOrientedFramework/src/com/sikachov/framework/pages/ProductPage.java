package com.sikachov.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.objects.Product;

public class ProductPage extends Page {

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
	@FindBy(className = "pager-last")
	public WebElement lastPage;
	@FindBy(xpath = "//div[2]/div/div/ul/li[2]/a")
	public WebElement next;

	int last;

	public ProductPage() {
		
	}

	public int parsePageNum(WebElement e){
		String s = e.getText();
		return Integer.parseInt(s);
	}

	@Override
	public void tryToOpen() {
		MyPageFactory.getPage(driver, MainPage.class).goToProductPage();
	}

	@Override
	public boolean isOnThisPage() {
		try {
			driver.findElement(By
					.xpath("//html/body/div[2]/div[3]/div/div[2]/h1"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
 
	public List<Product> getProducts(int k) {
		List<Product> prods = new ArrayList<Product>();
		int i = 1;
		 last = parsePageNum(lastPage);
		while (i <= k) {
			for (WebElement product : products) {
				prods.add(convertRowToProduct(product));
			}
			if(i < last)
				next.click();
			i++;
		}
		return prods;
	}
	
	public List<Product> getProducts() {
		return this.getProducts(last);
	}
	//Elements without converting to Product type
	public List<WebElement> getWebElementProducts(int num){
		List<WebElement> res = new ArrayList<WebElement>();
		for(int i = 0; i < num; i++){
			res.add(products.get(i));
		}
		return res;
		
	}

	private Product convertRowToProduct(WebElement element) {
		String name = element.findElement(By.className("name")).getText();
		String price = element.findElement(By.className("price")).getText();
		price = price.replace(" ", "");
		price = price.substring(0,price.indexOf("г"));
		Double dprice = Double.parseDouble(price);
		Product tmp = new Product(name, dprice);	
		return tmp;
	}

	public void sortByName() {
		sortByName.click();
	}

	public void sortByPrice() {
		sortByPrice.click();
	}
}
