package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import helpers.Attach;
import io.qameta.allure.internal.shadowed.jackson.databind.cfg.ConfigFeature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUpConfig() {
        Configuration.browserSize = "1920x1080";
        //Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        //пожалуйста, позвольте оставить эту строчку , хоть в каком нибудь виде
        //Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void closeUp() {
        closeWebDriver();
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
    }
}
