package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTests() {

        registrationPage.openPage()
                .setFirstName("Jimmy")
                .setLastName("Recard")
                .setEmail("JimmyRecard@good.boy")
                .setGender("Male")
                .setPhone("9997775533")
                .setDateOfBirth("30","Juli","2000");



        // Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value='2010']").click();
        // это для того что бы в списке появилась "2000" при следующем клике
        $(".react-datepicker__year-select").click();
        $("[value='2000']").click();
        $(".react-datepicker__month-select").click();
        $("[value='5']").click();
        $("[aria-label='Choose Monday, June 12th, 2000']").click();

        // Subject
        $("input#subjectsInput").setValue("co");
        $(byText("Computer Science")).click();

        // Hobbies
        $("[for=hobbies-checkbox-3]").click();

        //loading pict

        $("#uploadPicture").uploadFromClasspath("pict.jpg");

        //Address
        $("#currentAddress").setValue("Some street 1");

        //State
        $("#state").scrollTo();
        $("#state").click();
        $(byText("NCR")).click();

        //City
        $("#city").click();
        $(byText("Noida")).click();

        $("#submit").click();

        $$("tr").get(1).shouldHave(text("Jimmy Recard"));
        $$("tr").get(2).shouldHave(text("JimmyRecard@good.boy"));
        $$("tr").get(3).shouldHave(text("Male"));
        $$("tr").get(4).shouldHave(text("9997775533"));
        $$("tr").get(5).shouldHave(text("12 June,2000"));
        $$("tr").get(6).shouldHave(text("Computer Science"));
        $$("tr").get(7).shouldHave(text("Music"));
        $$("tr").get(8).shouldHave(text("pict.jpg"));
        $$("tr").get(9).shouldHave(text("Some street 1"));
        $$("tr").get(10).shouldHave(text("NCR Noida"));

    }
}