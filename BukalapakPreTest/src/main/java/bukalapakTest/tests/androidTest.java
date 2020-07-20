package bukalapakTest.tests;

import bukalapakTest.BaseClass;
import org.testng.annotations.Test;

public class androidTest extends BaseClass {

    @Test(priority = 1)
    public void RegisterPositiveCase(){
        bukalapakTest.MobileregisterPage().clickRegister();
        bukalapakTest.MobileregisterPage().register(
                "Testingasdfzw",
                "Testing123203@gmail.com",
                "asdfghjkl",
                "asdfghjkl"
        );
        bukalapakTest.MobileregisterPage().clickRegisterButton();
        bukalapakTest.MobileregisterPage().verifyRegisterSuccess("Registration Successful");

    }

    @Test(priority = 2)
    public void RegisterNegativeCase(){
        bukalapakTest.MobileregisterPage().clickRegister();
        bukalapakTest.MobileregisterPage().register(
                "Testing",
                "Testing32 1@gmail.com",
                "asdfghjkl",
                "asdfghjkl"
        );
        bukalapakTest.MobileregisterPage().clickRegisterButton();
        bukalapakTest.MobileregisterPage().verifyEmailAlert("Enter Valid Email");
    }

}
