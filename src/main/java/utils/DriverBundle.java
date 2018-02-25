package utils;

import enums.BROWSERS;
import enums.PLATFORMS;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import utils.PropertyHandler;

import java.net.URL;
import java.util.Properties;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.CapabilityType.*;


public class DriverBundle {
    private static volatile AppiumDriver driverSingleton;
    private static volatile WebDriverWait waitSingleton;
    private static ITestContext testContext;
    private static String baseURL;


    public static void init(ITestContext context) {
        testContext = context;
        prepareDriver();
    }

    public static AppiumDriver getDriver() {
        if (driverSingleton == null) {
            synchronized (DriverBundle.class) {
                if (driverSingleton == null) {
                    prepareDriver();
                }
            }
        }
        return driverSingleton;
    }

    public static WebDriverWait getWaiter() {
        if (waitSingleton == null) {
            synchronized (DriverBundle.class) {
                if (waitSingleton == null)
                    prepareDriver();
            }
        }
        return waitSingleton;
    }

    public static String getBaseUrl() {
        return baseURL;
    }

    private DriverBundle() {
    }

    @SneakyThrows
    static private void prepareDriver() {
        if (testContext == null)
            throw new Exception("Test context missing. Member access before initiation/TestNG config missing");

        Properties properties = PropertyHandler
                .assembleProperties(testContext.getCurrentXmlTest().getParameter("config"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browserName;

        capabilities.setCapability(PLATFORM_NAME, properties.getProperty(PLATFORM_NAME));
        capabilities.setCapability(DEVICE_NAME, properties.getProperty(DEVICE_NAME));

        String platform = properties.getProperty(PLATFORM_NAME, null);

        if (platform.equalsIgnoreCase(PLATFORMS.ANDROID.getName())) {
            browserName = BROWSERS.CHROME.getName();
        } else if (platform.equalsIgnoreCase(PLATFORMS.IOS.getName())) {
            browserName = BROWSERS.SAFARI.getName();
        } else throw new Exception("Unknown mobile platform");

        if (properties.containsKey("sut") && !properties.containsKey(APP)) {
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else if (!properties.containsKey("sut") && properties.containsKey(APP)) {
            capabilities.setCapability(APP, properties.getProperty(APP));
        } else throw new Exception("Unclear type of application");

        baseURL = properties.getProperty("sut", null);
        driverSingleton = new AppiumDriver(new URL(properties.getProperty("host")), capabilities);
        waitSingleton = new WebDriverWait(driverSingleton, 10);
    }
}
