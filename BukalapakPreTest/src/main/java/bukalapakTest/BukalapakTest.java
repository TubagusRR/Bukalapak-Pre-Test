package bukalapakTest;

import bukalapakTest.pages.android.MobileRegisterPage;
import bukalapakTest.pages.web.WebsiteRegisterPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;

public class BukalapakTest {
    private AndroidDriver<AndroidElement> androidDriver;
    private WebDriver webDriver;

    public BukalapakTest(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
    }

    public BukalapakTest(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebsiteRegisterPage WebregisterPage(){
        return new WebsiteRegisterPage(webDriver);
    }

    public MobileRegisterPage MobileregisterPage(){
        return new MobileRegisterPage(androidDriver);
    }
}
