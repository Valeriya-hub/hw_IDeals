package selenide_page_object.registrationTest.remote;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class RemoteChromeDriver implements WebDriverProvider {

    @SneakyThrows
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        desiredCapabilities.setCapability("os", "Windows");
        desiredCapabilities.setCapability("os_version", "10");
        desiredCapabilities.setCapability("browser", "Chrome");
        desiredCapabilities.setCapability("browser_version", "90.0");
        desiredCapabilities.setCapability("browserstack.local", "false");
        desiredCapabilities.setCapability("resolution", "1920x1080");
        RemoteWebDriver webDriver = new RemoteWebDriver((new URL("http://localhost:4444/wd/hub")), desiredCapabilities);
        webDriver.setFileDetector(new LocalFileDetector());
        return webDriver;
    }

}
