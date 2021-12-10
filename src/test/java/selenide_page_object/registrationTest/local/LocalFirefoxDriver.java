package selenide_page_object.registrationTest.local;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

public abstract class LocalFirefoxDriver implements WebDriverProvider { //static
    @Nonnull
//    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        firefoxOptions.addArguments("--proxy-bypass-list=<-loopback>");
        firefoxOptions.merge(desiredCapabilities);
        return new FirefoxDriver(firefoxOptions);
    }
}