package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

//Плоский формат
public class PlainConversion {
    public static String plainFormater(List<Status> list) {
        String plainFormat = "";

        for (var obj : list) {
            if (obj.getStatusName().equals(Status.DELETED)) {
                plainFormat = plainFormat + "Property '" + obj.getKey() + "' was removed\n";
            } else if (obj.getStatusName().equals(Status.ADDED)) {
                if (obj.getOldValue() instanceof List
                        ||
                        obj.getOldValue() instanceof Map) {
                    plainFormat = plainFormat + "Property '" + obj.getKey()
                            +
                            "' was added with value: [complex value]\n";
                } else {
                    if (obj.getOldValue() instanceof Integer
                            ||
                            obj.getOldValue() instanceof Boolean) {
                        plainFormat = plainFormat + "Property '" + obj.getKey() + "' was added with value: "
                                +
                                obj.getOldValue() + "\n";
                    } else {
                        plainFormat = plainFormat + "Property '" + obj.getKey() + "' was added with value: '"
                                +
                                obj.getOldValue() + "'\n";
                    }
                }
            } else if (obj.getStatusName().equals(Status.CHANGED)) {
                if (obj.getNewValue() instanceof List
                        ||
                        obj.getNewValue() instanceof Map) {
                    if (obj.getOldValue() instanceof List
                            ||
                            obj.getOldValue() instanceof Map) {
                        plainFormat = plainFormat + "Property '" + obj.getKey()
                                +
                                "' was updated. From [complex value] to [complex value]\n";
                    } else if (obj.getOldValue() instanceof Boolean
                            ||
                            obj.getOldValue() instanceof Integer
                            ||
                            obj.getOldValue().equals("null")) {
                        plainFormat = plainFormat + "Property '" + obj.getKey()
                                +
                                "' was updated. From " + obj.getOldValue() + " to [complex value]\n";
                    } else {
                        plainFormat = plainFormat + "Property '"
                                +
                                obj.getKey() + "' was updated. From '" + obj.getOldValue() + "' to [complex value]\n";
                    }
                } else if (obj.getOldValue() instanceof List
                        ||
                        obj.getOldValue() instanceof Map) {
                    if (obj.getNewValue() instanceof Boolean
                            ||
                            obj.getNewValue() instanceof Map
                            ||
                            obj.getNewValue().equals("null")) {
                        plainFormat = plainFormat + "Property '"
                                +
                                obj.getKey() + "' was updated. From [complex value] to " + obj.getNewValue() + "\n";
                    } else {
                        plainFormat = plainFormat + "Property '"
                                +
                                obj.getKey() + "' was updated. From [complex value] to '" + obj.getNewValue() + "'\n";
                    }
                } else {
                    if (obj.getNewValue() instanceof Boolean
                            ||
                            obj.getNewValue() instanceof Integer
                            ||
                            obj.getNewValue().equals("null")) {
                        if (obj.getOldValue() instanceof Boolean
                                ||
                                obj.getOldValue() instanceof Integer
                                ||
                                obj.getOldValue().equals("null")) {
                            plainFormat = plainFormat + "Property '"
                                    +
                                    obj.getKey() + "' was updated. From " + obj.getOldValue() + " to "
                                    +
                                    obj.getNewValue() + "\n";
                        } else {
                            plainFormat = plainFormat + "Property '"
                                    +
                                    obj.getKey() + "' was updated. From '"
                                    +
                                    obj.getOldValue() + "' to " + obj.getNewValue() + "\n";
                        }
                    } else if (obj.getOldValue() instanceof Boolean
                            ||
                            obj.getOldValue() instanceof Integer
                            ||
                            obj.getOldValue().equals("null")) {
                        plainFormat = plainFormat + "Property '" + obj.getKey()
                                +
                                "' was updated. From " + obj.getOldValue() + " to '" + obj.getNewValue() + "'\n";
                    } else {
                        plainFormat = plainFormat + "Property '"
                                +
                                obj.getKey() + "' was updated. From '" + obj.getOldValue()
                                +
                                "' to '" + obj.getNewValue() + "'\n";
                    }
                }
            }
        }
        return plainFormat.stripTrailing();
    }
}


