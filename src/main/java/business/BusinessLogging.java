package business;

public class BusinessLogging {
    private FactoryPages factoryPages;

    public void fillEmailOrPhone(String emailOrPhone) {
        factoryPages.getLogInPage().fillEmailOrPhoneInput(emailOrPhone);
    }

    public void fillPassword(String password) {
        factoryPages.getLogInPage().fillPasswordInput(password);
    }

    public void logIn(String emailOrPhone, String password) {
        fillEmailOrPhone(emailOrPhone);
        fillPassword(password);
        factoryPages.getLogInPage().clickOnLogInButton();
    }

    public void setFactoryPages(FactoryPages factoryPages) {
        this.factoryPages = factoryPages;
    }
}
