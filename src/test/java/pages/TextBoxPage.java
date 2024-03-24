package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
                            userEmailInput = $("#userEmail"),
                            currentAddressInput = $("#currentAddress"),
                            permanentAddressInput = $("#permanentAddress"),
                            submitButton = $("#submit"),
                            outputInfo = $("#output");

    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        executeJavaScript("$('#fixban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".body-height").shouldHave(text("Text Box"));

        return this;
    }

    public TextBoxPage setUserName(String value){
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value){
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submitClick(){
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value){
        outputInfo.shouldBe(appear);
        outputInfo.$(key).shouldHave(text(value));
        return this;
    }

}
