package helpers;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class MapHelper {
    public static Map<String, String> filterByKeys(Map<?, ?> map, Supplier<Stream<String>> keys) {
        Map<String, String> mapFiltered = new TreeMap<>();

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            String key = entry.getKey().toString().toLowerCase();

            if (keys.get().anyMatch(key::contains)) {
                String value = entry.getValue().toString().toLowerCase();
                mapFiltered.put(key, value);
            }
        }
        return mapFiltered;
    }
}
