//package pages;
//
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
//
//class CreateAccountPageTest {
//
//    private final WebDriver driver = new ChromeDriver();
//    private final AuthenticationPage authPage = new AuthenticationPage(driver);
//    private final MainPage mainPage = new MainPage(driver);
//    private final CreateAccountPage createAccountPage = new CreateAccountPage(driver);
//
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
//
//    }
//
//
//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }
//
//
//  @DisplayName("Регистрация нового пользователя")
//   @ParameterizedTest
//   @ValueSource(strings = {"firstName", "lastName", "password", "address", "city", "indexOfState", "postCode", "phone"})
//   void testCreateAccountValidLoginParameters(String firstName, String lastName, String password, String address, String city, int indexOfState, String postCode, String phone) {
//        new AuthenticationPage(driver).typeEmail(uuid + "test@gmail.com").getHeadingText();
//
//
//               createAccountSuccess((System.currentTimeMillis()) + "zvereva@ele.na").
//               creationAccountPositive(
//                       firstName, lastName, password, address, city, indexOfState, postCode, phone).
//               checkMyAccountPageIsDisplayed().getHeaderBlock().
//               checkNamePage("My account");
//       sleep(5000);
//    }
//
//  @Test(testName = "Регистрация. «Email address» - не валидное значение")
//    @Parameters({"emailInvalid", "expectedText"})
//  void testCreateAccountInvalidLogin(String emailInvalid, String expectedText) throws InterruptedException {
//        new AuthenticationPage(driver)
//                .openPage().
//                createAnAccountNegative(emailInvalid).
//                checkAlertDanger(expectedText);
//        sleep(5000);
//    }
