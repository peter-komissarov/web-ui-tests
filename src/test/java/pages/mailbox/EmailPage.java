package pages.mailbox;

import components.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public final class EmailPage extends Header {
    @Step("Sender should contain")
    public final EmailPage assertSender(String expectedSender) {
        $(By.className("letter__author")).should(text(expectedSender));
        return this;
    }

    @Step("Subject should contain")
    public final EmailPage assertSubject(String expectedSubject) {
        $(By.className("thread__subject")).should(text(expectedSubject));
        return this;
    }

    @Step("Body should contain")
    public final EmailPage assertBody(String expectedBody) {
        $("div.js-helper:nth-child(1) > div:nth-child(2)").should(text(expectedBody));
        return this;
    }
}
