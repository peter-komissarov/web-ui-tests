package pages.mailbox;

import components.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public final class MainPage extends Header {
    @Step("Open top {numberOfMail} mail")
    public final EmailPage openMail(int numberOfMail) {
        $$(By.className("llc__content")).get(numberOfMail).scrollTo().click();
        return page(EmailPage.class);
    }
}
