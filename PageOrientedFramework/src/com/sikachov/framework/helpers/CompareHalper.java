package com.sikachov.framework.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareHalper {
	
	public static boolean compareDifferent(List<WebElement> list){
		
		for(WebElement w: list){
			String el1 = w.findElement(By.xpath("//td[1]")).getText();
			String el2 = w.findElement(By.xpath("//td[w]")).getText();
			if(el1.equals(el2))
				return false;
		}
		return true;
	}
	
}
