package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    private WebElement myAccountHeader;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
    private WebElement buttonHistoryOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")
    private WebElement buttonMyCreditSlips;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")
    private WebElement buttonMyAddresses;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
    private WebElement buttonMyPersonalInformation;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")
    private WebElement buttonMyWishLists;

    @FindBy(xpath = "//*[@id='center_column']/ul/li/a")
    private WebElement homepage;

    @FindBy(xpath = "//*[@id='center_column']/h1")
    private WebElement heading;

    public MyAccountPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    public MainPage clickHomeButton() {
        homepage.click();
        return new MainPage(driver);
    }

    public String getTextInAccount() {
        return heading.getText();
    }

    public String getMyAccountHeaderText() {
        return myAccountHeader.getText();
    }
}
