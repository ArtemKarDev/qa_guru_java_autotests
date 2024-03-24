package tests;

import pages.TextBoxPage;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

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

    }
}