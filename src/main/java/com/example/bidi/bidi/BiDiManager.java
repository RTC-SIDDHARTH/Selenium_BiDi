package com.example.bidi.bidi;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.log.Log;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.performance.Performance;
import org.openqa.selenium.devtools.v131.runtime.Runtime;

public class BiDiManager {
    private final DevTools devTools;

    public BiDiManager(WebDriver driver) {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
    }

    public void enableNetworkIntercept() {
    	
         devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

         // Log intercepted requests
         devTools.addListener(Network.requestWillBeSent(), request -> {
             System.out.println("Request URL: " + request.getRequest().getUrl());
         });
    }

    public void enableConsoleLogging() {
    	devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println("Console Log: " + logEntry.getText());
            System.out.println("Level: " + logEntry.getLevel());
        });
    }

    public void executeJavaScript(String script) {
//    	devTools.send(org.openqa.selenium.devtools.v129.runtime.Runtime.evaluate(script));
    }
    
    public void browserEvenetMonitoring() {
    	  devTools.send(Runtime.enable());

          devTools.addListener(Runtime.exceptionThrown(), exception -> {
              System.out.println("JavaScript Exception: " + exception.getExceptionDetails().getText());
          });
          Performance.enable(java.util.Optional.empty());
    }
}
