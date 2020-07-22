package helpers;

import io.qameta.allure.Step;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

@Log
public final class ProcessHelper {
    @Step("Kill web driver")
    public static void killWebDriver() {
        for (String driver : Arrays.asList("chromedriver", "geckodriver", "msedgedriver", "operadriver", "phantomjs", "iedriverserver")) {
            try {
                String osName = System.getProperty("os.name").toLowerCase();
                if (osName.contains("win")) {
                    Runtime.getRuntime().exec("taskkill /t /f /im " + driver + "*").waitFor();
                } else if (Stream.of("mac", "nix", "sunos").anyMatch(osName::contains)) {
                    Runtime.getRuntime().exec("pkill -f " + driver).waitFor();
                }
            } catch (IOException | InterruptedException e) {
                log.warning(e.getMessage());
            }
        }
    }
}

