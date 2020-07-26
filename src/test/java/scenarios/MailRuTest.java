package scenarios;

import common.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pages.LoginPage;
import pojo.Input;
import pojo.Output;

@DisplayName("Mail.ru suite")
public class MailRuTest extends BaseTest {

    @Autowired
    private Input input;
    @Autowired
    private Output output;

    @DisplayName("Passed test")
    @Feature("Mailbox feature")
    @Story("Passed story")
    @Test
    public void testVerifyEmailDataPassed() {
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
    public void testVerifyEmailDataFailed() {
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
    public void testVerifyEmailDataBroken() throws Exception {
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
    public void testVerifyEmailDataIgnored() {
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
