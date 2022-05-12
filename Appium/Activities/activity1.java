
package activities;
        import io.appium.java_client.MobileBy;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.net.MalformedURLException;
        import java.net.URL;

public class activity1 {
    AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.coloros.calculator");
        caps.setCapability("appActivity","com.android.calculator2.Calculator");
        caps.setCapability("noReset","true");

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL, caps);
    }

    @Test
    public void add() {
        // Using resource-id
        driver.findElementById("digit_5").click();
        // Using Accessibility ID
        driver.findElementByAccessibilityId("Multiply").click();
        // Using XPath
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();

        // Perform Calculation
        driver.findElementById("eq").click();

        // Display Result
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);

        // Assertion
        Assert.assertEquals(result, "45");
    }

    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}



