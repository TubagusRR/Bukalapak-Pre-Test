package bukalapakTest.steps;

import bukalapakTest.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MobileStepDefs extends BaseClass {

    @Given("^Application Opened$")
    public void Application_Opened(){
        bukalapakTest.MobileregisterPage().AppOpened();
    }

    @Then("^Click Register$")
    public void Click_Register(){
        bukalapakTest.MobileregisterPage().clickRegister();
    }

    @Then("^Fill Register Form with Valid Credential$")
    public void Fill_Register_Form_with_Valid_Credential(){
        bukalapakTest.MobileregisterPage().register(
                "Asdfxfdmqreqpo",
                "asdfopxsd0912@gmail.com",
                "asdf",
                "asdf"
        );
    }

    @Then("^Fill Register Form with InValid Credential$")
    public void Fill_Register_Form_with_InValid_Credential(){
        bukalapakTest.MobileregisterPage().register(
                "Asdfgasd",
                "poaps df@gmail.com",
                "asdf",
                "asdf"
        );
    }

    @Then(("^Click Register Button$"))
    public void Click_Register_Button(){
        bukalapakTest.MobileregisterPage().clickRegisterButton();
    }

    @Given("^Success Snackbar Title Appear$")
    public void Success_Snackbar_Title_Appear(){
        bukalapakTest.MobileregisterPage().verifyRegisterSuccess("Registration Successful");
    }

    @Given("^Email Alert Appear$")
    public void Email_Alert_Appear(){
        bukalapakTest.MobileregisterPage().verifyEmailAlert("Enter Valid Email");
    }
}
