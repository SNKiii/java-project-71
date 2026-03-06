package hexlet.code;


import java.util.List;
import java.util.Map;

public class ComparingFiles {

    public static boolean comparing(Object valueOne, Object valueTwo) {
        if (valueOne instanceof List && valueTwo instanceof List) {
            List<?> listOne = (List<?>) valueOne;
            List<?> listTwo = (List<?>) valueTwo;
            return listOne.equals(listTwo);
        } else if (valueOne instanceof Map && valueTwo instanceof Map) {
            Map<String, Object> mapOne = (Map<String, Object>) valueOne;
            Map<String, Object> mapTwo = (Map<String, Object>) valueTwo;
            return mapOne.equals(mapTwo);
        } else {
            return valueOne.equals(valueTwo);
        }
    }
}

