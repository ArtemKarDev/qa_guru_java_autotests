package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTests() {

        registrationPage.openPracticeFormPage()
                .setFirstName("Jimmy")
                .setLastName("Recard")
                .setEmail("JimmyRecard@good.boy")
                .setGender("Male")
                .setPhone("9997775533")
                .setDateOfBirth("30","July","2008")
                .setSubjects("Computer Science")
                .setHobbies("Music")
                .setPicture("images/img.jpg")
                .setAddress("Some street 1")
                .setState("NCR")
                .setCity("Noida")
                .submitClick();

        registrationPage.checkResult("Student Name","Jimmy Recard")
                .checkResult("Student Email","JimmyRecard@good.boy")
                .checkResult("Gender","Male")
                .checkResult("Mobile","9997775533")
                .checkResult("Date of Birth","30 July,2008")
                .checkResult("Subjects","Computer Science")
                .checkResult("Hobbies","Music")
                .checkResult("Picture","img.jpg")
                .checkResult("Address","Some street 1")
                .checkResult("State and City","NCR Noida");
    }

    @Test
    void notFullDataRegistrationTest(){
        registrationPage.openPracticeFormPage()
                .setFirstName("Jimmy")
                .setLastName("Recard")
                .setGender("Male")
                .setPhone("9997775533")
                .submitClick();

        registrationPage.checkResult("Student Name","Jimmy Recard")
                .checkResult("Student Email"," ")
                .checkResult("Gender","Male")
                .checkResult("Mobile","9997775533")
                .checkResult("Date of Birth"," ")
                .checkResult("Subjects"," ")
                .checkResult("Address"," ");

    }

    @Test
    void notFillRequiredFieldsTest(){
            registrationPage.openPracticeFormPage()
                            .submitClick()
                            .checkModalFormNotDisplayed()
                            .checkEmptyFirstNameAfterSubmited();
    }

}

