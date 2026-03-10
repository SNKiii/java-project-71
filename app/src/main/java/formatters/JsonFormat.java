package formatters;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonFormat {
    public static String jsonFormater(boolean check, String key, Object valueTwo, Object valueOne) throws JsonProcessingException {
        if(valueTwo == null && valueOne == null) {
            return "";
        }
        String startValue = "";
        String endValue = "";
        ObjectMapper mapper = new ObjectMapper();
        if(!(valueTwo instanceof Boolean) && !(valueTwo instanceof Integer)) {
            startValue = "\"";
            endValue = "\"";
        }
        if(!check) {
            String result = "   \"operation\": \"replace\",\n" + "   \"name\": \"" + key + "\",\n   \"value\": ";
                if(valueTwo instanceof List) {
                    List<?> list = (List<?>) valueTwo;
                    String listNew = list.stream()
                            .map(item -> "\"" + item.toString() + "\"")
                            .collect(Collectors.joining(", ", "[", "]"));
                    return result + listNew;
                }
                if(valueTwo instanceof  Map) {
                    String mapJson = mapper.writeValueAsString(valueTwo);
                    return result + mapJson;
                } else {
                    return result + startValue + valueTwo + endValue;
                }
            }
        return "";
        }

    public static String jsonFormater(String key) {
        return  "   \"operation\": \"remove\",\n" + "   \"name\": \"" + key + "\",\n   \"value\": " + null;
    }

    public static String jsonFormater(String key, Object valueTwo) throws JsonProcessingException {
        String result = "   \"operation\": \"add\",\n" + "   \"name\": \"" + key + "\",\n   \"value\": ";
        String startValue = "";
        String endValue = "";
        ObjectMapper mapper = new ObjectMapper();
        if(!(valueTwo instanceof Boolean) && !(valueTwo instanceof Integer)) {
            startValue = "\"";
            endValue = "\"";
        }
        if(valueTwo instanceof List) {
            List<?> list = (List<?>) valueTwo;
            String listNew = list.stream()
                    .map(item -> "\"" + item.toString() + "\"")
                    .collect(Collectors.joining(", ", "[", "]"));
            return result + listNew;
        } else if(valueTwo instanceof  Map) {
            String mapJson = mapper.writeValueAsString(valueTwo);
            return result + mapJson;
        } else {
            return result + startValue + valueTwo + endValue;
        }
    }
    }


