package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
public class ModalFormComponent {
    public void checkModalForm(String key, String value){

        $(".modal-dialog").shouldBe(appear);

        $(".table-responsive")
                .$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void checkModalFormNotAppear(){
        $(".modal-dialog").shouldNotBe(appear);
    }

}
