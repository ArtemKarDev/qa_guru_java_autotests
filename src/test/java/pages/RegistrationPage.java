package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
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

    CalendarComponent calendarComponent = new CalendarComponent();
    ModalFormComponent modalFormComponent = new ModalFormComponent();


    public RegistrationPage openPracticeFormPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }



    public RegistrationPage setFirstName(String value) {
        firstNameInput.sendKeys(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.sendKeys(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPhone(String value) {
        phoneInput.sendKeys(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day,String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day,month,year);

        return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value){
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value){
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value){
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submitClick(){
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value){
        modalFormComponent.checkModalForm(key, value);

        return this;
    }
    public RegistrationPage checkModalFormNotDisplayed(){
        modalFormComponent.checkModalFormNotAppear();

        return this;
    }

    public RegistrationPage checkEmptyFirstNameAfterSubmited(){
        firstNameInput.shouldBe(empty);
        firstNameInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));

        return  this;
    }

}
