package helpers;

import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

public final class DriverHelper {
    @Step("Close drivers")
    public static void closeDrivers() {
        getDrivers().forEach(ProcessHelper::killByName);
    }

    private static List<String> getDrivers() {
        return Arrays.asList(
                "chromedriver",
                "geckodriver",
                "msedgedriver",
                "operadriver",
                "phantomjs",
                "iedriverserver");
    }
}
