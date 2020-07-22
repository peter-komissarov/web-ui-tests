package helpers;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;

import java.util.stream.Stream;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public final class AllureHelper {
    @Step("Add environment variables to report")
    public static void writeEnvVariables() {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();

        System.getProperties().forEach((Object key, Object value) -> {
            if (Stream.of("name", "home", "ver").anyMatch(key.toString().toLowerCase()::contains)) {
                builder.put(key.toString(), value.toString());
            }
        });

        System.getenv().forEach((String key, String value) -> {
            if (Stream.of("name", "home", "version").anyMatch(key.toLowerCase()::contains)) {
                builder.put(key, value);
            }
        });

        allureEnvironmentWriter(builder.build(), System.getProperty("allure.results.directory") + "/");
    }
}
