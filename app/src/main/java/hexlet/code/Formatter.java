package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainConversion;
import hexlet.code.formatters.StylishConversion;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String selectFormat(Map<String, List<Status>> map) throws JsonProcessingException {
        if (map.containsKey("standart")) {
            return StylishConversion.defaultConvers(map.get("standart"));
        } else if (map.containsKey("plain")) {
            return PlainConversion.plainFormater(map.get("plain"));
        } else if (map.containsKey("json")) {
            return JsonFormat.jsonFormater(map.get("json"));
        }
        System.out.println("dddd");
        return "";
    }
}
