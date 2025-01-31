package utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotHelper {
    public static void takeScreenshot(IOSDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + ".png";
        try {
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(srcFile.toPath(), Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}