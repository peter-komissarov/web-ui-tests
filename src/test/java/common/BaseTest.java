package common;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureHelper;
import helpers.SelenideHelper;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({SoftAssertsExtension.class})
public abstract class BaseTest {
    @BeforeAll
    @Step("Deploy common test infrastructure")
    protected static void setupOnce() {
        SelenideHelper.configureSelenide();
        AllureHelper.writeEnvVariables();
    }

    @AfterAll
    @Step("Clear common test infrastructure")
    protected static void teardown() {
        SelenideLogger.removeAllListeners();
    }

    @BeforeEach
    @Step("Deploy test infrastructure")
    protected final void setup() {
        SelenideLogger.addListener(String.valueOf(Thread.currentThread().getId()), new AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true));
    }

    @AfterEach
    @Step("Clear test infrastructure")
    protected final void afterEach() {
        SelenideLogger.removeListener(String.valueOf(Thread.currentThread().getId()));
    }
}
