package ru.mail.pages.mail;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EmailMainPage {

    public boolean checkContainerWithEmailsIsVisible() {
        $(By.id("b-letters")).should(visible);
        return true;
    }
}
