package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Сравнение парсированных данных
public class Unterschied {
    public static List<Status> unterschied(
            Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        List<Status> list = new ArrayList<>();
        mapOne.forEach((key, value) -> {
            if (!mapTwo.containsKey(key)) {
                list.add(new Status(Status.DELETED, key, value, "null"));
            } else if (key != null) {
                if (mapTwo.get(key) != null && value != null) {
                    if (Comparing.comparing(value, mapTwo.get(key))) {
                        list.add(new Status(Status.UNCHANGED, key, value));
                        mapTwo.remove(key);
                    } else {
                        list.add(new Status(Status.CHANGED, key, value, mapTwo.get(key)));
                        mapTwo.remove(key);
                    }
                } else if (value != null && mapTwo.get(key) == null) {
                    Object valueTwo = "null";
                    list.add(new Status(Status.CHANGED, key, value, valueTwo));
                    mapTwo.remove(key);
                } else if (value == null && mapTwo.get(key) != null) {
                    Object valueOne = "null";
                    list.add(new Status(Status.CHANGED, key, valueOne, mapTwo.get(key)));
                    mapTwo.remove(key);
                }
            }
        });

        mapTwo.forEach((key, value) -> {
            if (key != null && value != null) {
                list.add((new Status(Status.ADDED, key, value)));
            }
        });
        return list;
    }
}
