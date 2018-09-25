import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rraffi on 9/24/18.
 */
public class RunnerTestAndroid {

    String reportDirectory = "reports";
    String reportFormat = "xml";
    String testName = "Untitled";

    AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp () throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
//            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        dc.setCapability(MobileCapabilityType.UDID, "192.168.56.101:5555");
//            dc.setCapability(MobileCapabilityType.APP, "/Users/rraffi/Workspace/mobile-test/builds/Pandora.app");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.pandora.android");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.pandora.android.Main");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @Test
    public void testUntitled () {


    }

    @AfterTest
    public void tearDown () {
//        driver.quit();
    }
}
