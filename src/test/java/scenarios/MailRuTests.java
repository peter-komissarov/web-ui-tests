package scenarios;

import common.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pojo.Input;
import pojo.Output;

@DisplayName("Mail.ru suite")
public final class MailRuTests extends BaseTest {

    private static final Input input;
    private static final Output output;

    static {
        input = Input.builder().build();
        output = Output.builder().build();
    }

    @DisplayName("Passed test")
    @Feature("Mailbox feature")
    @Story("Passed story")
    @Test
    public final void verifyEmailDataPassed() {
        super
                .openUri(input.getBaseUrl(), LoginPage.class)
                .setLogin(input.getLogin())
                .goToPassword()
                .setPassword(input.getPassword())
                .goIntoMailbox()
                .openMail(input.getMailNumber())
                .assertSender(output.getSender())
                .assertSubject(output.getSubject())
                .assertBody(output.getBody())
                .logout();
    }

    @DisplayName("Failed test")
    @Feature("Mailbox feature")
    @Story("Failed story")
    @Test
    public final void verifyEmailDataFailed() {
        Output invalidOutput = output
                .toBuilder()
                .sender("Invalid expected sender")
                .build();
        super
                .openUri(input.getBaseUrl(), LoginPage.class)
                .setLogin(input.getLogin())
                .goToPassword()
                .setPassword(input.getPassword())
                .goIntoMailbox()
                .openMail(input.getMailNumber())
                .assertSender(invalidOutput.getSender())
                .assertSubject(invalidOutput.getSubject())
                .assertBody(invalidOutput.getBody())
                .logout();
        throw new AssertionError("Failed test example");
    }

    @DisplayName("Broken test")
    @Feature("Mailbox feature")
    @Story("Broken story")
    @Test
    public final void verifyEmailDataBroken() throws Exception {
        super
                .openUri(input.getBaseUrl(), LoginPage.class)
                .setLogin(input.getLogin())
                .goToPassword()
                .setPassword(input.getPassword())
                .goIntoMailbox()
                .openMail(input.getMailNumber())
                .assertSender(output.getSender())
                .assertSubject(output.getSubject())
                .assertBody(output.getBody())
                .logout();
        throw new Exception("Broken test example exception");
    }

    @DisplayName("Ignored test")
    @Feature("Mailbox feature")
    @Story("Ignored story")
    @Disabled
    @Test
    public final void verifyEmailDataIgnored() {
        super
                .openUri(input.getBaseUrl(), LoginPage.class)
                .setLogin(input.getLogin())
                .goToPassword()
                .setPassword(input.getPassword())
                .goIntoMailbox()
                .openMail(input.getMailNumber())
                .assertSender(output.getSender())
                .assertSubject(output.getSubject())
                .assertBody(output.getBody())
                .logout();
    }
}
