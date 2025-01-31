package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
    private AppiumDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS"); // Cambia a "Android" si es necesario
        caps.setCapability("deviceName", "iPhone 14"); // Cambia según tu dispositivo
        caps.setCapability("app", "/ruta/a/tu/app.app"); // Cambia a .apk para Android
        caps.setCapability("automationName", "XCUITest"); // Cambia a "UiAutomator2" para Android

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps); // Cambia a AndroidDriver para Android
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccess() {
        loginPage.login("usuario@example.com", "contraseña123");
        Assert.assertEquals(loginPage.getMessage(), "Welcome, [User]!");
    }

    @Test
    public void testLoginInvalidEmail() {
        loginPage.login("incorrecto@example.com", "contraseña123");
        Assert.assertEquals(loginPage.getMessage(), "Invalid email or password.");
    }

    @Test
    public void testLoginInvalidPassword() {
        loginPage.login("usuario@example.com", "incorrecta");
        Assert.assertEquals(loginPage.getMessage(), "Invalid email or password.");
    }

    @Test
    public void testLoginEmptyFields() {
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getMessage(), "Please fill out this field.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}