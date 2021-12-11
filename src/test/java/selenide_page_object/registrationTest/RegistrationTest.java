package selenide_page_object.registrationTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.checkerframework.checker.nullness.qual.KeyFor;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import selenide_page_object.pages.MainPage;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {

    @Before
    public void initialDriver() throws Exception {
        Utils utils = new Utils();
        utils.initDriver();
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
