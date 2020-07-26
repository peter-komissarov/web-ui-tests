package helpers;

import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

public final class DriverHelper {

    @Step("Close drivers")
    public final void closeDrivers(ProcessHelper processHelper) {
        this.getDrivers().parallelStream().forEach(processHelper::killByName);
    }

    private List<String> getDrivers() {
        return Arrays.asList(
                "chromedriver",
                "geckodriver",
                "msedgedriver",
                "operadriver",
                "phantomjs",
                "iedriverserver");
    }
}
