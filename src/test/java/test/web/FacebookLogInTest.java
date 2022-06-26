package test.web;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLogInTest extends BaseTest {

    @Test
    public void validateLogInHappyScenario() {
        //fill correct email and password on login page abd click button "log in"
        getBusinessLogging().logIn(propertiesReader.getCorrectEmail(), propertiesReader.getCorrectPassword());
        //click "not now" button to proceed on home page(mb is not required in future)
        getSaveDevicesPage().clickOnNotNowButton();
        //verify that we are on home page
        Assert.assertEquals(getDriver().getCurrentUrl(), propertiesReader.getHomePageUrl());
    }

    @Test
    public void validateLogInWithIncorrectEmail() {
        //fill incorrect email and correct password on login page abd click button "log in"
        getBusinessLogging().logIn(propertiesReader.getIncorrectEmail(), propertiesReader.getCorrectPassword());
        //verify that popup "incorrect password or email" displayed
        Assert.assertTrue(getLogInPage().isElementDisplayed(getLogInPage().getIncorrectAccountOrPasswordDiv()));
    }

    @Test
    public void validateLogInWithIncorrectPassword() {
        //fill correct email and incorrect password on login page abd click button "log in"
        getBusinessLogging().logIn(propertiesReader.getCorrectEmail(), propertiesReader.getIncorrectPassword());
        //verify that popup "incorrect password or email" displayed
        Assert.assertTrue(getLogInPage().isElementDisplayed(getLogInPage().getIncorrectAccountOrPasswordDiv()));
    }

}
