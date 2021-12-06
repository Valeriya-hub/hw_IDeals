package classic_page_object.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenide_page_object.pages.GenerateEmailPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebElement element;
    private final WebDriver driver;
    WebDriverWait webDriverWait;

    @FindBy(className = "icon-user")
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
        webDriverWait = new WebDriverWait(driver, 20);
    }


    public void clickToRegistrationIcon() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationIcon));
        registrationIcon.click();
    }

    public void clickToRegistrationTab() {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationTab));
        registrationTab.click();
    }

    public void enterNameIntoNameInput(String name) {
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationTab));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmailIntoEmailInput() {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(GenerateEmailPage.getRandomEmail());
    }

    public void enterPassIntoPassInput() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passInput));
        passInput.clear();
        passInput.sendKeys("12312312");
    }

    public void clickToRegisterButton() {
        registerButton.click();
    }

    public boolean isCloseButtonPresent() {
        webDriverWait.until(ExpectedConditions.visibilityOf(closeButton));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(closeButton));
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

    public boolean checkExpectedResult(String message, boolean actualResult) {//, WebElement element
       return isElementDisplayed(closeButton);
    }
}
