import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.net.URL;


public class RunnerTestIOS {

        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testName = "Untitled";

        IOSDriver<WebElement> driver = null;
        DesiredCapabilities dc = new DesiredCapabilities();

        @BeforeMethod
        public void setUp () throws MalformedURLException {
            dc.setCapability("reportDirectory", reportDirectory);
            dc.setCapability("reportFormat", reportFormat);
            dc.setCapability("testName", testName);
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
//            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
            dc.setCapability(MobileCapabilityType.UDID, "68294f718f248e5cfafb071944afea95e7892553");
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.pandora");
            dc.setCapability("launchTimeout", "5000");
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        }

        @Test
        public void testFacebookShare () {
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("My Music")));
            driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='station image'])[1]")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeButton[@class='UIAButton'])[1]")));
            driver.findElement(By.id("share option")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("Copy Link")));
            driver.findElement(By.id("Facebook")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("Say something about this...")));
            driver.findElement(By.name("Post")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeButton[@class='UIAButton'])[1]")));
            Assert.assertTrue(driver.findElement(By.xpath("(//XCUIElementTypeButton[@class='UIAButton'])[1]")).isDisplayed(), "Share was unsuccessful");
        }

    @Test
    public void testTwitterShare () {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("My Music")));
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='station image'])[1]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//XCUIElementTypeButton[@class='UIAButton'])[1]")));
        driver.findElement(By.id("share option")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("Copy Link")));
        driver.findElement(By.id("Twitter")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("ComposeSendTweetButton")));
        driver.findElement(By.id("ComposeSendTweetButton")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Return to Pandora']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//XCUIElementTypeButton[@class='UIAButton'])[1]")).isDisplayed(), "Share was unsuccessful");
    }

        @AfterMethod
        public void tearDown () {
            driver.quit();
        }
}
