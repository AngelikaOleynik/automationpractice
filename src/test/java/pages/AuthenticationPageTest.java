package pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
class AuthenticationPageTest {

    private WebDriver driver;
    private AuthenticationPage authPage;
    private CreateAccountPage createAccountPage = new CreateAccountPage(null);


    @BeforeEach
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
        throw new io.cucumber.java.PendingException();
    }

    @When("^iEnterACertainEmailIntoTheAccountCreationField$")
    @Then("^I get an error \"Invalid email address.\"$")
    @DisplayName("Ввод невалидного email")
    @ParameterizedTest
    @ValueSource(strings = {"bademail", "verybademail"})
    void iEnterACertainEmailIntoTheAccountCreationField(String email) {

        authPage.typeEmail(email);
        String expectedErrorHead = authPage.getErrorMail();
        Assert.assertEquals("Invalid email address.", expectedErrorHead);

    }

    @When("^I enter the correct email in the registration form$")
    @Then("^ I get to the page with the registration form$")
    @DisplayName("Ввод валидного email")
    @Test
    void typeGoodEmailTest() {

        String email = System.currentTimeMillis() + "goodmail@mail.com";
        authPage.typeEmail(email);
        String expectedHeader = createAccountPage.getHeaderCreateAccountPage();
        Assert.assertEquals("AUTHENTICATION", expectedHeader);
    }

}