package bukalapakTest.pages.web;

import bukalapakTest.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebsiteRegisterPage extends BasePage
{

    public WebsiteRegisterPage(WebDriver webDriver){
        super(webDriver);
    }

    public void goTo(String url){
        webDriver.navigate().to(url);
        sleep(1000);
    }

    public void AppOpened(){
       webDriver.findElement(By.xpath("//p[@class='pr-4 sigil-header__nav-action bl-text bl-text--body-small bl-text--semi-bold']")).isDisplayed();
    }

    public void clickRegisterButton(){
        TapWebViewWithXpath("//p[@class='pr-4 sigil-header__nav-action bl-text bl-text--body-small bl-text--semi-bold']");
        sleep(2000);
    }


    public void fillName(String Name){
        TypeWebElementWithId("user_name", Name);
    }

    public void fillEmailorPhone(String EmailorPhone){
        TypeWebElementWithId("email_or_phone", EmailorPhone);
    }

    public void choseGender(){
        TapWebViewWithXpath("//span[@class='c-inp__inner-lbl c-inp__inner-lbl--red']");
    }

    public void fillUserName(String Username){
        TypeWebElementWithId("user_username", Username);
    }

    public void fillPassword(String Password){
        TypeWebElementWithId("user_password", Password);
    }

    public void fillConfirmPassword(String ConfirmPassword){
        TypeWebElementWithId("user_password_confirmation", ConfirmPassword);
    }

    public void clickAgreement() {
//        tapWebViewWithXpath("//span[@class='c-inp__inner-lbl js-check-select__item--custom']");
        TapWebViewContainsText("Saya telah membaca dan menyetujui");

    }

    public void clickDaftar(){
        TapWebViewWithXpath("//button[@class='btn u-mrgn-top--3 c-btn c-btn--large c-btn--red c-btn--block u-mrgn-bottom--4 js-reg-submit-button']");

    }

    public void clickLogout(){
        TapWebViewContainsText("Logout");
    }


    public void VerifyAccountLogged(){
        waitUntilELementFound(webDriver, 30, "//div[@class='bl-flex-container align-items-center']");
        sleep(2000);
        TapWebViewWithXpath("//div[@class='bl-avatar sigil-avatar']");
        WebElement ava = findElement("//div[@class='bl-flex-container mb-20 align-items-center']");
        try {
            if (ava != null) {
                System.out.println("Element Appear");
            } else {
                System.out.println("Element Disappear");
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void VerifyInvalidEmail(){
        WebElement alert = findElement("//div[@class='c-fld__error']");
        try {
            if (alert != null) {
                System.out.println("Alert Appear");
            } else {
                System.out.println("Alert not Appear");
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void Register(String Name, String EmailorPhone, String Username, String Password, String ConfirmPassword){
        fillName(Name);
        fillEmailorPhone(EmailorPhone);
        choseGender();
        fillUserName(Username);
        fillPassword(Password);
        fillConfirmPassword(ConfirmPassword);
    }


}
