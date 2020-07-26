package helpers;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MapHelper {

    public static Map<String, String> filterByKeys(Map<?, ?> map, Supplier<Stream<String>> keys) {
        return map.entrySet()
                .stream()
                .filter(entry -> keys.get().anyMatch(entry.getKey().toString().toLowerCase()::contains))
                .collect(Collectors.toMap(entry -> entry.getKey().toString().toLowerCase(),
                        entry -> entry.getValue().toString().toLowerCase()));
    }
}
