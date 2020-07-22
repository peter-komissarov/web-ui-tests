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
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();

        // get all system properties and env variables
        Map<String, String> variables = new TreeMap<>(System.getenv());
        System.getProperties().stringPropertyNames().forEach(key -> variables.put(key, System.getProperty(key)));

        // filter all by key
        variables.forEach((key, value) -> {
            if (Stream.of("name", "home", "ver").anyMatch(key.toLowerCase()::contains)) {
                builder.put(key, value);
            }
        });

        allureEnvironmentWriter(builder.build(), System.getProperty("allure.results.directory") + "/");
    }
}
