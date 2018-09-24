import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.net.URL;


public class RunnerTestIOS {

        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testName = "Untitled";

        IOSDriver<IOSElement> driver = null;
        DesiredCapabilities dc = new DesiredCapabilities();

        @BeforeTest
        public void setUp () throws MalformedURLException {
            dc.setCapability("reportDirectory", reportDirectory);
            dc.setCapability("reportFormat", reportFormat);
            dc.setCapability("testName", testName);
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
//            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
//            dc.setCapability(IOSMobileCapabilityType.);
            dc.setCapability(MobileCapabilityType.UDID, "94213A33-EACB-4F01-B295-A13366180FF5");
//            dc.setCapability(MobileCapabilityType.APP, "/Users/rraffi/Workspace/mobile-test/builds/Pandora.app");
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.pandora");
            dc.setCapability("launchTimeout", "5000");
            driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        }

        @Test
        public void testUntitled () {


        }

        @AfterTest
        public void tearDown () {
            driver.quit();
        }
}
