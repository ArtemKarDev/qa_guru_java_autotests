package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;
import utils.RandomUtils;

import java.util.Locale;
import java.util.Random;

public class RegistrationTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();
    Locale locale = new Locale("en");
    Faker faker = new Faker(locale);
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = RandomUtils.getRandomItem(registrationPage.GENDER);
    String userPhone = RandomUtils.getRandomPhone();
    String setDay = Integer.toString(RandomUtils.getRandomInt(1,30));
    String setMonth = RandomUtils.getRandomItem(calendarComponent.MONTH);
    String setYear = Integer.toString(RandomUtils.getRandomInt(2000,2010));
    String setSubject = RandomUtils.getRandomItem(registrationPage.SUBJECTS);
    String setHobbies = RandomUtils.getRandomItem(registrationPage.HOBBIES);
    int stateIndex = RandomUtils.getRandomInt(0,registrationPage.STATES.length);
    String setState = registrationPage.STATES[stateIndex];
    String setCity = RandomUtils.getRandomItem(registrationPage.CITIES[stateIndex]);



    String streetAddress = faker.address().streetAddress();


    @Test
    void successfulRegistrationTests() {

        registrationPage.openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setDateOfBirth(setDay,setMonth,setYear)
                .setSubjects(setSubject)
                .setHobbies(setHobbies)
                .setPicture("images/img.jpg")
                .setAddress(streetAddress)
                .setState(setState)
                .setCity(setCity)
                .submitClick();

        registrationPage.checkResult("Student Name",firstName+' '+lastName)
                .checkResult("Student Email",userEmail)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userPhone)
                .checkResult("Date of Birth", setDay+" "+ setMonth + "," + setYear)
                .checkResult("Subjects",setSubject)
                .checkResult("Hobbies",setHobbies)
                .checkResult("Picture","img.jpg")
                .checkResult("Address",streetAddress)
                .checkResult("State and City", setState + " " + setCity);
    }

    @Test
    void notFullDataRegistrationTest(){
        registrationPage.openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setPhone(userPhone)
                .submitClick();

        registrationPage.checkResult("Student Name",firstName+' '+lastName)
                .checkResult("Student Email"," ")
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userPhone)
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

