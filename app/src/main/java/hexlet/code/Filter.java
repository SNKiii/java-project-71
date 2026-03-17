package hexlet.code;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;




public class Filter {
    public static Map<String, Object> filter(Map<String, Object> map) {
        Map<String, Object> filterMap = map.entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    String key1 = s1.getKey()
                            .replaceAll("^[^a-zA-Z]+", "")
                            .replaceAll("remote #RAZDEL#", "")
                            .replaceAll("inchanges #RAZDEL# ", "")
                            .replaceAll("unfaithful one #RAZDEL# ", "")
                            .replaceAll("unfaithful two #RAZDEL# ", "")
                            .replaceAll("add #RAZDEL# ", "")
                            .trim();

                    String key2 = s2.getKey()
                            .replaceAll("^[^a-zA-Z]+", "")
                            .replaceAll("remote #RAZDEL# ", "")
                            .replaceAll("inchanges #RAZDEL# ", "")
                            .replaceAll("unfaithful one #RAZDEL# ", "")
                            .replaceAll("unfaithful two #RAZDEL# ", "")
                            .replaceAll("add #RAZDEL# ", "")
                            .trim();

                    boolean key1HasAbc1 = key1.contains("abc1");
                    boolean key2HasAbc1 = key2.contains("abc1");

                    String baseName1 = key1.replace("abc1", "").trim();
                    String baseName2 = key2.replace("abc1", "").trim();

                    if (baseName1.equalsIgnoreCase(baseName2)) {
                        if (key1HasAbc1 && !key2HasAbc1) {
                            return -1;
                        } else if (!key1HasAbc1 && key2HasAbc1) {
                            return 1;
                        }
                        return key1.compareToIgnoreCase(key2);
                    }

                    return key1.compareToIgnoreCase(key2);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        Map<String, Object> updatedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : filterMap.entrySet()) {
            String newKey = entry.getKey().replace("abc1", "");
            updatedMap.put(newKey, entry.getValue());
        }

        return updatedMap;
    }
}
