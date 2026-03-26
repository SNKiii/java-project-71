package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;

//Парсер json\yaml файлов
class Parser {
    public static Map<String, Object> parseContent(String content, String format) throws JsonProcessingException {
        if (content == null || content.isEmpty()) {
            return Map.of();
        }
        ObjectMapper mapper;
        if ("json".equalsIgnoreCase(format)) {
            mapper = new ObjectMapper();
        } else if ("yaml".equalsIgnoreCase(format)) {
            mapper = new ObjectMapper(new YAMLFactory());
        } else {
            System.err.println("Неподдерживаемый формат: " + format);
            return Map.of();
        }
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
    }
}
