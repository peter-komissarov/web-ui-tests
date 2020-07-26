package common;

import helpers.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.codeborne.selenide.Selenide.open;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigHelper.class)
public abstract class BaseScenario {

    @BeforeAll
    protected static void beforeAll(@Autowired DriverHelper driverHelper,
                                    @Autowired ProcessHelper processHelper,
                                    @Autowired SelenideHelper selenideHelper) {
        driverHelper.closeDrivers(processHelper);
        selenideHelper.configureSelenide();
    }

    @AfterAll
    protected static void afterAll(@Autowired AllureHelper allureHelper, @Autowired MapHelper mapHelper) {
        allureHelper.writeEnvVariables(mapHelper);
    }

    @BeforeEach
    protected final void beforeEach(@Autowired SelenideHelper selenideHelper, @Autowired ThreadHelper threadHelper) {
        selenideHelper.addListener(threadHelper);
    }

    @AfterEach
    protected final void afterEach(@Autowired SelenideHelper selenideHelper, @Autowired ThreadHelper threadHelper) {
        selenideHelper.removeListener(threadHelper);
    }

    @Step("Open")
    protected <T> T openUri(String uri, Class<T> outPage) {
        return open(uri, outPage);
    }
}
