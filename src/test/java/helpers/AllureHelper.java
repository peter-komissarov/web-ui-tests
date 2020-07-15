package helpers;

import com.google.common.collect.ImmutableMap;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public final class AllureHelper {
    public static void writeEnvVariables() {
        ImmutableMap.Builder<String, String> map = ImmutableMap.builder();
        System.getProperties().forEach((key, value) -> map.put(key.toString(), value.toString()));
        System.getenv().forEach(map::put);
        allureEnvironmentWriter(map.build(),
                System.getProperty("allure.results.directory") + "/");
    }
}
