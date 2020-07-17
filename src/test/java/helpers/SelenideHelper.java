package helpers;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelectorMode;

public final class SelenideHelper {
    public static void configureSelenide() {
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.browser = "firefox";
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
}
