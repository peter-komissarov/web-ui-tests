package scenarios;

import common.BaseScenario;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pages.LoginPage;
import pojo.Input;
import pojo.Output;

@Feature("Mail.ru mailbox")
public final class MailRuScenarios extends BaseScenario {

    @DisplayName("Passed scenario")
    @Story("Passed story")
    @Test
    public final void scenarioVerifyEmailDataPassed(@Autowired Input input, @Autowired Output output) {
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

    @DisplayName("Failed scenario")
    @Story("Failed story")
    @Test
    public final void scenarioVerifyEmailDataFailed(@Autowired Input input, @Autowired Output output) {
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

    @DisplayName("Broken scenario")
    @Story("Broken story")
    @Test
    public final void scenarioVerifyEmailDataBroken(@Autowired Input input, @Autowired Output output) throws Exception {
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

    @DisplayName("Ignored scenario")
    @Story("Ignored story")
    @Disabled
    @Test
    public final void scenarioVerifyEmailDataIgnored(@Autowired Input input, @Autowired Output output) {
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
