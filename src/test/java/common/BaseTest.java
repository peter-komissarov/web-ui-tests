package common;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.collect.ImmutableMap;
import constants.Input;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


public abstract class BaseTest {
    @BeforeAll
    @Step("Deploy common test infrastructure")
    protected static void beforeAll() {
        Properties properties = new Properties();
        ClassLoader classLoader = BaseTest.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("selenide.properties")).getFile());
        try {
            properties.load(new FileInputStream(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperties(properties);
    }

    @AfterAll
    @Step("Clear common test infrastructure")
    protected static void afterAll() {
        if (WebDriverRunner.hasWebDriverStarted()) WebDriverRunner.closeWebDriver();
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "chrome")
                        .put("Browser.version", " 81.0.4044.138")
                        .put("Url", Input.BASE_URL)
                        .build(),
                System.getProperty("allure.results.directory") + "/");
    }

    @BeforeEach
    @Step("Deploy test infrastructure")
    protected final void beforeEach() {
        SelenideLogger.addListener(String.valueOf(Thread.currentThread().getId()), new AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterEach
    @Step("Clear test infrastructure")
    protected final void afterEach() {
        WebDriverRunner.closeWindow();
        SelenideLogger.removeListener(String.valueOf(Thread.currentThread().getId()));
    }
}
