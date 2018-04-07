import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;


public class Runner {

    String reportDirectory = "reports";
    String reportFormat = "xml";
    String testName = "Untitled";
    IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "d7ee38fac7b2e2ceb592165c7a57f6aba1887952");
        dc.setCapability("instrumentApp", true);    //DesiredCapability to instrument the app
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testUntitled() {
        driver.executeScript("client:client.setDevice(\"ios_app:Riaz2\")");
        driver.executeScript("client:client.launch(\"com.homedepot.homeservices.selling.qa.planning\", \"true\", \"true\")");
        if(driver.findElement(By.xpath("//*[@text='Reset Password']"))!=null)
        {
            driver.findElement(By.xpath("//*[@text='Reset Password']")).click();
            System.out.println("Found Element");
        }


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
