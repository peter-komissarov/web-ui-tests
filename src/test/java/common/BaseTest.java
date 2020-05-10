package common;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelectorMode;
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

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


public abstract class BaseTest {
    @BeforeAll
    @Step("Deploy common test infrastructure")
    protected static void beforeAll() {
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.browser = "chrome";
        Configuration.clickViaJs = false;
        Configuration.driverManagerEnabled = true;
        Configuration.fastSetValue = true;
        Configuration.headless = true;
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.pollingInterval = 50;
        Configuration.reopenBrowserOnFail = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.selectorMode = SelectorMode.CSS;
        Configuration.startMaximized = false;
        Configuration.timeout = 4000;
        Configuration.versatileSetValue = true;
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
