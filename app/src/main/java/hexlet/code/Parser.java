package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.util.Map;

 class Parser {
        public static Map<String, Object> parseContent(String content, String format) {
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

            try {
                return mapper.readValue(content, new TypeReference<Map<String, Object>>() {
                 });
            } catch (IOException e) {
                System.err.println("Ошибка парсинга: " + e.getMessage());
                return Map.of();
            }
        }
     }
