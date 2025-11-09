package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import helpers.Attach;
import io.qameta.allure.internal.shadowed.jackson.databind.cfg.ConfigFeature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUpConfig() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "127.0");
        //String wdHost = System.getProperty("wdHost", "selenoid.autotests.cloud");
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");

        Configuration.holdBrowserOpen = false;
        Configuration.headless = true;
        //Configuration.remote = "https://user1:1234@" + wdHost + "/wd/hub";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        boolean isJenkins = System.getenv("JENKINS_HOME") != null;

        if (isJenkins) {
            String wdHost = System.getProperty("wdHost", "selenoid.autotests.cloud");
//            Configuration.remote = "https://user1:1234@" + wdHost + "/wd/hub";
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            Configuration.headless = true;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;

            System.out.println("=== Running on Jenkins with Selenoid ===");
        } else {
            // 👉 Локальный запуск — без remote, только headless Chrome
            Configuration.headless = true;
            Configuration.remote = null;
            System.out.println("=== Running locally (headless Chrome) ===");
        }




//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void closeUp() {
        closeWebDriver();
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
