package selenide_page_object.drivers.local;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

public abstract class LocalEdgeDriver implements WebDriverProvider {

    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

}
