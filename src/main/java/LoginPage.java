package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

public class LoginPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "email")
    @iOSXCUITFindBy(accessibility = "email")
    private WebElement emailField;  // ✅ Reemplazado MobileElement → WebElement

    @AndroidFindBy(id = "password")
    @iOSXCUITFindBy(accessibility = "password")
    private WebElement passwordField;  // ✅ Reemplazado MobileElement → WebElement

    @AndroidFindBy(id = "loginButton")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private WebElement loginButton;  // ✅ Reemplazado MobileElement → WebElement

    @AndroidFindBy(id = "message")
    @iOSXCUITFindBy(accessibility = "message")
    private WebElement messageLabel;  // ✅ Reemplazado MobileElement → WebElement

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageLabel));
        return messageLabel.getText();
    }
}