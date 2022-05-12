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
import java.util.List;

public class activity9 {
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
    public void popup() throws InterruptedException {
        Thread.sleep(4000);
        Actions act = new Actions(driver);
        WebElement sales = driver.findElement(By.id("grouptab_0"));
        act.moveToElement(sales).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Leads")));
        driver.findElement(By.linkText("Leads")).click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("page title is: " + title);
        Assert.assertEquals("Leads » SuiteCRM" , title);
        //List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/thead/tr[1]/th[3]/div/a/text()"));
        //System.out.println("No.of Colms "+ col.size());
        Thread.sleep(2000);
        for (int i=1;i<=10;i++)
        {
            System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/b/a")).getText());
            System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]/a")).getText());
        }

    }
    @AfterTest
    public void afterMethod(){
        driver.close();
    }

}
