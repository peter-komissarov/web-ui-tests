package helpers;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;

import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public final class AllureHelper {

    @Step("Add environment variables to report")
    public final void writeEnvVariables(MapHelper mapHelper) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        Supplier<Stream<String>> keys = () -> Stream.of("name", "home", "version");
        treeMap.putAll(mapHelper.beatifyMap(mapHelper.filterByKeys(System.getProperties(), keys)));
        treeMap.putAll(mapHelper.beatifyMap(mapHelper.filterByKeys(System.getenv(), keys)));
        String allureResultsProperty = System.getProperty("allure.results.directory");
        ImmutableMap<String, String> immutableMap = new ImmutableMap.Builder<String, String>()
                .putAll(treeMap)
                .build();
        if (allureResultsProperty == null) {
            allureEnvironmentWriter(immutableMap);
        } else {
            allureEnvironmentWriter(immutableMap, allureResultsProperty + "/");
        }
    }
}
