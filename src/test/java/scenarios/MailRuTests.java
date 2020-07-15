package scenarios;

import common.BaseTest;
import constants.Input;
import constants.Output;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Mail.ru suite")
public final class MailRuTests extends BaseTest {
    @DisplayName("Passed test")
    @Feature("Mailbox feature")
    @Story("Passed story")
    @Test
    public final void verifyEmailDataPassed() {
        open(Input.BASE_URL, LoginPage.class)
                .setLogin(Input.LOGIN)
                .goToPasswordEnter()
                .setPassword(Input.PASSWORD)
                .enterToMailbox()
                .openEmail(Input.MAIL_NUMBER)
                .assertSender(Output.SENDER)
                .assertSubject(Output.SUBJECT)
                .assertBody(Output.BODY)
                .logout();
    }

    @DisplayName("Failed test")
    @Feature("Mailbox feature")
    @Story("Failed story")
    @Test
    public final void verifyEmailDataFailed() {
        open(Input.BASE_URL, LoginPage.class)
                .setLogin(Input.LOGIN)
                .goToPasswordEnter()
                .setPassword(Input.PASSWORD)
                .enterToMailbox()
                .openEmail(Input.MAIL_NUMBER)
                .assertSender("Invalid expected sender")
                .assertSubject(Output.SUBJECT)
                .assertBody(Output.BODY)
                .logout();
        throw new AssertionError("Failed test example");
    }

    @DisplayName("Broken test")
    @Feature("Mailbox feature")
    @Story("Broken story")
    @Test
    public final void verifyEmailDataBroken() throws Exception {
        open(Input.BASE_URL, LoginPage.class)
                .setLogin(Input.LOGIN)
                .goToPasswordEnter()
                .setPassword(Input.PASSWORD)
                .enterToMailbox()
                .openEmail(Input.MAIL_NUMBER)
                .assertSender(Output.SENDER)
                .assertSubject(Output.SUBJECT)
                .assertBody(Output.BODY)
                .logout();
        throw new Exception("Broken test example exception");
    }

    @DisplayName("Ignored test")
    @Feature("Mailbox feature")
    @Story("Ignored story")
    @Disabled
    @Test
    public final void verifyEmailDataIgnored() {
        open(Input.BASE_URL, LoginPage.class)
                .setLogin(Input.LOGIN)
                .goToPasswordEnter()
                .setPassword(Input.PASSWORD)
                .enterToMailbox()
                .openEmail(Input.MAIL_NUMBER)
                .assertSender(Output.SENDER)
                .assertSubject(Output.SUBJECT)
                .assertBody(Output.BODY)
                .logout();
    }
}
