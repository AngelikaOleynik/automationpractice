//package pages;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CreateAccountPageTest {
//
//    private WebDriver driver;
//    private AuthenticationPage authPage;
//    private CreateAccountPage createAccountPage;
//    private MyAccountPage myAccountPage;
//
//    @BeforeEach
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\1\\Desktop\\repo\\automationpractice\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
//        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//        authPage = new AuthenticationPage(driver);
//        createAccountPage = new CreateAccountPage(driver);
//     //  myAccountPage = new MyAccountPage(driver);
//    }
//
//    @DisplayName("Регистрация нового пользователя")
//    @ParameterizedTest
//    @ValueSource(strings = {"firstname", "lastname", "password", "address", "city", "12345", "892585485015", "aliasAddress"})
//    void newUserRegistrationTest(String firstname, String lastname, String password, String address, String city, String postalCode,
//                                 String mobilePhone, String aliasAddress) {
//        String email = System.currentTimeMillis() + "goodmail@mail.com";
//        authPage.typeEmailCreateAccount(email);
//        createAccountPage.clickRadioButtonMrs()
//                .typeFirstName(firstname)
//                .typeLastName(lastname)
//                .typePassword(password)
//                .selectDateOfBirth()
//                .typeAddress(address)
//                .typeCity(city)
//                .selectState()
//                .typePostalCode(postalCode)
//                .typeMobilePhone(mobilePhone)
//                .typeAliasAddress(aliasAddress)
//                .clickRegisterButton();
//
//        String expectedHeaderMyAccount = myAccountPage.getMyAccountHeaderText();
//        Assert.assertEquals("MY ACCOUNT", expectedHeaderMyAccount);
//    }
//}