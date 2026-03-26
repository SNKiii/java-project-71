package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;

//Стандартный формат
public class StylishConversion {

    public static String defaultConvers(List<Status> list) {
        String standartFormat = "{";
        for (var obj : list) {
            if (obj.getStatusName().equals(Status.ADDED)) {
                standartFormat = standartFormat + "\n  + " + obj.getKey() + ": " + obj.getOldValue();
            } else if  (obj.getStatusName().equals(Status.DELETED)) {
                standartFormat = standartFormat + "\n  - " + obj.getKey() + ": " + obj.getOldValue();
            } else if (obj.getStatusName().equals(Status.UNCHANGED)) {
                standartFormat = standartFormat + "\n    " + obj.getKey() + ": " + obj.getOldValue();
            } else if (obj.getStatusName().equals(Status.CHANGED)) {
                standartFormat = standartFormat + "\n  - " + obj.getKey() + ": " + obj.getOldValue();
                standartFormat = standartFormat + "\n  + " + obj.getKey() + ": " + obj.getNewValue();
            }
        }
        return standartFormat + "\n}";
    }
}
