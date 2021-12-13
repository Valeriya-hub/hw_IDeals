package selenide_page_object.utils.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public interface WebConfig extends Config {
    WebConfig WEB_CONFIG = ConfigFactory.create(WebConfig.class,
            System.getenv(),
            System.getProperties());

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("remote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("headless")
    @DefaultValue("false")
    boolean isHeadless();

    @Key("downloadsPath")
    String getDownloadsPath();

    @Key("gridEndpoint")
    @DefaultValue("http://localhost:4444/wd/hub")
    String getGridEndpoint();
}
