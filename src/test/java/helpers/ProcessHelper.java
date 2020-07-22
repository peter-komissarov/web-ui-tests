package helpers;

import io.qameta.allure.Step;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Arrays;

@Log
public final class ProcessHelper {
    @Step("Close drivers")
    public static void closeDrivers() {
        for (String driver : Arrays.asList(
                "chromedriver",
                "geckodriver",
                "msedgedriver",
                "operadriver",
                "phantomjs",
                "iedriverserver")) {
            killByName(driver);
        }
    }

    public static void killByName(String procName) {
        String os = System.getProperty("os.name").toLowerCase();
        String script = os.contains("win") ? ("taskkill /t /f /im " + procName + "*") : ("pkill -9 -x " + procName);

        try {
            Runtime.getRuntime().exec(script).waitFor();
        } catch (IOException | InterruptedException e) {
            log.warning(e.getMessage());
        }
    }
}
