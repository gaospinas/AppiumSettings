package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static IOSDriver driver;

    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "gospina");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "18.2.1");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("udid", "00008101-000175060AE1001E");
        caps.setCapability("bundleId", "com.abacenters.mobile-connect-emr");  // ✅ Corregido
        caps.setCapability("app", "/Users/gospina/Downloads/Mobile Connect User Acceptance Testing 2025-01-29 19-17-04/Apps/Mobile Connect.ipa");

        caps.setCapability("noReset", true);

        String appiumServerUrl = "http://127.0.0.1:4723";
        System.out.println("Conectando a Appium en: " + appiumServerUrl);
        driver = new IOSDriver(new URL(appiumServerUrl), caps);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static IOSDriver getDriver() {
        return driver;
    }
}