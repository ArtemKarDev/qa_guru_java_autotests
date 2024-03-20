import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SelenideElement.*;
import static com.codeborne.selenide.DragAndDropOptions.*;

public class HomeWork5 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void HerokuDragAndDropActions(){
        open("/drag_and_drop");
        actions().dragAndDrop($("#column-a"),$("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void HerokuDragAndDropTo(){
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void HerokuDragAndDropOption(){
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("B"));
    }

}