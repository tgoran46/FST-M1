package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class activity2 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test
    public void testTitle(){
        WebElement l =driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        System.out.println("Src attribute is: "+ l.getAttribute("src"));

    }
    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
