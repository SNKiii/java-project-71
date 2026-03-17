package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainConversionFiles;
import hexlet.code.formatters.StylishConversion;

import java.util.Map;

public class Formatter {
    public static String selectFormat(Map<String, Object> map) {
        if (map.containsKey("style")) {
            if (map.get("style").equals("standart")) {
                map.remove("style");
                return StylishConversion.defaultConvers(map);
            } else if (map.get("style").equals("plain")) {
                map.remove("style");
                return PlainConversionFiles.plainFormater(map);
            } else if (map.get("style").equals("json")) {
                map.remove("style");
                try {
                    return JsonFormat.jsonFormater(map);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return "";
    }
}
