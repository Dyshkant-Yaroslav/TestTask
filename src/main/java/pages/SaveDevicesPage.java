package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveDevicesPage extends BasePage {

    @FindBy(xpath = "//a[@class='_54k8 _56bs _26vk _56b_ _56bw _56bt']")
    private WebElement notNowButton;

    public SaveDevicesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNotNowButton() {
        notNowButton.click();
    }
}
