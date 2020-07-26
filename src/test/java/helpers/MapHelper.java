package helpers;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MapHelper {

    public final Map<String, String> filterByKeys(Map<?, ?> map, Supplier<Stream<String>> keys) {
        return map.entrySet()
                .parallelStream()
                .filter(entry -> keys.get().anyMatch(entry.getKey().toString().toLowerCase()::contains))
                .collect(Collectors.toMap(entry -> entry.getKey().toString(),
                        entry -> entry.getValue().toString()));
    }

    public final Map<String, String> beatifyMap(Map<String, String> map) {
        return map.entrySet()
                .parallelStream()
                .collect(Collectors.toMap(entry -> StringUtils.capitalize(entry.getKey().toLowerCase()),
                        entry -> StringUtils.capitalize(entry.getValue().toLowerCase())));
    }
}
