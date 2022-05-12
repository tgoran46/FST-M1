package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

import java.util.List;
import java.util.ArrayList;


public class activity7 {
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

        //driver.findElement(By.xpath("//span[@id='adspan_83ba2d6a-f005-9be4-5153-6006b98c602d']")).click();
        //List<WebElement> addinfo = driver.findElements(By.xpath("//span[@title='Additional Details']"));
        //System.out.println(addinfo);
        WebDriverWait info = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Additional Details']")));
        List<WebElement> addinfo = driver.findElements(By.xpath("//span[@title='Additional Details']"));
        //List<WebElement> addinfo=new ArrayList<WebElement>(driver.findElements(By.xpath("//span[@title='Additional Details']")));
        //for( WebElement additionalinfo : addinfo) {

           // System.out.println(additionalinfo.getText());


            //System.out.println(addinfo);
        //}
        System.out.println(addinfo.get(1).getAttribute("title"));
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]/span[1]/span[1]")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Additional Details')]/following::span[@class='phone']")).getText());
/*
//and @xpath='5'
//div[contains(text(),'Additional Details')]/following::span[@class='phone']
 */

    }
    @AfterTest
    public void afterMethod(){
        driver.close();
    }

}
