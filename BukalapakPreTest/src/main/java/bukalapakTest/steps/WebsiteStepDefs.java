package bukalapakTest.steps;

import bukalapakTest.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WebsiteStepDefs extends BaseClass {


    @Given("^Bukalapak Website Opened$")
    public void Bukalapak_Website_Opened(){
        bukalapakTest.WebregisterPage().AppOpened();
    }

    @Then("^Click Daftar$")
    public void Click_Daftar(){
        bukalapakTest.WebregisterPage().clickRegisterButton();
    }

    @Then("^Fill the Form with Valid Credential$")
    public void Fill_the_Form_with_Valid_Credential(){
        bukalapakTest.WebregisterPage().Register(
                "AjiRl",
                "t021gqwe@gmail.com",
                "aji09aa",
                "asdf123",
                "asdf123"

        );
    }

    @Then("^Fill the Form with invalid Credential$")
    public void Fill_the_Form_with_invalid_Credential(){
        bukalapakTest.WebregisterPage().Register(
                "AjiReki",
                "ajiRekop oqs@gmail.com",
                "ajiRek091",
                "asdf123",
                "asdf123"

        );
    }

    @Then("^Click Agreement$")
    public void Click_Agreement(){
        bukalapakTest.WebregisterPage().clickAgreement();
    }

    @Then("^Click Daftar Button$")
    public void Click_Daftar_Button(){
        bukalapakTest.WebregisterPage().clickDaftar();
    }

    @Given("^Avatar Picture Appear$")
    public void Avatar_Picture_Appear() {
        bukalapakTest.WebregisterPage().VerifyAccountLogged();
    }


    @Given("^Email Alert Showed$")
    public void Email_Alert_Showed() {
        bukalapakTest.WebregisterPage().VerifyInvalidEmail();
    }
}
