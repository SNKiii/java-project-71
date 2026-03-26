package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainConversion;
import hexlet.code.formatters.StylishConversion;

import java.util.List;
import java.util.Map;
import java.util.Set;

//Класс вызовы нужного формата
public class Formatter {
    public static String selectFormat(Map<String, List<Status>> map) throws JsonProcessingException {
        if (map.containsKey("stylish")) {
            return StylishConversion.defaultConvers(map.get("stylish"));
        } else if (map.containsKey("plain")) {
            return PlainConversion.plainFormater(map.get("plain"));
        } else if (map.containsKey("json")) {
            return JsonFormat.jsonFormater(map.get("json"));
        } else {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                return  StylishConversion.defaultConvers(map.get(key));
            }
        }
        System.out.println("dddd");
        return "";
    }
}
