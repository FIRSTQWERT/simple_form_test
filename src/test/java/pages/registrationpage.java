package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class registrationpage {
    SelenideElement firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("[id=userEmail]"),
            userNumberInput = $("[id=userNumber]"),
            currentAddressInput = $("[id=currentAddress]");

    public void typefirstName(String value){
        firstNameInput.val(value);
    }
    public void typelastName(String value){
        lastNameInput.val(value);
    }
    public void typeuserEmail(String value){
        userEmailInput.val(value);
    }
    public void typeuserNumber(String value){
        userNumberInput.val(value);
    }
    public void typecurrentAddress(String value){
        currentAddressInput.val(value);
    }
}
