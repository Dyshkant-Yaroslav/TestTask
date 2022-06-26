package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//div[@id='email_input_container']//input")
    private WebElement emailOrPhoneInput;

    @FindBy(xpath = "//input[@id='m_login_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='login_password_step_element']//button")
    private WebElement logInButton;

    @FindBy(xpath = "//div[@id='login_error']")
    private WebElement incorrectPasswordOrEmailDiv;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailOrPhoneInput(String value) {
        emailOrPhoneInput.clear();
        emailOrPhoneInput.sendKeys(value);
    }

    public void fillPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnLogInButton() {
        logInButton.click();
    }

    public WebElement getIncorrectAccountOrPasswordDiv() {
        return incorrectPasswordOrEmailDiv;
    }

}
