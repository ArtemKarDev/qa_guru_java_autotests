package tests;

import pages.TextBoxPage;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openTextBoxPage()
                .setUserName("Jimmy Recard")
                .setUserEmail("JimmyRecard@good.boy")
                .setCurrentAddress("Some Current Address")
                .setPermanentAddress("Some Permanent Address")
                .submitClick();

        textBoxPage.checkResult("#name","Jimmy Recard")
                .checkResult("#email","immyRecard@good.boy")
                .checkResult("#currentAddress","Some Current Address")
                .checkResult("#permanentAddress","Some Permanent Address");

//        open("/text-box");
//        $("#userName").setValue("Alex");
//        $("#userEmail").setValue("alex@egorov.com");
//        $("#currentAddress").setValue("Some street 1");
//        $("#permanentAddress").setValue("Another street 1");
//        $("#submit").click();
//
//        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@egorov.com"));
//        $("#output #currentAddress").shouldHave(text("Some street 1"));
//        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}