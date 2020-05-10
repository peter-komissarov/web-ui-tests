package pages;

import components.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.mailbox.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public final class LoginPage extends Header {
    @Step("Set login = {login}")
    public final LoginPage setLogin(String login) {
        $(By.id("mailbox:login")).setValue(login);
        return this;
    }

    @Step("Click on \"go to password enter\" button")
    public final LoginPage goToPasswordEnter() {
        $("input.o-control").click();
        return this;
    }

    @Step("Set password = {password}")
    public final LoginPage setPassword(String password) {
        $(By.id("mailbox:password")).setValue(password);
        return this;
    }

    @Step("Click on \"Enter to mailbox\" button")
    public final MainPage enterToMailbox() {
        $("input.o-control").click();
        return page(MainPage.class);
    }
}
