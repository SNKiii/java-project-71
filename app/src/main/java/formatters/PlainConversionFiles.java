package formatters;

import java.util.List;
import java.util.Map;

public class PlainConversionFiles {
        public static  String plainFormater(boolean check, String key, Object valueOne, Object valueTwo) {
            if (!check) {
                if (valueOne instanceof Map || valueOne instanceof List) {
                    if (valueTwo instanceof Map || valueTwo instanceof List) {
                        return "Property '" + key + "' was updated. From [complex value] to [complex value]";
                    } else {
                        if (valueTwo instanceof Integer || valueTwo instanceof Boolean) {
                            return "Property '" + key + "' was updated. From [complex value] to " + valueTwo;
                        }
                        return "Property '" + key + "' was updated. From [complex value] to '" + valueTwo + "'";
                    }
                } else if (valueTwo instanceof Map || valueTwo instanceof List) {
                    if (valueOne instanceof Integer || valueOne instanceof Boolean) {
                        return "Property '" + key + "' was updated. From " + valueOne + " to [complex value]";
                    }
                    return "Property '" + key + "' was updated. From '" + valueOne + "' to [complex value]";
                }
                if (valueOne instanceof Integer || valueOne instanceof Boolean
                        &&
                        valueTwo instanceof Integer || valueTwo instanceof Boolean) {
                    return  "Property '" + key + "' was updated. From " + valueOne + " to " + valueTwo;
                } else {
                    if (valueOne == null && valueTwo == null) {
                        return "";
                    } else {
                        return "Property '" + key + "' was updated. From '" + valueOne + "' to '" + valueTwo + "'";
                    }
                }
        }
        return "";
    }


    public static  String plainFormater(String key) {
            return "Property '" + key + "' was removed";
    }

    public static <T> String plainFormater(String key, T value) {
        if (value != null && key != null) {
            if (value instanceof List || value instanceof  Map) {
                return "Property '" + key + "' was added with value: [complex value]";
            } else {
                if (value instanceof Integer || value instanceof Boolean) {
                    return "Property '" + key + "' was added with value: " + value;
            } else {
                    return "Property '" + key + "' was added with value: '" + value + "'";
                }
            }
        } else {
            return "";
        }
    }
    }
