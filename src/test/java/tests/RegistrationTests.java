package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;
import java.util.Random;

public class RegistrationTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    Locale locale = new Locale("en");
    Faker faker = new Faker(locale);
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = RandomUtils.getRandomGender();
    String userPhone = RandomUtils.getRandomPhone();
    String setDay = Integer.toString(RandomUtils.getRandomInt(1,30));

    String streetAddress = faker.address().streetAddress();


    @Test
    void successfulRegistrationTests() {

        registrationPage.openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setDateOfBirth(setDay,"July","2008")
                .setSubjects("Computer Science")
                .setHobbies("Music")
                .setPicture("images/img.jpg")
                .setAddress(streetAddress)
                .setState("NCR")
                .setCity("Noida")
                .submitClick();

        registrationPage.checkResult("Student Name",firstName+' '+lastName)
                .checkResult("Student Email",userEmail)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userPhone)
                .checkResult("Date of Birth", setDay+" July,2008")
                .checkResult("Subjects","Computer Science")
                .checkResult("Hobbies","Music")
                .checkResult("Picture","img.jpg")
                .checkResult("Address",streetAddress)
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

