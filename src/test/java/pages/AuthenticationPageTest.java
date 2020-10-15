package pages;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


class AuthenticationPageTest {

    private WebDriver driver;
    private AuthenticationPage authPage;
    private CreateAccountPage createAccountPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\1\\Desktop\\repo\\automationpractice\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        authPage = new AuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @Test
    void typeEmailTest() {

        String email = System.currentTimeMillis() + "goodmail@mail.com";
        authPage.typeEmail(email);
        String expectedHeader = createAccountPage.getHeaderCreateAccountPage();
        Assert.assertEquals("YOUR PERSONAL INFORMATION", expectedHeader);
    }
}