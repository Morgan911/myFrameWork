package com.sikachov.framework.test;

import org.testng.annotations.Test;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.pages.NameSortedProductPage;
import com.sikachov.framework.pages.ProductPage;

public class FridgeSortTest extends BaseTest{
	
	@Test
	public void sortPriceTest(){
		MyPageFactory.getPage(driver, ProductPage.class);
		MyPageFactory.getPage(driver, NameSortedProductPage.class).getProducts();
	}

}
