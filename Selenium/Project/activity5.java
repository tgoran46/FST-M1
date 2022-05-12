package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class activity5 {
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
    public void getcolor() throws InterruptedException {
        Thread.sleep(3000);
        WebElement td_Home = driver.findElement(By.xpath("//nav[@role='navigation']"));
        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Navigation bar color is :" +bgColor);
    }
    @AfterTest
    public void afterMethod(){
        driver.close();
    }

}
