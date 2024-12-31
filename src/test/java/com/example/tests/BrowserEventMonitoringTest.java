package com.example.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.example.bidi.base.BasePage;
import com.example.bidi.bidi.BiDiManager;
import com.example.bidi.utils.ConfigReader;

public class BrowserEventMonitoringTest extends BasePage {
	 @Test
	    public void testBrowserEventMonitioring() {
	        BiDiManager bidiManager = new BiDiManager(driver);
	        if (Boolean.parseBoolean(ConfigReader.get("log.console.enabled"))) {
	            bidiManager.browserEvenetMonitoring();
	        }
	        

	        driver.get(ConfigReader.get("base.url"));
	        ((JavascriptExecutor) driver).executeScript("nonExistentFunction();");
	    }

}
