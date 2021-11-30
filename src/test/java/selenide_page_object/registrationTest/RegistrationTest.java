package selenide_page_object.registrationTest;

import org.junit.Test;
import org.openqa.selenium.By;
import selenide_page_object.pages.MainPage;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
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

        $(By.xpath(".//span[text()='Закрыть']")).shouldBe().click();
    }
}
