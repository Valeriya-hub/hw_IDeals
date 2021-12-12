package selenide_page_object.drivers.local;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import javax.annotation.Nonnull;
import java.nio.file.Paths;
import java.util.HashMap;

import static org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE;
import static org.openqa.selenium.remote.CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR;
import static selenide_page_object.utils.config.WebConfig.WEB_CONFIG;

public abstract class LocalСhromeDriver implements WebDriverProvider {

    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities){
        final String downloadsPath = Paths.get(System.getProperty("user.dir"), WEB_CONFIG.getDownloadsPath()).toString();
        final HashMap<String, Object> chromePrefs = new HashMap<>();
        final ChromeOptions options = new ChromeOptions();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadsPath);
        WebDriverManager.chromedriver().setup();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.setHeadless(WEB_CONFIG.isHeadless());
        options.setCapability(UNEXPECTED_ALERT_BEHAVIOUR, IGNORE);
//        options.merge(DesiredCapabilities.chrome();
        return new ChromeDriver(options);

    }

}
