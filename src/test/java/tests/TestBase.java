package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.internal.shadowed.jackson.databind.cfg.ConfigFeature;
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
        Configuration.remote = "user1:1234@selenoid.autotests.cloud/wd/hub";
        //пожалуйста, позвольте оставить эту строчку , хоть в каком нибудь виде
        //Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void closeUp() {
        closeWebDriver();
    }
}
