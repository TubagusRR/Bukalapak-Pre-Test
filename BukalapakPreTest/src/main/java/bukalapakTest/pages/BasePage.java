package bukalapakTest.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected AndroidDriver<AndroidElement> androidDriver;
    protected WebDriver webDriver;
    private int maxAlert = 5;

    public BasePage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofMillis(10000)), this);
    }

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AppiumFieldDecorator(webDriver, Duration.ofMillis(5000)), this);
    }

    public boolean ifWebElementPresent(WebElement webElement){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean ifElementPresent(AndroidElement androidElement){
        try{
            WebDriverWait wait = new WebDriverWait(androidDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(androidElement));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private WebElement findWebElementWithId(String id){
        WebElement element = null;
        for (int i = 0; i < maxAlert; i++){
            try{
                element = webDriver.findElement(By.id(id));
                if (ifWebElementPresent(element)) break;
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return element;
    }

    private WebElement findWebElementWithXpath(String xpath){
        WebElement element = null;
        for (int i = 0; i < maxAlert; i++){
            try{
                element = webDriver.findElement(By.xpath(xpath));
                if (ifWebElementPresent(element)) break;
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return element;
    }

    private WebElement findWebViewUsingText(String text, int timeout){
        By by = By.xpath("//*[contains(text(), '"+text+"')]");
        return new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement findWebElementWithXpathWithTimeout(String xpath, int timeOutInSeconds) {
        By by = By.xpath(xpath);
        return new WebDriverWait(webDriver, timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private AndroidElement findElementWUsingIdAndTimeout(String id, int timeout){
        By by = By.id(id);
        return (AndroidElement) (new WebDriverWait(androidDriver, 10).until(ExpectedConditions.presenceOfElementLocated(by)));
    }

    public WebElement findElement(String xpath){
        WebElement element = null;
        try{
            element = webDriver.findElement(By.xpath(xpath));
            if (ifWebElementPresent(element));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return element;
    }

    public AndroidElement findElementUsingId(String id){
        AndroidElement element = null;
        for (int i = 0; i < maxAlert; i++){
            try{
                element = androidDriver.findElement(By.id(id));
                if (ifElementPresent(element)) break;
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return element;
    }

    public AndroidElement findElementUsingText(String text){
        AndroidElement element = null;
        for (int i = 0; i < maxAlert; i++){
            try{
                element = androidDriver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")");
                if (ifElementPresent(element)) break;
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return element;
    }


    public void TypeWebElementWithId(String id, String text){
        findWebElementWithId(id).clear();
        findWebElementWithId(id).sendKeys(text);
    }

    public void TapWebViewWithXpath(String xpath){
        findWebElementWithXpath(xpath).click();
    }


    public void TapWebViewContainsText(String text){
        findWebViewUsingText(text, 5).click();
    }

    public void waitUntilELementFound(WebDriver driver, int secWait, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, secWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void TapViewWithId(String id, int timeout){
        findElementWUsingIdAndTimeout(id, timeout).click();
    }

    public void TypeElementUsingId(String id, String text){
        findElementUsingId(id).clear();
        findElementUsingId(id).sendKeys(text);
    }

    public void sleep(int mils){
        try{
            Thread.sleep(mils);
        }catch (InterruptedException e){

        }
    }

}

