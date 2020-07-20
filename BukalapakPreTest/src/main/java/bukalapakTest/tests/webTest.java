package bukalapakTest.tests;

import bukalapakTest.BaseClass;
import org.testng.annotations.Test;

public class webTest extends BaseClass {
    @Test(priority = 1)
    public void RegisterPositiveCase(){
        bukalapakTest.WebregisterPage().goTo("https://www.bukalapak.com/");
        bukalapakTest.WebregisterPage().clickRegisterButton();
        bukalapakTest.WebregisterPage().Register(
                "TestingPr28",
                "uhywqwqrq@gmail.com",
                "pre974",
                "testingpre10",
                "testingpre10");
        bukalapakTest.WebregisterPage().clickAgreement();
        bukalapakTest.WebregisterPage().clickDaftar();
        bukalapakTest.WebregisterPage().VerifyAccountLogged();
        bukalapakTest.WebregisterPage().clickLogout();
    }

    @Test(priority = 2)
    public void RegisterNegativeCase(){
        bukalapakTest.WebregisterPage().goTo("https://www.bukalapak.com/");
        bukalapakTest.WebregisterPage().clickRegisterButton();
        bukalapakTest.WebregisterPage().Register(
                "TestingPr1",
                "uhuhuhy q@gmail.com",
                "testingpr99",
                "testingpre4",
                "testingpre4");
        bukalapakTest.WebregisterPage().clickAgreement();
        bukalapakTest.WebregisterPage().clickDaftar();
        bukalapakTest.WebregisterPage().VerifyInvalidEmail();
    }
}
