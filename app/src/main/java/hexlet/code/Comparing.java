package hexlet.code;


import java.util.List;
import java.util.Map;

//Сравнение значений, исходя из их типа
public class Comparing {

    public static boolean comparing(Object valueOne, Object valueTwo) {
        if (valueOne == null && valueTwo == null) {
            return true;
        }
        if (valueOne == null || valueTwo == null) {
            return false;
        }

        if (valueOne instanceof List<?> listOne && valueTwo instanceof List<?> listTwo) {
            return listOne.equals(listTwo);
        }

        if (valueOne instanceof Map<?, ?> mapOne && valueTwo instanceof Map<?, ?> mapTwo) {
            return mapOne.equals(mapTwo);
        }

        if (valueOne instanceof List<?> || valueOne instanceof Map<?, ?>
                || valueTwo instanceof List<?> || valueTwo instanceof Map<?, ?>) {
            return false;
        }
        return valueOne.equals(valueTwo);
    }
}

