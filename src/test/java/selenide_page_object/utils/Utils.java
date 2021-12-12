package selenide_page_object.utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriverException;
import selenide_page_object.drivers.local.LocalEdgeDriver;
import selenide_page_object.drivers.local.LocalFirefoxDriver;
import selenide_page_object.drivers.local.LocalСhromeDriver;
import selenide_page_object.drivers.remote.RemoteChromeDriver;
import selenide_page_object.drivers.remote.RemoteEdgeDriver;
import selenide_page_object.drivers.remote.RemoteFirefoxDriver;

import static com.codeborne.selenide.Browsers.*;
import static selenide_page_object.drivers.browserNames.BrowserNames.FIREFOX;
import static selenide_page_object.utils.config.WebConfig.WEB_CONFIG;

public class Utils {

    private static final String TARGET_BUILD_DOWNLOADS = "target/build/downloads";
    private static final String TARGET_BUILD_REPORTS_TESTS = "target/build/reports/tests";

    private static volatile ThreadLocal<Utils> THREAD_LOCAL;

    public Utils() {

    }

    public static synchronized Utils getInstance() {
        if (THREAD_LOCAL == null) {
            THREAD_LOCAL = ThreadLocal.withInitial(Utils::new);
        }
        return THREAD_LOCAL.get();
    }

    public void initDriver() throws Exception {
        Configuration.downloadsFolder = TARGET_BUILD_DOWNLOADS;
        Configuration.reportsFolder = TARGET_BUILD_REPORTS_TESTS;

        if (WEB_CONFIG.isRemote()) {
            getRemoteBrowser();
        } else {
            getLocalBrowser();
        }
    }

    private void getRemoteBrowser() throws Exception {
        switch (WEB_CONFIG.getBrowser()) {
            case CHROME:
                Configuration.browser = RemoteChromeDriver.class.getName();
                break;
            case FIREFOX:
                Configuration.browser = RemoteFirefoxDriver.class.getName();
                break;
            case EDGE:
                Configuration.browser = RemoteEdgeDriver.class.getName();
                break;
            default:
                throw new WebDriverException("Non correct browser name!");
        }
    }

    public void getLocalBrowser() throws Exception {
        switch (WEB_CONFIG.getBrowser()) {
            case CHROME:
                Configuration.browser = LocalСhromeDriver.class.getName();
                break;
            case FIREFOX:
                Configuration.browser = LocalFirefoxDriver.class.getName();
                break;
            case EDGE:
                Configuration.browser = LocalEdgeDriver.class.getName();
                break;
            default:
                throw new WebDriverException("Non correct browser name!");
        }
    }
}

