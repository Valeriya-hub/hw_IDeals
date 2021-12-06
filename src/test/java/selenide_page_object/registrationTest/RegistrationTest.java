package selenide_page_object.registrationTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import selenide_page_object.pages.MainPage;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {

    @Before
    public void initialDriver() throws Exception {
        initDriver();
    }

    public void initDriver() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) ||
                ("chrome".equalsIgnoreCase(browser))) {
            ChromeDriverManager.getInstance().setup();
            Configuration.browser = "chrome";
        } else if ("edge".equalsIgnoreCase(browser)) {
            EdgeDriverManager.getInstance().setup();
            Configuration.browser = "edge";
        } else if ("firefox".equalsIgnoreCase(browser)) {
            FirefoxDriverManager.getInstance().setup();
            Configuration.browser = "firefox";
        } else {
            throw new Exception("Check browser var");
        }
    }

    @Test
    public void successRegistration() {
        open("https://finik-market.com/");
        MainPage page = new MainPage();
        page.clickToRegistrationIcon();
        page.clickToRegistrationTab();
        page.enterNameIntoNameInput("Валентина");
        page.enterEmailIntoEmailInput();
        page.enterPassIntoPassInput();
        page.clickToRegisterButton();

        $(By.xpath(".//span[text()='Закрыть']")).shouldBe(Condition.visible);
    }
}
