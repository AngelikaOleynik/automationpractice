package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class CreateAccountPageTest {

    private WebDriver driver;
    private AuthenticationPage authPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\repositories\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        authPage = new AuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @When("^I fill in the data in the registration form$")
    @And("^I click \"Register\" button$")
    @Then("^I get to the profile page$")
    @DisplayName("Регистрация нового пользователя")
    @Test
  //  @ValueSource(strings = {"firstname", "lastname", "password", "address", "city", "12345", "892585485015", "aliasAddress"})
    void newUserRegistrationTest() {
        String email = System.currentTimeMillis() + "goodmail@mail.com";
        authPage.typeEmailCreateAccount(email);
       createAccountPage.clickRadioButtonMrs()
                .typeFirstName("firstname")
                .typeLastName("lastname")
                .typePassword("password")
                .selectDateOfBirth()
                .typeAddress("address")
                .typeCity("city")
                .selectState()
                .typePostalCode("12345")
                .typeMobilePhone("892756789123")
                .typeAliasAddress("aliasAddress")
                .clickRegisterButton();

        String expectedHeaderMyAccount = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals("MY ACCOUNT", expectedHeaderMyAccount);
    }
}