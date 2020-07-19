package bukalapakTest.runner;

import bukalapakTest.BaseClass;
import bukalapakTest.BukalapakTest;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports","json:target/report/cucumber2.json","de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"},
        glue = { "steps" }
)

public class TestRunner extends BaseClass {
    private TestNGCucumberRunner testNGCucumberRunner;
    @Before({"@Website"})
    public void SetUpCucumber() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://www.bukalapak.com/");
        Thread.sleep(2000);
        bukalapakTest = new BukalapakTest(webDriver);
    }

    @Before({"@Android"})
    public void SetUpMobile() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
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
    }


    @After({"@Website", "@Android"})
    public void afterTest(){
        if (driver != null){
            driver.resetApp();
        }

        if (webDriver != null){
            webDriver.manage().deleteAllCookies();
        }
    }

}

