package ru.mail.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.mail.pages.components.LoginBlock;
import ru.mail.pages.mail.EmailMainPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage extends BasePage<MainPage> {

    private LoginBlock loginBlock;

    private static final By MAILBOX_LOGIN = By.cssSelector("#mailbox\\:login");

    public static MainPage enterToMainPage() {
        open("https://mail.ru");
        return page(MainPage.class);
    }

    public MainPage inputToLogin(String login) {
        loginBlock.inputToLogin(login);
        return this;
    }

    public void focusOnInboxLogin() {
        $(MAILBOX_LOGIN).click();
    }

    public MainPage inputToPassword(String password) {
        $x("//*[@id='mailbox:password']").setValue(password);
        return this;
    }

    public EmailMainPage clickOnButtonLogin() {
        $(By.cssSelector("#mailbox\\:submit")).click();
        return page(EmailMainPage.class);
    }

    public MainPage clickOnButtonLoginWithErrors() {
        $(By.cssSelector("#mailbox\\:submit")).click();
        return this;
    }

    public MainPage checkLoginError() {
        //TODO
        return null;
    }
}
