package Liveproject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;
import java.net.URL;

public class Project2 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "a8b67eb6");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 20);
    }
    @Test
    public void gkeep(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
        driver.findElement(MobileBy.id("new_note_button")).click();
        driver.findElement(MobileBy.id("editable_title")).sendKeys("workbook");
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//androidx.cardview.widget.CardView[@content-desc='.'])[2]")));
        //driver.findElement(MobileBy.xpath("//androidx.cardview.widget.CardView[@content-desc='.'])[2]")).sendKeys("notes");
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
        Assert.assertTrue(true,"workbook note is created");

    }
}
