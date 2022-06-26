package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebdriverSingleton {

    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static WebDriver webDriver;

    public static void setProperties() {
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
    }

    public static WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(propertiesReader.getDefaultWaitTime(), TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(propertiesReader.getDefaultWaitTime(), TimeUnit.SECONDS);
            webDriver.manage().timeouts().setScriptTimeout(propertiesReader.getDefaultWaitTime(), TimeUnit.SECONDS);
            webDriver.get(propertiesReader.getBaseUrl());
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.close();
        webDriver = null;
    }
}
