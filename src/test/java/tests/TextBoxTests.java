package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.text;
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
               subjectsInput = "Economics",
               currentAddress = "some user address 74",
                month = "May",
                year = "1998",
                day = "14",
                site_url = "https://demoqa.com/automation-practice-form",
                picture = "src/test/resources/img/HP_G8.PNG",
                state = "Haryana",
                city = "Karnal";

        open(site_url);

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=gender-radio-1]").parent().click();
        $("[id=userNumber]").setValue(userNumber);

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label='Choose Thursday, May 14th, 1998']").click();

        $("[id=subjectsInput]").setValue(subjectsInput).pressEnter();
        $("[id=hobbies-checkbox-1]").parent().click();
        $("#uploadPicture").uploadFile(new File(picture));
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=state]").parent().click();
        $(byText(state)).click();
        $("[id=city]").parent().click();
        $(byText(city)).click();
        $("[id=submit]").click();

        $(".table").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber),
                text("Male"), text(day + " " + month + "," + year), text(subjectsInput), text("Sports"), text("HP_G8.PNG"),
                text(currentAddress), text(state + " " + city));
        $("[id=closeLargeModal]").click();
    }
}