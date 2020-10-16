package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthenticationPage {

    WebDriver driver;

    //поле для ввода нового е-мейла
    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement inputEmailForRegistrationField;

    //кнопка создать аккаунт
    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'center_column')]/h1")
    private WebElement headingText;

    @FindBy(xpath =   "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement errorMail;

    public AuthenticationPage(WebDriver driver) {
     //   super(driver);
        PageFactory.initElements(driver, this);
    }



    public AuthenticationPage typeEmail(String email) {
        inputEmailForRegistrationField.clear();
        inputEmailForRegistrationField.sendKeys(email);
        clickCreateAccountButton();
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }

    public String getHeadingText(){
       return headingText.getText();
    }

}
