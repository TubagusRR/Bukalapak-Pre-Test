package bukalapakTest.pages.android;

import bukalapakTest.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class MobileRegisterPage extends BasePage {

    public MobileRegisterPage(AndroidDriver<AndroidElement> andriodDriver){
        super(andriodDriver);
    }

    @AndroidFindBy(id = "com.loginmodule.learning:id/snackbar_text")
    private AndroidElement snackbarAlert;

    public void AppOpened(){findElementUsingId("textViewLinkRegister").isDisplayed();}

    public void clickRegister(){
        TapViewWithId("textViewLinkRegister",10);
    }

    public void fillName(String name){
        TypeElementUsingId("textInputEditTextName" ,name);
    }

    public void fillEmail(String email){
        TypeElementUsingId("textInputEditTextEmail",email);
    }

    public void fillPassword(String password){
        TypeElementUsingId("textInputEditTextPassword", password);
    }

    public void fillConfirmPassword(String confirmpassword){
        TypeElementUsingId("textInputEditTextConfirmPassword", confirmpassword);
    }

    public void clickRegisterButton(){
        TapViewWithId("appCompatButtonRegister",5);
    }

    public void verifyRegisterSuccess(String snackBarTitle){
        MobileElement snackBar = findElementUsingId("com.loginmodule.learning:id/snackbar_text");
        String ExpectedTitle = snackBarTitle;
        String ActualTitle = snackBar.getText();
        try{
            if (snackBar != null){
                Assert.assertEquals(ExpectedTitle, ActualTitle);
                System.out.println("Snackbar Title Correct");
                System.out.println("Expected Result :"+" "+ snackBarTitle);
                System.out.println("Actual Result :"+" "+ ActualTitle);
            }else{
                System.out.println("Snackbar Title Incorrect");
            }
        }catch (NoSuchElementException e){
            System.out.println("Expected Result :"+" "+ snackBarTitle);
            System.out.println("Actual Result :"+" "+ ActualTitle);
        }
    }

    public void verifyEmailAlert(String alertEmail){
        MobileElement alert = findElementUsingText("Enter Valid Email");
        String ExpectedAlert = alertEmail;
        String ActualAlert = alert.getText();
        try {
            if (alert != null) {
                Assert.assertEquals(ExpectedAlert, ActualAlert);
                System.out.println("Email Alert Correct");
                System.out.println("Expected Result : " + " " + ExpectedAlert);
                System.out.println("Actual Result : " + " " + ActualAlert);
            } else {
                System.out.println("Alert Incorrect");
            }
        }catch (NoSuchElementException e){
                System.out.println("Expected Result : " + " " + ExpectedAlert);
                System.out.println("Actual Result : " + " " + ActualAlert);
        }
    }

    public void register(String name, String email, String password, String confirmpassword){
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmpassword);
    }
}
