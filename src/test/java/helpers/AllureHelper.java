package helpers;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public final class AllureHelper {
    @Step("Add environment variables to report")
    public static void writeEnvVariables() {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        builder.putAll(filterMapByKey(System.getProperties()));
        builder.putAll(filterMapByKey(System.getenv()));
        allureEnvironmentWriter(builder.build(), getAllureResults());
    }

    public static Map<String, String> filterMapByKey(Map<?, ?> map) {
        Map<String, String> varsFiltered = new TreeMap<>();

        map.forEach((key, value) -> {
            String keyString = key.toString().toLowerCase();
            String valueString = value.toString().toLowerCase();
            if (Stream.of("name", "home", "version").anyMatch(keyString::contains)) {
                varsFiltered.put(keyString, valueString);
            }
        });
        return varsFiltered;
    }

    private static String getAllureResults() {
        return System.getProperty("allure.results.directory") + "/";
    }
}
