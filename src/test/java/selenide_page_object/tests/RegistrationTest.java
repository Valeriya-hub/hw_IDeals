package selenide_page_object.tests;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import selenide_page_object.pages.MainPage;
import selenide_page_object.utils.Utils;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    @BeforeTest
    public void initialDriver() throws Exception {
        Utils.getInstance().initDriver();
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
