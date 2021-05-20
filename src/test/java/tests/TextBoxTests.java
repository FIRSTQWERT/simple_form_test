package tests;

import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.SelenideElement;
//import com.codeborne.selenide.commands.Click;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        String firstName = "Firstname",
               lastName = "Lastname",
               userEmail = "test@test.ru",
               userNumber = "1234567890",
               subjectsInput = "some Subjects",
               currentAddress = "some user address 74";
        //String firstName = "some user";

        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=gender-radio-1]").parent().click();
        $("[id=userNumber]").setValue(userNumber);

        //dateOfBirthInput
        //$("[id=dateOfBirthInput]").setDateByName("recurrent.startDate", "16.01.2009");

        //subjectsContainer
        $("[id=subjectsInput]").setValue(subjectsInput);

        //hobbies-checkbox-1
        $("[id=hobbies-checkbox-1]").parent().click();

        //uploadPicture
        $("#uploadPicture").uploadFile(new File("src/test/java/tests/HP_G8.PNG"));

        $("[id=currentAddress]").setValue(currentAddress);

        $("[id=state]").parent().click();
        $(byText("Haryana")).click();
        $("[id=city]").parent().click();
        $(byText("Karnal")).click();

        $("[id=submit]").click();

        $(".table").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber), text("Male"),
                text("20 May,2021"), text("Sports"), text("HP_G8.PNG"), text(currentAddress), text("Haryana Karnal"));

        //closeLargeModal
        $("[id=closeLargeModal]").click();

    }




}
