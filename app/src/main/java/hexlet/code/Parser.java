package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;

 class Parser {

     public static Object checkFormatFile(String file) {
         if (file.contains(".json")) {
             return checkJsonFile(file);
         } else if (file.contains("yaml")) {
             return checkYamlFile(file);
         }
         return Map.of();
     }

     private static Map<String, Object> checkJsonFile(String file) {
         ObjectMapper mapper = new ObjectMapper();
         if (file == null || file.isEmpty()) {
             return null;
         }
         try {
             File newFile = new File(file);
             Map<String, Object> stringObjectMap = mapper.readValue(newFile, new TypeReference<Map<String, Object>>() {
             });
             return stringObjectMap;
         } catch (IOException e) {
             System.err.println("Ошибка чтения JSON: " + e.getMessage());
             e.printStackTrace();
         }
         return Map.of();
     }

     private static Map<String, Object> checkYamlFile(String file) {
         ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
         if (file == null || file.isEmpty()) {
             return null;
         }
         try {
             File newFile = new File(file);
             Map<String, Object> stringObjectMap = yamlMapper.readValue(newFile,
                     new TypeReference<Map<String, Object>>() {
             });
             return stringObjectMap;
         } catch (IOException e) {
             System.err.println("Ошибка чтения YAML: " + e.getMessage());
             e.printStackTrace();
         }
         return Map.of();
     }
 }
