package com.sikachov.framework.test;

import org.testng.annotations.Test;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.pages.second.ComparationPage;

public class ComparationTest extends BaseTest{
	
	
	@Test
	public void paramsShowedTest(){
		MyPageFactory.getPage(driver, ComparationPage.class);
		
	}
}
