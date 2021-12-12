package selenide_page_object.drivers.local;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static selenide_page_object.utils.config.WebConfig.WEB_CONFIG;

public abstract class LocalFirefoxDriver implements WebDriverProvider {
    @Nonnull
//    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(WEB_CONFIG.isHeadless());
        return new FirefoxDriver(firefoxOptions);
    }
}
