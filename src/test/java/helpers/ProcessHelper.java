package helpers;

import io.qameta.allure.Step;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Arrays;

@Log
public final class ProcessHelper {
    @Step("Close drivers")
    public static void closeDrivers() {
        Arrays.asList(
                "chromedriver",
                "geckodriver",
                "msedgedriver",
                "operadriver",
                "phantomjs",
                "iedriverserver")
                .forEach(ProcessHelper::killByName);
    }

    private static void killByName(String procName) {
        String osName = System.getProperty("os.name").toLowerCase();
        String command;

        if (osName.contains("win")) {
            command = "taskkill /t /f /im " + procName + "*";
        } else {
            command = "pkill -f " + procName;
        }

        try {
            Runtime.getRuntime().exec(command).waitFor();
        } catch (IOException | InterruptedException e) {
            log.warning(e.getMessage());
        }
    }
}
