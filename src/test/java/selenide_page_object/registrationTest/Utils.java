package selenide_page_object.registrationTest;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import selenide_page_object.registrationTest.local.LocalFirefoxDriver;
import selenide_page_object.registrationTest.remote.RemoteChromeDriver;

public class Utils {
    private WebDriver driver;

    public void initDriver() throws Exception {
        String remote = System.getProperty("remote");
        if ((remote == null) || ("false".equalsIgnoreCase(remote))) {
//            Configuration.remote = "false";
            getLocalBrowser();
        } else if ("true".equalsIgnoreCase(remote)) {
//            Configuration.remote = "true";
            getRemoteBrowser();
        }
    }

    private void getRemoteBrowser() throws Exception {
        String remoteBrowser = System.getProperty("remoteBrowser");
        if ((remoteBrowser == null) ||
                ("chrome".equalsIgnoreCase(remoteBrowser))) {
            Configuration.browser = RemoteChromeDriver.class.getName();
        } else {
            throw new Exception("Check remote browser var");
        }
    }

    public void getLocalBrowser() throws Exception {
//        String browser = System.getProperty("browser");
        String browser = System.getProperty("browser");
        String headless = System.getProperty("headless");
        if ((browser == null) ||
                ("chrome".equalsIgnoreCase(browser))) {
//            ChromeDriverManager.getInstance().setup();
//            Configuration.browser = "chrome";
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(); открывает еще один браузер
        } else if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            Configuration.browser = "edge";
        } else if ("firefox".equalsIgnoreCase(browser)) {
            // headless:
            if ((headless == null) || ("false".equalsIgnoreCase(headless))) {
                WebDriverManager.firefoxdriver().setup();
                Configuration.browser = "firefox";
            } else if ("true".equalsIgnoreCase(headless)) {
                Configuration.browser = LocalFirefoxDriver.class.getName();
            }
        } else if ("opera".equalsIgnoreCase(browser)) {
            OperaDriverManager.getInstance().setup();
            Configuration.browser = "opera";
        } else {
            throw new Exception("Check browser var");
        }
    }
}

