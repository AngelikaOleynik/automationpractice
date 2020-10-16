package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    private WebElement headerTitlePage;


    public MainPage openMainPage() {
        driver.get("http://automationpractice.com/");
        return this;
    }

    public AuthenticationPage clickSignIn() {
        signInButton.click();
        return new AuthenticationPage(driver);
    }
}



