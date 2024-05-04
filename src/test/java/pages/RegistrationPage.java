package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import pages.components.CalendarComponent;
import pages.components.ModalFormComponent;

import io.qameta.allure.Step;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    private final ElementsCollection
            headerText = $$(".header-text");

    CalendarComponent calendarComponent = new CalendarComponent();
    ModalFormComponent modalFormComponent = new ModalFormComponent();

    @Step("Открыть страницу регистрационной формы")
    public RegistrationPage openPracticeFormPage() {
        open("/automation-practice-form");
        //executeJavaScript("$('#fixban').remove()");
        //executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage closeBannersOnPage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Вввести имя пользователя {value}.")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.sendKeys(value);
        return this;
    }

    @Step("Вввести фамилию пользователя {value}.")
    public RegistrationPage setLastName(String value) {
        lastNameInput.sendKeys(value);
        return this;
    }

    @Step("Вввести email {value}.")
    public RegistrationPage setEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }

    @Step("Выбрать пол {value}.")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Ввести номер телефона {value}.")
    public RegistrationPage setPhone(String value) {
        phoneInput.sendKeys(value);
        return this;
    }

    @Step("Установить дату рождения {day}.{month}.{year}.")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбрать предмет {value}.")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбрать хобби {value}.")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Загрузить изображение {value}.")
    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    @Step("Ввести адрес {value}.")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    @Step("Выбрать штат {value}.")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Выбрать город {value}.")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Нажать на кнопку Submit.")
    public RegistrationPage submitClick() {
        submitButton.click();
        return this;
    }

    @Step("Проверить, что введенные данные {value} отображаются в графе {key}.")
    public RegistrationPage checkResult(String key, String value) {
        modalFormComponent.checkModalForm(key, value);

        return this;
    }

    @Step("Проверить, что форма не появляется.")
    public RegistrationPage checkModalFormNotDisplayed() {
        modalFormComponent.checkModalFormNotAppear();

        return this;
    }

    @Step("Проверить, что поле имени пустое и подсвечено красным.")
    public RegistrationPage checkEmptyFirstNameAfterSubmited() {
        firstNameInput.shouldBe(empty);
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
    @Step("Проверить заголовок страницы.")
    public RegistrationPage checkHeaderText(List<String> listStrings) {
        headerText.shouldHave(CollectionCondition.texts(listStrings));
        System.out.println(headerText.toString());
        System.out.println(listStrings + " !");
        return this;
    }
}
