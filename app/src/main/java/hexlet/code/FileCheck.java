package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

 class FileCheck {
     public static Map<String, Object> checkFile(String file) throws IOException {
         ObjectMapper mapper = new ObjectMapper();
         if (file == null || file == "") {
             return null;
         }
         try {
             File newFile = new File(file);
             Map<String, Object> result = mapper.readValue(newFile, new TypeReference<Map<String, Object>>() {
             });
             return result;
         } catch (IOException e) {
             System.err.println("Ошибка чтения JSON: " + e.getMessage());
             e.printStackTrace();
         }

         return Map.of();
     }
 }
