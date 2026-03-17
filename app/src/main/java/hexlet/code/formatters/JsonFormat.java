package hexlet.code.formatters;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonFormat {
    public static String jsonFormater(Map<String, Object> map)
            throws JsonProcessingException {
        String startValue = "{\n \"All replace\": [\n";
        String endValue = "\n ]\n}";
        List<String> listRemove = new ArrayList<>();
        List<String> listAdd = new ArrayList<>();
        List<String> listReplace = new ArrayList<>();
        List<Object> valueOneObject = new ArrayList<>();
        map.forEach((key, value) -> {
            String[] arrKey = key.split(" #RAZDEL# ");
            if (arrKey[0].equals("remote")) {
                listRemove.add("   \"operation\": \"remove\",\n" + "   \"name\": \"" + arrKey[1] + "\",\n   \"value\": " + null);
            } else if (arrKey[0].equals("add")) {
                String result = "   \"operation\": \"add\",\n" + "   \"name\": \"" + arrKey[1] + "\",\n   \"value\": ";
                String startString = "";
                String endString = "";
                ObjectMapper mapper = new ObjectMapper();
                if ((!(value instanceof Boolean) && !(value instanceof Integer)) || !value.equals("null")) {
                startString = "\"";
                endString = "\"";
                }
                if (value instanceof List) {
                List<?> list = (List<?>) value;
                 String listNew = list.stream()
                    .map(item -> "\"" + item.toString() + "\"")
                    .collect(Collectors.joining(", ", "[", "]"));
                 listAdd.add(result + listNew);
                } else if (value instanceof  Map) {
                    try {
                        String mapJson = null;
                        mapJson = mapper.writeValueAsString(value);
                        listAdd.add(result + mapJson);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    } else {
                        listAdd.add(result + startString + value + endString);
                }
            } else if (arrKey[0].equals("unfaithful two")) {
                String startString = "\"";
                String endString = "\"";
                String result = "   \"operation\": \"replace\",\n" + "   \"name\": \"" + arrKey[1] + "\",\n   \"value\": ";
                ObjectMapper mapper = new ObjectMapper();
                if ((value instanceof Boolean || value instanceof Integer) || value.equals("null")) {
                    startString = "";
                    endString = "";
                }
                if (value instanceof List) {
                    List<?> list = (List<?>) value;
                    String listNew = list.stream()
                            .map(item -> "\"" + item.toString() + "\"")
                            .collect(Collectors.joining(", ", "[", "]"));
                    listReplace.add(result + listNew);
                    valueOneObject.add(key);
                } else if (value instanceof  Map) {
                    try {
                        String mapJson = mapper.writeValueAsString(value);
                        listReplace.add(result + mapJson);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                } else {

                    if(!valueOneObject.isEmpty() && key != valueOneObject.get(0)) {
                        listReplace.add(result + startString + value + endString);
                    }
                }
            }
        });

        for (int i = 0; i < listAdd.size(); i++) {
            if ( i != 0) {
                startValue += ",\n";
            }
            startValue += "  {\n" + listAdd.get(i) + "\n  }";
        }

        for (int i = 0; i < listRemove.size(); i++) {
            startValue += ",\n";
            startValue += "  {\n" + listRemove.get(i) + "\n  }";
        }

        for (int i = 0; i < listReplace.size(); i++) {
            startValue += ",\n";
            startValue += "  {\n" + listReplace.get(i) + "\n  }";
        }
        return startValue + endValue;
    }
    }


