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

import javax.lang.model.element.Element;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Project1 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "a8b67eb6");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void tasks() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")));
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")).click();
        Thread.sleep(1000);
        driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(MobileBy.id("add_task_done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")));
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")).click();
        Thread.sleep(1000);
        driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(MobileBy.id("add_task_done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")));
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Create new task']")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(MobileBy.id("add_task_done")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));
        List<MobileElement> tasks = driver.findElements(MobileBy.id("task_name"));
        System.out.println(tasks.size());
        String task1 = tasks.get(0).getText();

        String task2 = tasks.get(1).getText();
        String task3 = tasks.get(2).getText();
        Assert.assertEquals(task3,"Complete Activity with Google Tasks");
        Assert.assertEquals(task2,"Complete Activity with Google Keep");
        Assert.assertEquals(task1,"Complete the second Activity Google Keep");


    }
}
