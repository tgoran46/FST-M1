package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity1 {
     public static void main(String[] args) throws InterruptedException {
         WebDriver driver = new FirefoxDriver();
         driver.get("https://www.training-support.net");

         Thread.sleep(1000);
         driver.close();

     }
}
