package pages;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


class CreateAccountPageTest {

    MainPage mainPage;
    UUID uuid;
    private WebDriver driver;


    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\1\\Desktop\\repo\\automationpractice\\drivers\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


//    @DisplayName("Регистрация нового пользователя")
//    @ParameterizedTest
//    @ValueSource(strings = {"firstName", "lastName", "password", "address", "city", "indexOfState", "postCode", "phone"})
//    void testCreateAccountValidLoginParameters(String firstName, String lastName, String password, String address, String city, int indexOfState, String postCode, String phone) {
//        new AuthenticationPage(driver).typeEmail(uuid + "test@gmail.com").getHeadingText();
//
//
//


//
//                createAccountSuccess((System.currentTimeMillis()) + "zvereva@ele.na").
//                creationAccountPositive(
//                        firstName, lastName, password, address, city, indexOfState, postCode, phone).
//                checkMyAccountPageIsDisplayed().
//                getHeaderBlock().
//                checkNamePage("My account");
//        sleep(5000);
    }

//    @Test(testName = "Регистрация. «Email address» - не валидное значение")
//    @Parameters({"emailInvalid", "expectedText"})
//    void testCreateAccountInvalidLogin(String emailInvalid, String expectedText) throws InterruptedException {
//        new AuthenticationPage(driver)
//                .openPage().
//                createAnAccountNegative(emailInvalid).
//                checkAlertDanger(expectedText);
//        sleep(5000);
//    }
}
