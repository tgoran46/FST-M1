package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class activity3 {

    WebDriver driver;
    @BeforeTest
    public void BeforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void testFooter(){
        driver.getCurrentUrl();
        driver.findElement(By.linkText("© Supercharged by SuiteCRM")).getText();
        System.out.println( driver.findElement(By.linkText("© Supercharged by SuiteCRM")).getText());
    }
    @AfterTest
    public void afterMethod(){
        driver.close();
    }



}
