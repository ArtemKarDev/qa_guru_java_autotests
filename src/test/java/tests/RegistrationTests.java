package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

public class RegistrationTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    Locale locale = new Locale("en");
    Faker faker = new Faker(locale);
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = randomUtils.getRandomGender();
    String userPhone = randomUtils.getRandomPhone();
    String day = Integer.toString(RandomUtils.getRandomInt(1,30));
    String month = randomUtils.getRandomMonth();
    String year = Integer.toString(RandomUtils.getRandomInt(2000,2010));
    String subject = randomUtils.getRandomSubject();
    String hobbies = randomUtils.getRandomHobbies();
    int stateIndex = RandomUtils.getRandomInt(0,randomUtils.states.length);
    String state = randomUtils.states[stateIndex];
    String city = randomUtils.getRandomItem(randomUtils.cities[stateIndex]);



    String streetAddress = faker.address().streetAddress();


    @Test
    void successfulRegistrationTests() {

        registrationPage.openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture("images/img.jpg")
                .setAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .submitClick();

        registrationPage.checkResult("Student Name",firstName+' '+lastName)
                .checkResult("Student Email",userEmail)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userPhone)
                .checkResult("Date of Birth", day +" "+ month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture","img.jpg")
                .checkResult("Address",streetAddress)
                .checkResult("State and City", state + " " + city);
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

