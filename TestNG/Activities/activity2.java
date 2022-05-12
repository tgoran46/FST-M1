package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class activity2 {
    WebDriver driver;
    @BeforeTest
    public void beforeMethod() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        Thread.sleep(3000);
    }

    @Test
    public void testCase1()  {
        //This test case will pass

        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals("Target Practice", title);
    }

    @Test
    public void testCase2() throws InterruptedException {
        //This test case will Fail
        Thread.sleep(3000);
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
