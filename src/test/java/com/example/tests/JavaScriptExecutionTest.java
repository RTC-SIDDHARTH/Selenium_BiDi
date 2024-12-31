package com.example.tests;

import com.example.bidi.base.BasePage;
import com.example.bidi.bidi.BiDiManager;
import com.example.bidi.utils.ConfigReader;
import org.testng.annotations.Test;

public class JavaScriptExecutionTest extends BasePage {

    @Test
    public void testJavaScriptExecution() {
        BiDiManager bidiManager = new BiDiManager(driver);
        String script = ConfigReader.get("javascript.script");
        bidiManager.executeJavaScript(script);
        driver.get(ConfigReader.get("base.url"));
    }
}