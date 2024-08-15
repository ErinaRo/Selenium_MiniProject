/*
package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

    public class Screenshoot {

        public static void takeScreenshot(WebDriver driver, String fileName) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
*/
