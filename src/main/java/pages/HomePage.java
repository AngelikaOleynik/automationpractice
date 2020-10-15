package pages;


import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Util;

public class HomePage {

    private WebDriver driver;
    private By shoppingCart = By.cssSelector("div.shopping_cart>a");
    private By menuLinkWomen = By.xpath("//*[@id='block_top_menu']//ul//li//a[text()='Women']");

    private By menuLinkWomenSummerDresses = By.xpath("//*[@id='block_top_menu']//ul//li[2]//a[contains(text()='Summer Dresses')]");
    private By summerLink = By.linkText("Summer Dresses");

    private Util util;

    private By loginButton = By.className("login");

    private By subMenuTopsTitle = By.linkText("Tops");
    private By subMenuTshirtsLink = By.linkText("T-shirts");
    private By subMenuBlousesLink = By.linkText("Blouses");
    private By subMenuCasualDressesLink = By.linkText("Casual Dresses");
    private By subMenuEveningDressesLink = By.linkText("Evening Dresses");
    private By subMenuSummerDressesLink;
    private By subMenuDressesTitle = By.linkText("Dresses");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public WebElement getSummerDressesLink() {
        Util getElement = new Util();
        return getElement.waitUntilElementIsLocated(driver, menuLinkWomenSummerDresses,8);
    }

    public SummerDressesPage clickSummerDresses(){
        WebElement link = driver.findElement(menuLinkWomen);

        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(summerLink));

        driver.findElement(summerLink).click();
        return new SummerDressesPage(driver);
    }

    public AuthenticationPage clickSignIn(){
        driver.findElement(loginButton).click();
        return new AuthenticationPage(driver);
    }

    public OurStoresPage clickOurStores(){
        clickLink("Our stores");
        return new OurStoresPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class MainPage extends BasePage {
//    WebDriver driver;
//
//    public MainPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
//    private WebElement signInButton;
//
//    @FindBy(xpath ="//*[@id=\"center_column\"]/h1")
//    private WebElement headerTitlePage;
//
//
//
//    public MainPage openMainPage() {
//        driver.get("http://automationpractice.com/");
//        return this;
//    }
//
//    public AuthenticationPage clickSignIn(){
//        signInButton.click();
//        return new AuthenticationPage(driver);
//    }
//


