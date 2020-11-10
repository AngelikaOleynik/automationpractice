//package pages;
//
//
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.junit.Assert;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class CreateAccountPageTest {
//
//    private WebDriver driver;
//    private AuthenticationPage authPage;
//    private CreateAccountPage createAccountPage;
//    private MyAccountPage myAccountPage;
//
//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "D:\\repositories\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
//        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//        createPages(driver);
//    }
//
//    private void createPages(WebDriver driver) {
//        authPage = new AuthenticationPage(driver);
//        createAccountPage = new CreateAccountPage(driver);
//        myAccountPage = new MyAccountPage(driver);
//    }
//
//    @When("^I fill in the data in the registration form$")
//    public void i_fill_in_the_data_in_the_registration_form() {
//        createPages(driver);
//        String email = System.currentTimeMillis() + "goodmail@mail.com";
//      //  authPage.typeEmailCreateAccount(email);
//        createAccountPage.clickRadioButtonMrs()
//                .typeFirstName("firstname")
//                .typeLastName("lastname")
//                .typePassword("password")
//                .selectDateOfBirth()
//                .typeAddress("address")
//                .typeCity("city")
//                .selectState()
//                .typePostalCode("12345")
//                .typeMobilePhone("892756789123")
//                .typeAliasAddress("aliasAddress");
//
//    }
//
//
//    @When("^I click \"([^\"]*)\" button$")
//    public void i_click_button() {
//        createAccountPage.clickRegisterButton();
//
//    }
//
//    @Then("^I get to the profile page$")
//    public void i_get_to_the_profile_page() {
//        String expectedHeaderMyAccount = myAccountPage.getMyAccountHeaderText();
//        Assert.assertEquals("MY ACCOUNT", expectedHeaderMyAccount);
//
//    }
//}