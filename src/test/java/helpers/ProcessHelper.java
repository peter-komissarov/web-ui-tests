package helpers;

import io.qameta.allure.Step;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Log
public final class ProcessHelper {
    @Step("Close driver")
    public static void closeDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        List<String> drivers = Arrays.asList(
                "chromedriver",
                "geckodriver",
                "msedgedriver",
                "operadriver",
                "phantomjs",
                "iedriverserver");

        for (String driver : drivers) {
            try {
                if (osName.contains("win")) {
                    Runtime.getRuntime().exec("taskkill /t /f /im " + driver + "*").waitFor();
                } else {
                    Runtime.getRuntime().exec("pkill -f " + driver).waitFor();
                }
            } catch (IOException | InterruptedException e) {
                log.warning(e.getMessage());
            }
        }
    }
}
