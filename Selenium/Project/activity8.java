package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity8 {
    WebDriver driver;
    @BeforeTest
    public void BeforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void login() throws InterruptedException {
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@name='Login']")).click();
    }
    @Test(priority = 2)
    public void Traversing() throws InterruptedException {
        Thread.sleep(7000);
        Actions act = new Actions(driver);
        WebElement sales = driver.findElement(By.id("grouptab_0"));
        act.moveToElement(sales).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts")));
        driver.findElement(By.linkText("Accounts")).click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println("page title is: " + title);
        Assert.assertEquals("Accounts » SuiteCRM" , title);
        Thread.sleep(3000);

        for (int k=1;k<=10;k++) {
            if (k%2!= 0) {
                Thread.sleep(3000);
                System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+k+"]/td[3]/b/a")).getText());
            }

        }
    }
    @AfterTest
    public void afterMethod(){
        driver.close();
    }
}
