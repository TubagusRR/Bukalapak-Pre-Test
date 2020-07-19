package bukalapakTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    protected static AndroidDriver<AndroidElement> driver;
    protected static WebDriver webDriver;
    protected static BukalapakTest bukalapakTest;

    public String AppPackage = "com.loginmodule.learning";
    public String AppActivity = "com.loginmodule.learning.activities.LoginActivity";


    @Parameters({"module","browser"})
    @BeforeClass
    public void setup(String module, String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (module.equals("app")) {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5");
            caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
            caps.setCapability("noReset", "TRUE");

            caps.setCapability("appPackage", AppPackage);
            caps.setCapability("appActivity", AppActivity);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

            URL url = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AndroidDriver<>(url, caps);
            bukalapakTest = new BukalapakTest(driver);
        }else{
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
                    webDriver = new ChromeDriver();
                    webDriver.manage().window().maximize();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\geckodriver.exe");
                    webDriver = new FirefoxDriver();
                    webDriver.manage().window().maximize();
                    break;
                default:
                    System.out.println("Browser not Found!");
                    break;
            }
            bukalapakTest = new BukalapakTest(webDriver);
        }
    }


    @AfterClass
    public void afterClass(){
        if (webDriver != null){
            webDriver.quit();
        }
        if (driver != null){
            driver.closeApp();
        }
    }
    @Parameters({"module", "browser"})
    @AfterMethod
    public void TearDown(String module, String browser){
        if (module.equals("app")){
            driver.closeApp();
            driver.launchApp();
        }
    }
}
