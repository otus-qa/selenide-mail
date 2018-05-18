package ru.mail.pages.components;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.mail.pages.mail.EmailMainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginBlock extends ElementsContainer {

    private static final By MAILBOX_LOGIN = By.cssSelector("#mailbox\\:login");

    //TODO Check the problem with @FindBy and Selenide: NullPointerException
    @FindBy(how = How.ID, using = "mailbox:login")
    private SelenideElement loginInput;

    public void inputToLogin(String login) {
        loginInput.setValue(login);
    }

    public void focusOnInboxLogin() {
        $(MAILBOX_LOGIN).click();
    }

    public void inputToPassword(String password) {
        $x("//*[@id='mailbox:password']").setValue(password);
    }

    public EmailMainPage clickOnButtonLogin() {
        $(By.cssSelector("#mailbox\\:submit")).click();
        return page(EmailMainPage.class);
    }
}
