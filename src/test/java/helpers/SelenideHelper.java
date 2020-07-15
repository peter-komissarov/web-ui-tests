package helpers;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelectorMode;
import constants.Input;

public final class SelenideHelper {
    public static void configureSelenide() {
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.baseUrl = Input.BASE_URL;
        Configuration.browser = "firefox";
        Configuration.clickViaJs = false;
        Configuration.driverManagerEnabled = true;
        Configuration.fastSetValue = true;
        Configuration.headless = true;
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.pollingInterval = 50;
        Configuration.reopenBrowserOnFail = true;
        Configuration.savePageSource = true;
        Configuration.screenshots = true;
        Configuration.selectorMode = SelectorMode.CSS;
        Configuration.startMaximized = false;
        Configuration.timeout = 10000;
        Configuration.versatileSetValue = false;
    }
}
