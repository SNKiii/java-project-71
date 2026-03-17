package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PlainConversionFiles {
    public static String plainFormater(Map<String, Object> map) {
        String plainFormat = "";
        List<String> list = new ArrayList<>();
        List<Object> valueOneObject = new ArrayList<>();
        map.forEach((key, value) -> {
            String[] arrKey = key.split(" #RAZDEL# ");
            if (arrKey[0].equals("remote")) {
                list.add("Property '" + arrKey[1] + "' was removed");
            } else if (arrKey[0].equals("add") && arrKey[1] != null && value != null) {
                if (value instanceof List || value instanceof Map) {
                    list.add("Property '" + arrKey[1] + "' was added with value: [complex value]");
                } else {
                    if (value instanceof Integer || value instanceof Boolean) {
                        list.add("Property '" + arrKey[1] + "' was added with value: " + value);
                    } else {
                        list.add("Property '" + arrKey[1] + "' was added with value: '" + value + "'");
                    }
                }
            } else if (arrKey[0].equals("unfaithful one")) {
                valueOneObject.add(value);
            } else if (arrKey[0].equals("unfaithful two")) {
                Object valueTwo = value;
                Object valueOne = valueOneObject.getFirst();
                if (valueOne instanceof Map || valueOne instanceof List) {
                    if (valueTwo instanceof Map || valueTwo instanceof List) {
                        list.add("Property '" + arrKey[1] + "' was updated. From [complex value] to [complex value]");
                        valueOneObject.removeFirst();
                    } else {
                        if (valueTwo instanceof Integer || valueTwo instanceof Boolean || valueTwo.equals("null")) {
                            list.add("Property '" + arrKey[1] + "' was updated. From [complex value] to " + valueTwo);
                            valueOneObject.removeFirst();
                            return;
                        }
                        list.add("Property '" + arrKey[1] + "' was updated. From [complex value] to '" + valueTwo + "'");
                        valueOneObject.removeFirst();
                    }
                } else if (valueTwo instanceof Map || valueTwo instanceof List) {
                    if (valueOne instanceof Integer || valueOne instanceof Boolean || valueOne.equals("null")) {
                        list.add("Property '" + arrKey[1] + "' was updated. From " + valueOne + " to [complex value]");
                        valueOneObject.removeFirst();
                    } else {
                        list.add("Property '" + arrKey[1] + "' was updated. From '" + valueOne + "' to [complex value]");
                        valueOneObject.removeFirst();
                    }
                } else if (valueOne instanceof Boolean || valueOne instanceof Integer || valueOne.equals("null")) {
                    if (valueTwo instanceof Boolean || valueTwo instanceof  Integer || valueTwo.equals("null")) {
                        list.add("Property '" + arrKey[1] + "' was updated. From " + valueOne + " to " + valueTwo);
                        valueOneObject.removeFirst();
                    } else {
                        list.add("Property '" + arrKey[1] + "' was updated. From " + valueOne + " to '" + valueTwo + "'");
                        valueOneObject.removeFirst();
                    }
                } else if (valueTwo instanceof Boolean || valueTwo instanceof  Integer || valueTwo.equals("null")) {
                    list.add("Property '" + arrKey[1] + "' was updated. From '" + valueOne + "' to " + valueTwo);
                    valueOneObject.removeFirst();
                }else {
                    list.add("Property '" + arrKey[1] + "' was updated. From '" + valueOne + "' to '" + valueTwo + "'");
                    valueOneObject.removeFirst();
                }

            }
        });

        for (String text : list) {
            plainFormat += text + "\n";
        }

        return plainFormat;
    }
}

