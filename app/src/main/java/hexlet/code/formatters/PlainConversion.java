package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PlainConversion {

    //Преобразователь объекта в строку
    private static String convertString(Object obj) {
        if (obj == null || obj.equals("null")) {
            return "null";
        }

        if (obj instanceof Map || obj instanceof List) {
            return "[complex value]";
        }

        if (obj instanceof String) {
            return "'" + obj.toString() + "'";
        }

        return obj.toString();
    }

    //Плоский формат
    public static String plainFormater(List<Status> list) {
        List<String> plainList = new ArrayList<>();
        for (var obj : list) {
            switch (obj.getStatusName()) {
                case Status.DELETED -> plainList.add("Property '" + obj.getKey() + "' was removed");
                case Status.ADDED -> plainList.add("Property '" + obj.getKey()
                        +
                        "' was added with value: " + convertString(obj.getOldValue()));
                case Status.CHANGED -> plainList.add("Property '" + obj.getKey()
                        +
                        "' was updated. From " + convertString(obj.getOldValue())
                        +
                        " to " + convertString(obj.getNewValue()));
                case Status.UNCHANGED -> {
                    continue;
                }
                default -> throw new RuntimeException("Unknown node type: '" + obj.getStatusName() + "'");
            }
        }
            return String.join("\n", plainList);
        }
    }


