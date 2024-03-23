package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public static SelenideElement firstNameInput = $("#firstName");
    public static SelenideElement lastNameInput = $("#lastName");

    public void setFirstName(String value) {
        firstNameInput.sendKeys(value);
    }
    public void setLastName(String value) {
        lastNameInput.sendKeys(value);
    }
}
