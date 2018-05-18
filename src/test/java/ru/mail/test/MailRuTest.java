package ru.mail.test;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.mail.pages.MainPage;
import ru.mail.pages.mail.EmailMainPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.mail.pages.MainPage.enterToMainPage;

public class MailRuTest {

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test(enabled = false)
    public void mailRuLoginTest() {
//        Configuration.baseUrl = "https://mail.ru";
        open("https://mail.ru");
        $("#mailbox\\:login").setValue("").pressEnter();

        $("select.o-control").selectOptionContainingText("bk.ru");

        $(By.id("b-letters")).should(visible);

        $$(By.cssSelector("#b-letters .b-datalist__body > div")).shouldHave(size(3));

        $$(By.cssSelector("#b-letters .b-datalist__body > div")).get(0).should(text("15 мая\n" +
                "Mail.Ru – больше, чем почта. Познакомьтесь с проектами Mail.Ru GroupЗдравствуйте, Test! Mail.Ru – ваш проводник в интернет. Узнайте больше о проектах Mail.Ru Group. Под\n" +
                "Команда Почты Mail.Ru"));

    }

    @Test
    public void mailRuPageObjectTest() {
        MainPage mainPage = enterToMainPage();
        mainPage.inputToLogin("selenide@bk.ru");
        mainPage.inputToPassword("123456!qA");
        EmailMainPage emailMainPage = mainPage.clickOnButtonLogin();
        emailMainPage.checkContainerWithEmailsIsVisible();
    }

    @Test
    public void prototype() {
        enterToMainPage()
                .inputToLogin("selenide@bk.ru")
                .inputToPassword("123456!qA")
                .clickOnButtonLogin()
                .checkContainerWithEmailsIsVisible();
//                .deleteFirstEmail()
//                .checkThatFirstEmailWasDeleted()
    }
}
