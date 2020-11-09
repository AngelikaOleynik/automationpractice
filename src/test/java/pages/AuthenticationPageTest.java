package pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
class AuthenticationPageTest {

    private WebDriver driver;
    private AuthenticationPage authPage;
    private CreateAccountPage createAccountPage = new CreateAccountPage(null);



    @Given("^Site login page$")
    public void site_login_page() {
        System.setProperty("webdriver.chrome.driver", "D:\\repositories\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        authPage = new AuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);

    }


    @When("^I enter a certain email into the account creation field$")
    public void iEnterACertainEmailIntoTheAccountCreationField(String email) {
        authPage.typeEmail(email);
    }

    @Then("^I get an error \"Invalid email address.\"$")
    public void invalidEmailTest() {
        String expectedErrorHead = authPage.getErrorMail();
        Assert.assertEquals("Invalid email address.", expectedErrorHead);
    }

    @When("I enter the correct email in the registration form")
    public void typeGoodEmailTest() {
        String email = System.currentTimeMillis() + "goodmail@mail.com";
        authPage.typeEmail(email);
    }

    @Then("^I get to the page with the registration form$")
    public void registrationForm() {
        String expectedHeader = createAccountPage.getHeaderCreateAccountPage();
        Assert.assertEquals("AUTHENTICATION", expectedHeader);
    }

}