package com.sikachov.framework.test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.helpers.SortHelper;
import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;
import com.sikachov.framework.pages.first.NameSortedProductPage;
import com.sikachov.framework.pages.first.PriceSortedProductPage;

public class FridgeSortTest extends BaseTest{
	List<Product> productsUnsorted;
	@BeforeClass
	public void setUpMethod(){
		productsUnsorted = MyPageFactory.getPage(driver, ProductPage.class).getProducts();
	}

	@Test
	public void sortNameTest(){
		
		List<Product> productsSortedByName = MyPageFactory.getPage(driver, NameSortedProductPage.class).getProducts();
		List<String> productUnsortedNames = SortHelper.getNames(productsUnsorted);
		Collections.sort(productUnsortedNames);
		Assert.assertEquals(SortHelper.getNames(productsSortedByName), productUnsortedNames);
	}
	
	@Test
	public void sortPriceTest(){
		
		List<Product> productsSortedByPrice = MyPageFactory.getPage(driver, PriceSortedProductPage.class).getProducts();
		List<Double> productUnsortedPrices = SortHelper.getPrices(productsUnsorted);
		Collections.sort(productUnsortedPrices);
		Assert.assertEquals(SortHelper.getPrices(productsSortedByPrice), productUnsortedPrices);
	}

}
