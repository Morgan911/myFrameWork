package com.sikachov.framework.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.sikachov.framework.factories.WebDriverFactory;

public abstract class BaseTest {
	private static final String BASE_ADDRESS = "http://pn.com.ua/";
	protected WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get(BASE_ADDRESS);
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
