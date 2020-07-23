package helpers;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;

import java.util.stream.Stream;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public final class AllureHelper {
    @Step("Add environment variables to report")
    public static void writeEnvVariables() {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        Stream<String> keys = Stream.of("name", "home", "version");
        builder.putAll(MapHelper.filterByKeys(System.getProperties(), keys));
        builder.putAll(MapHelper.filterByKeys(System.getenv(), keys));
        allureEnvironmentWriter(builder.build(), getAllureResults());
    }

    private static String getAllureResults() {
        return System.getProperty("allure.results.directory") + "/";
    }
}
