package hexlet.code;


import java.util.HashMap;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
            String contentOne = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath1));
            String formatOne;
            String formatTwo;
            if (filePath1.endsWith(".json")) {
                formatOne = "json";
            } else if (filePath1.endsWith(".yaml") || filePath1.endsWith(".yml")) {
                formatOne = "yaml";
            } else {
                System.err.println("Поддерживается только JSON или YAML");
                return null;
            }
            String contentTwo = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath2));
            if (filePath2.endsWith(".json")) {
            formatTwo = "json";
            } else if (filePath2.endsWith(".yaml") || filePath2.endsWith(".yml")) {
            formatTwo = "yaml";
            } else {
            System.err.println("Поддерживается только JSON или YAML");
            return null;
            }
        Map<String, ?> mapJsonOne =  Parser.parseContent(contentOne, formatOne);
        Map<String, ?> mapJsonTwo =  Parser.parseContent(contentTwo, formatTwo);
        mapJsonOne.forEach((key, value) -> {
            if (!mapJsonTwo.containsKey(key)) {
                resultMap.put("remote #RAZDEL# " + key, value);
            } else if (key != null) {
                if (mapJsonTwo.get(key) != null && value != null) {
                    if (Comparing.comparing(value, mapJsonTwo.get(key))) {
                        resultMap.put("inchanges #RAZDEL# " + key, value);
                        mapJsonTwo.remove(key);
                    } else {
                        resultMap.put("unfaithful one #RAZDEL# " + key + "abc1", value);
                        resultMap.put("unfaithful two #RAZDEL# " + key, mapJsonTwo.get(key));
                        mapJsonTwo.remove(key);
                    }
                } else if (value != null && mapJsonTwo.get(key) == null) {
                    Object valueTwo = "null";
                    if (Comparing.comparing(value, valueTwo)) {
                        resultMap.put("inchanges #RAZDEL# " + key, value);
                        mapJsonTwo.remove(key);
                    } else {
                        resultMap.put("unfaithful one #RAZDEL# " + key + "abc1", value);
                        resultMap.put("unfaithful two #RAZDEL# " + key, valueTwo);
                        mapJsonTwo.remove(key);
                    }
                } else if (value == null && mapJsonTwo.get(key) != null) {
                    Object valueOne = "null";
                    if (Comparing.comparing(valueOne, mapJsonTwo.get(key))) {
                        resultMap.put("inchanges #RAZDEL# " + key, valueOne);
                        mapJsonTwo.remove(key);
                    } else {
                        resultMap.put("unfaithful one #RAZDEL# " + key + "abc1", valueOne);
                        resultMap.put("unfaithful two #RAZDEL# " + key, mapJsonTwo.get(key));
                        mapJsonTwo.remove(key);
                    }
                }
                }
            });

        mapJsonTwo.forEach((key, value) -> {
            if (key != null && value != null) {
                resultMap.put("add #RAZDEL# " + key, value);
            }
        });

        if (resultMap.isEmpty()) {
            return "";
        }

        Map<String, Object> filterMap = Filter.filter(resultMap);
        filterMap.put("style", formatName);
        return Formatter.selectFormat(filterMap);


    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "standart");
    }
}
