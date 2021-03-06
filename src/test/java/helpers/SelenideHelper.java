package helpers;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelectorMode;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;

public final class SelenideHelper {

    @Step("Configure selenide")
    public final void configureSelenide() {
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.browser = "chrome";
        Configuration.clickViaJs = false;
        Configuration.driverManagerEnabled = true;
        Configuration.fastSetValue = true;
        Configuration.headless = true;
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "normal";
        Configuration.pollingInterval = 200;
        Configuration.reopenBrowserOnFail = true;
        Configuration.savePageSource = true;
        Configuration.screenshots = true;
        Configuration.selectorMode = SelectorMode.CSS;
        Configuration.startMaximized = false;
        Configuration.timeout = 4000;
        Configuration.versatileSetValue = true;
    }

    @Step("Add listener for current thread")
    public final void addListener(ThreadHelper threadHelper) {
        SelenideLogger.addListener(threadHelper.getThreadId(), new AllureSelenide());
    }

    @Step("Remove listener for current thread")
    public final void removeListener(ThreadHelper threadHelper) {
        SelenideLogger.removeListener(threadHelper.getThreadId());
    }
}
