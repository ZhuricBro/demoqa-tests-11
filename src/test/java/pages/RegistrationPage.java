package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    //components
    final private CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    final private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateWrapper = $("#react-select-3-input"),
            cityWrapper = $("#react-select-4-input"),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");


    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;

    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText("Other")).click();

        return this;

    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;

    }

    public RegistrationPage setSubjects(String subject1, String subject2) {
        subjectsInput.setValue(subject1).pressEnter();
        subjectsInput.setValue(subject2).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String hobby1, String hobby2) {
        hobbiesWrapper.$(byText("Sports")).click();
        hobbiesWrapper.$(byText("Music")).click();

        return this;

    }

    public RegistrationPage setUploadPicture(String myPicture) {
        uploadPicture.uploadFromClasspath("testscreen.jpg");

        return this;

    }

    public RegistrationPage setCurrentAddress(String myAddress) {
        currentAddress.setValue(myAddress);

        return this;

    }


    public RegistrationPage setState(String myState) {
        stateWrapper.setValue(myState).pressEnter();

        return this;

    }


    public RegistrationPage setCity(String myCity) {
        cityWrapper.setValue(myCity).pressEnter();

        return this;

    }



    public RegistrationPage setSubmit() {
        submitClick.pressEnter();

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.parent().shouldHave(text(value));

        return this;

    }
}
