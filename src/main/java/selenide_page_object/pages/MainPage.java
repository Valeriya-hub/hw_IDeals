package selenide_page_object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement registrationIcon = $x(".//div[@class='userbar userbar--user-outline-icon j-user-tabs']//a[@href='#j-popup-tab-auth']");
    private final SelenideElement registrationTab = $x(".//a[@href='#j-popup-tab-signup']");
    private final SelenideElement nameInput = $x(".//input[@name='user[title]']");
    private final SelenideElement emailInput = $x(".//input[@name='user[email]' and @tabindex=2]");
    private final SelenideElement passInput = $x(".//input[@name='user[pass]' and @tabindex=3]");
    private final SelenideElement registerButton = $x(".//input[@tabindex=7 and @type='submit']");


    public void clickToRegistrationIcon() {
        registrationIcon.click();
    }

    public void clickToRegistrationTab() {
        registrationTab.click();
    }

    public void enterNameIntoNameInput(String name) {
        nameInput.setValue(name);
    }

    public void enterEmailIntoEmailInput() {
        emailInput.setValue(GenerateEmailPage.getRandomEmail());
    }

    public void enterPassIntoPassInput() {
        passInput.setValue("12312312");
    }

    public void clickToRegisterButton() {
        registerButton.click();
    }
}
