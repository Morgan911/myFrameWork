package com.sikachov.framework.helpers;

import java.util.ArrayList;
import java.util.List;

import com.sikachov.framework.objects.Product;


public class SortHelper {

	public static List<Double> getPrices(List<Product> list){
		List<Double> prices = new ArrayList();
		for(Product p: list){
			prices.add(p.getPrice());
		}
		return prices;
	}
	
	public static List<String> getNames(List<Product> list){
		List<String> prices = new ArrayList();
		for(Product p: list){
			prices.add(p.getName().toLowerCase());
		}
		return prices;
	}
	
}
