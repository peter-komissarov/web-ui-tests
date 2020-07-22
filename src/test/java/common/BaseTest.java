package common;

import helpers.AllureHelper;
import helpers.ProcessHelper;
import helpers.SelenideHelper;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;


public abstract class BaseTest {
    @BeforeAll
    protected static void beforeAll() {
        ProcessHelper.killWebDriver();
        SelenideHelper.configureSelenide();
        AllureHelper.writeEnvVariables();
    }

    @AfterAll
    protected static void afterAll() {
    }

    @BeforeEach
    protected final void beforeEach() {
        new SelenideHelper().addListener();
    }

    @AfterEach
    protected final void afterEach() {
        new SelenideHelper().removeListener();
    }

    @Step("Open")
    protected <T> T openUri(String uri, Class<T> outPage) {
        return open(uri, outPage);
    }
}
