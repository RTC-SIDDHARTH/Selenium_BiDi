package com.example.tests;

import com.example.bidi.base.BasePage;
import com.example.bidi.bidi.BiDiManager;
import com.example.bidi.utils.ConfigReader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ConsoleLogTest extends BasePage {

    @Test
    public void testConsoleLogs() {
        BiDiManager bidiManager = new BiDiManager(driver);
       

        driver.get(ConfigReader.get("base.url"));
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        driver.findElement(By.className("dialog-close")).click();
        ((JavascriptExecutor) driver).executeScript("console.log('This is a test log!');");

        if (Boolean.parseBoolean(ConfigReader.get("log.console.enabled"))) {
            bidiManager.enableConsoleLogging();
        }
    }
}
