package com.sikachov.framework.objects;

public class Product {
	
	private String name;
	private String price;
	
	public Product(String name, String price){
		this.setName(name);
		this.setPrice(price);	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
