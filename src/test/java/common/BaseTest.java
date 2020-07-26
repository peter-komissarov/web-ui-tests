package common;

import helpers.AllureHelper;
import helpers.ConfigHelper;
import helpers.DriverHelper;
import helpers.SelenideHelper;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.codeborne.selenide.Selenide.open;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigHelper.class)
public abstract class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        DriverHelper.closeDrivers();
        SelenideHelper.configureSelenide();
        AllureHelper.writeEnvVariables();
    }

    @AfterAll
    protected static void afterAll() {
    }

    @BeforeEach
    protected final void beforeEach() {
        SelenideHelper.addListener();
    }

    @AfterEach
    protected final void afterEach() {
        SelenideHelper.removeListener();
    }

    @Step("Open")
    protected <T> T openUri(String uri, Class<T> outPage) {
        return open(uri, outPage);
    }
}
