package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalFormComponent {
    public void checkModalForm(String key, String value) {

        $(".modal-dialog").shouldBe(appear);

        $(".table-responsive")
                .$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void checkModalFormNotAppear() {
        $(".modal-dialog").shouldNotBe(appear);
    }

}
