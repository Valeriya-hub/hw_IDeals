package classic_page_object.registrastionTest;

import classic_page_object.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = driverInit();
        driver.manage().window().maximize();
    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) ||
                ("chrome".equalsIgnoreCase(browser))) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("opera".equalsIgnoreCase(browser)) {
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        } else {
            throw new Exception("Check browser var");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void successRegistration() {
        driver.get("https://finik-market.com/");
        MainPage page = PageFactory.initElements(driver, MainPage.class);
        page.clickToRegistrationIcon();
        page.clickToRegistrationTab();
        page.enterNameIntoNameInput("Валентина");
        page.enterEmailIntoEmailInput();
        page.enterPassIntoPassInput();
        page.clickToRegisterButton();

        page.waitExpectedResult("Close button is NOT present", page.isCloseButtonPresent());
    }
}
