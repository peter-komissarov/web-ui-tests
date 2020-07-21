package helpers;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public final class AllureHelper {
    public static void writeEnvVariables() {
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
        System.getProperties().entrySet().forEach(systemProperty -> filterMapByKey(systemProperty, builder));
        System.getenv().entrySet().forEach(envVariable -> filterMapByKey(envVariable, builder));
        allureEnvironmentWriter(builder.build(), System.getProperty("allure.results.directory") + "/");
    }

    private static void filterMapByKey(Map.Entry<?, ?> entry, ImmutableMap.Builder<String, String> map) {
        String key = entry.getKey().toString().toLowerCase();
        if (Arrays.stream(new String[]{"name", "home", "ver"}).parallel().anyMatch(key::contains)) {
            map.put(key, entry.getValue().toString().toLowerCase());
        }
    }
}
