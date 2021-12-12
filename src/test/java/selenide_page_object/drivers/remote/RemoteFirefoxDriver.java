package selenide_page_object.drivers.remote;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static selenide_page_object.utils.config.WebConfig.WEB_CONFIG;

public abstract class RemoteFirefoxDriver implements WebDriverProvider {

    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        desiredCapabilities.setCapability("os", "Windows");
        desiredCapabilities.setCapability("os_version", "10");
        desiredCapabilities.setCapability("browser", "Firefox");
        desiredCapabilities.setCapability("browser_version", "latest");
        desiredCapabilities.setCapability("browserstack.local", "false");
        desiredCapabilities.setCapability("resolution", "1920x1080");
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL(WEB_CONFIG.getGridEndpoint()), desiredCapabilities);
        webDriver.setFileDetector(new LocalFileDetector());
        return webDriver;
    }

}
