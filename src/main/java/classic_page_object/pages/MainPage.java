package classic_page_object.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenide_page_object.pages.GenerateEmailPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebElement element;

    private final WebDriver driver;

    @FindBy(xpath = ".//div[@class='userbar userbar--user-outline-icon j-user-tabs']//a[@href='#j-popup-tab-auth']")
    private WebElement registrationIcon;

    @FindBy(xpath = ".//a[@href='#j-popup-tab-signup']")
    private WebElement registrationTab;

    @FindBy(xpath = ".//input[@name='user[title]']")
    private WebElement nameInput;

    @FindBy(xpath = ".//input[@name='user[email]' and @tabindex=2]")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@name='user[pass]' and @tabindex=3]")
    private WebElement passInput;

    @FindBy(xpath = ".//input[@tabindex=7 and @type='submit']")
    private WebElement registerButton;

    @FindBy(xpath = ".//span[text()='Закрыть']")
    private WebElement closeButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegistrationIcon() {
        registrationIcon.click();
    }

    public void clickToRegistrationTab() {
        registrationTab.click();
    }

    public void enterNameIntoNameInput(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmailIntoEmailInput() {
        emailInput.clear();
        emailInput.sendKeys(GenerateEmailPage.getRandomEmail());
    }

    public void enterPassIntoPassInput() {
        passInput.clear();
        passInput.sendKeys("12312312");
    }

    public void clickToRegisterButton() {
        registerButton.click();
    }

    public boolean isCloseButtonPresent() {
        return isElementDisplayed(closeButton);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            return state;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkExpectedResult(String message, boolean actualResult) {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        element = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        Assert.assertTrue(message, actualResult);
    }
}
