package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    Locale locale = new Locale("en");
    Faker faker = new Faker(locale);
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = randomUtils.getRandomGender();
    String userPhone = randomUtils.getRandomPhone();
    String day = Integer.toString(RandomUtils.getRandomInt(1, 30));
    String month = randomUtils.getRandomMonth();
    String year = Integer.toString(RandomUtils.getRandomInt(2000, 2010));
    String subject = randomUtils.getRandomSubject();
    String hobbies = randomUtils.getRandomHobbies();
    int stateIndex = RandomUtils.getRandomInt(0, randomUtils.states.length);
    String state = randomUtils.states[stateIndex];
    String city = randomUtils.getRandomItem(randomUtils.cities[stateIndex]);


    String streetAddress = faker.address().streetAddress();

    @DisplayName("Заполнение регистрационными данными всех полей")
    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("KarlashovArtem")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("smoke")
    void successfulRegistrationTests() {

        registrationPage.openPracticeFormPage()
                .closeBannersOnPage()
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

        registrationPage.checkResult("Student Name", firstName + ' ' + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhone)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "img.jpg")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);
    }
    @DisplayName("Заполнение регистрационными данными только обязательных полей")
    @Test
    @Tag("demoqa")
    void notFullDataRegistrationTest() {
        registrationPage.openPracticeFormPage()
                .closeBannersOnPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setPhone(userPhone)
                .submitClick();

        registrationPage.checkResult("Student Name", firstName + ' ' + lastName)
                .checkResult("Student Email", " ")
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhone)
                .checkResult("Date of Birth", " ")
                .checkResult("Subjects", " ")
                .checkResult("Address", " ");

    }

    @DisplayName("Не заполнение полей")
    @Test
    void notFillRequiredFieldsTest() {
        registrationPage.openPracticeFormPage()
                .closeBannersOnPage()
                .submitClick()
                .checkModalFormNotDisplayed()
                .checkEmptyFirstNameAfterSubmited();
    }


    //@Disabled("jira-BUG777")
    @ValueSource(strings = {
            "9470945066", "9836547077", "9357483948"
    })
    @DisplayName("Заполнение регистрационными данными только обязательных полей.")
    @ParameterizedTest(name = " Для номера телефона {0} данные формой принимаются")
    @Tag("regress")
    @Tag("demoqa")
    @Tag("smoke")
    void notFullDataRegistrationTestWithValueSource(String userNumber) {
        registrationPage.openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setPhone(userNumber)
                .submitClick();

        registrationPage.checkResult("Student Name", firstName + ' ' + lastName)
                .checkResult("Student Email", " ")
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", " ")
                .checkResult("Subjects", " ")
                .checkResult("Address", " ");

    }


    static Stream<Arguments> headerTextOnPage() {
        return Stream.of(
                Arguments.of(
                        List.of("Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application")
                )
        );
    }
    @DisplayName("Проверка заголовков.")
    @MethodSource
    @ParameterizedTest(name = " На странице должны быть заголовки {0}")
    @Tag("regress")
    @Tag("demoqa")
    void headerTextOnPage(List<String> expectedText) {
        registrationPage.openPracticeFormPage()
                .closeBannersOnPage()
                .checkHeaderText(expectedText);
    }

    @DisplayName("Заполнение регистрационными данными только обязательных полей. Данные из CSV. ")
    @CsvFileSource(resources = "/test_data/notFullDataRegistrationTest3.csv", delimiter = '|')
    @ParameterizedTest(name = "Для номера телефона {0} данные формой принимаются")
        //@Tag("regress")
    @Tag("demoqa")
    void notFullDataRegistrationTestWithCsvFileSource(String firstName, String lastName, String userNumber) {
        registrationPage.openPracticeFormPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setPhone(userNumber)
                .submitClick();

        registrationPage.checkResult("Student Name", firstName + ' ' + lastName)
                .checkResult("Student Email", " ")
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", " ")
                .checkResult("Subjects", " ")
                .checkResult("Address", " ");

    }
}