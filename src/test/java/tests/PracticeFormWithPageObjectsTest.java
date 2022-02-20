package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithPageObjectsTest {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstname = "Ivan";
    String lastname = "Ivanova";
    String userEmail = "ya@tisobaka.com";
    String gender = "Other";
    String userNumber = "8005553535";
    String day = "04";
    String month = "November";
    String year = "1993";
    String subject1 = "Chemistry";
    String subject2 = "Maths";
    String hobby1 = "Sports";
    String hobby2 = "Music";
    String myPicture = "testscreen.jpg";
    String myState = "Haryana";
    String myCity = "Panipat";
    String myAddress = "ulica pusklina, dom kolotushkina";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void PracticeForm() {
        registrationPage.openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubject1(subject1)
                .setSubject2(subject2)
                .setHobby1(hobby1)
                .setHobby2(hobby2)
                .setUploadPicture(myPicture)
                .setCurrentAddress(myAddress)
                .setState(myState)
                .setCity(myCity)
                .setSubmit();

        registrationPage.checkForm("Student name", firstname + " " + lastname)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subject1 + ", " + subject2)
                .checkForm("Hobbies", hobby1 + ", " + hobby2)
                .checkForm("Picture", myPicture)
                .checkForm("Address", myAddress)
                .checkForm("State and City", myState + " " + myCity);


    }
}



