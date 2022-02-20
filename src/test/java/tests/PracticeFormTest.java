package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void PracticeForm() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("ya@tisobaka.com");
        $(byText("Other")).click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(10);
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("testscreen.jpg");
        $("#currentAddress").setValue("ulica pushkina, dom kolotushkina");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanova"),
                text("ya@tisobaka.com"),
                text("Other"),
                text("8005553535"),
                text("04 November,1993"),
                text("Chemistry, Maths"),
                text("Sports, Music"),
                text("testscreen.jpg"),
                text("ulica pushkina, dom kolotushkina"),
                text("Haryana Panipat"));
    }
}



