package common;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureHelper;
import helpers.SelenideHelper;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    @BeforeAll
    @Step("Setup test infrastructure once")
    protected static void beforeAll() {
        SelenideHelper.configureSelenide();
        AllureHelper.writeEnvVariables();
    }

    @AfterAll
    @Step("Teardown test infrastructure once")
    protected static void afterAll() {
    }

    @BeforeEach
    @Step("Setup test infrastructure")
    protected final void beforeEach() {
        SelenideLogger.addListener(String.valueOf(Thread.currentThread().getId()), new AllureSelenide());
    }

    @AfterEach
    @Step("Teardown test infrastructure")
    protected final void afterEach() {
        SelenideLogger.removeListener(String.valueOf(Thread.currentThread().getId()));
    }
}
