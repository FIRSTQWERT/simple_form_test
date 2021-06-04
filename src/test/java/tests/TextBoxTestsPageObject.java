package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.registrationpage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTestsPageObject {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = "1234567890",
            subjectsInput = "Economics",
            currentAddress = faker.address().fullAddress(),
            month = "May",
            year = "1998",
            day = "14",
            site_url = "https://demoqa.com/automation-practice-form",
            picture = "src/test/resources/img/HP_G8.PNG",
            state = "Haryana",
            city = "Karnal";

    registrationpage registrationpage = new registrationpage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {

        open(site_url);

        registrationpage.typefirstName(firstName);
        registrationpage.typelastName(lastName);
        registrationpage.typeuserEmail(userEmail);
        $("[id=gender-radio-1]").parent().click();
        registrationpage.typeuserNumber(userNumber);

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label='Choose Thursday, May 14th, 1998']").click();

        $("[id=subjectsInput]").setValue(subjectsInput).pressEnter();
        $("[id=hobbies-checkbox-1]").parent().click();
        $("#uploadPicture").uploadFile(new File(picture));
        registrationpage.typecurrentAddress(currentAddress);
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