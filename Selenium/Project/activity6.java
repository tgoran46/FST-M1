package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class activity6 {
    WebDriver driver;
    @BeforeTest
    public void BeforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }
    @Test(priority = 1)
    public void login(){
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@name='Login']")).click();

    }
    @Test(priority = 2)
    public void menuitem() throws InterruptedException {
        Thread.sleep(3000);
        WebElement Navigation = driver.findElement(By.xpath("//nav[@role='navigation']"));
        WebElement Activities = driver.findElement(By.id("grouptab_3"));
        Actions move = new Actions(driver);
        move.moveToElement(Navigation).build().perform();
        Boolean Activitiespresence =  Activities.isDisplayed();
        Assert.assertTrue(Activitiespresence);
        System.out.println("Activities is displayed");


    }
    @AfterTest
    public void afterMethod(){
        driver.close();
    }
}
