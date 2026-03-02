package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringConversionFiles {
    public static List<String> comparing(String fileOne, String fikeTwo) throws IOException {
        List<String> comparList = new ArrayList<>();
        Map<String, ?> mapJsonOne = (Map<String, ?>) Parser.checkFormatFile(fileOne);
        Map<String, ?> mapJsonTwo = (Map<String, ?>) Parser.checkFormatFile(fikeTwo);

        mapJsonOne.forEach((key, value) -> {
            boolean checkTrue = false;
            if (value != null && mapJsonTwo.get(key) != null) {
                if (mapJsonOne.get(key).equals(mapJsonTwo.get(key))) {
                    if (value instanceof List && mapJsonTwo.get(key) instanceof List && mapJsonTwo.get(key) != null) {
                        List<?> listOne = (List<?>) value;
                        List<?> listTwo = (List<?>) mapJsonTwo.get(key);
                        checkTrue = ComparingFiles.comparing(listOne, listTwo);
                    } else if (value instanceof Map && mapJsonTwo.get(key) instanceof Map) {
                        Map<String, Object> mapOne = (Map<String, Object>) value;
                        Map<String, Object> mapTwo = (Map<String, Object>) mapJsonTwo.get(key);
                        checkTrue = ComparingFiles.comparing(mapOne, mapTwo);
                    } else {
                        Object objOne = (Object) value;
                        Object objTwo = (Object) value;
                        checkTrue = ComparingFiles.comparing(objOne, objTwo);
                    }
                }
                if (checkTrue) {
                    comparList.add("  " + key + ": " + value);
                    mapJsonTwo.remove(key);
                } else {
                    //abc1 - an abbreviation that indicates that the string refers to the first json file.
                    comparList.add("- " + key + "/abc1: " + value);
                    comparList.add("+ " + key + ": " + mapJsonTwo.get(key));
                    mapJsonTwo.remove(key);
                }
            }
        });
        if (mapJsonTwo != null) {
            mapJsonTwo.forEach((key, value) -> {
                comparList.add("+ " + key + ": " + value);
            });
        }
        return comparList;
    }
    }
