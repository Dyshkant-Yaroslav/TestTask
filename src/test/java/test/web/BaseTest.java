package test.web;

import business.BusinessLogging;
import business.FactoryPages;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.LogInPage;
import pages.SaveDevicesPage;
import util.PropertiesReader;
import util.WebdriverSingleton;

public class BaseTest {

    PropertiesReader propertiesReader = new PropertiesReader();
    BusinessLogging businessLogging = new BusinessLogging();
    FactoryPages factoryPages = new FactoryPages();

    @BeforeTest
    public void setUp() {
        WebdriverSingleton.setProperties();
    }

    @BeforeMethod
    public void setUpTest() {
        getDriver();
    }

    @AfterMethod
    public void close() {
        WebdriverSingleton.closeDriver();
    }

    public WebDriver getDriver() {
        return WebdriverSingleton.getDriver();
    }

    public LogInPage getLogInPage() {
        return new LogInPage(getDriver());
    }

    public SaveDevicesPage getSaveDevicesPage() {
        return new SaveDevicesPage(getDriver());
    }

    public BusinessLogging getBusinessLogging() {
        businessLogging.setFactoryPages(getFactoryPages());
        return businessLogging;
    }

    private FactoryPages getFactoryPages() {
        factoryPages.setLogInPage(getLogInPage());
        return factoryPages;
    }

}
