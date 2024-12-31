package com.example.tests;

import org.testng.annotations.Test;

import com.example.bidi.base.BasePage;
import com.example.bidi.bidi.BiDiManager;
import com.example.bidi.utils.ConfigReader;


public class NetworkInterceptTest extends BasePage{

    @Test
    public void testNetworkIntercept() {
        BiDiManager bidiManager = new BiDiManager(driver);
        bidiManager.enableNetworkIntercept();
        driver.get(ConfigReader.get("base.url"));

    }
}