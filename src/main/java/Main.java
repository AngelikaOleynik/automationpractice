import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\Desktop\\repo\\automationpractice\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickSignIn();
    }
}
