package LiveProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class activity1 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void testCase1() {
        //This test case will pass

        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "SuiteCRM");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}


