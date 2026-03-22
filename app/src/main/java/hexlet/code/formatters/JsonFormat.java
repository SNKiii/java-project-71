package hexlet.code.formatters;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonFormat {
    public static String jsonFormater(List<Status> list) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        for (var obj : list) {
            if (obj.getStatusName().equals(Status.ADDED)) {
                map.put(Status.ADDED + " " + obj.getKey(), obj.getOldValue());
            } else if (obj.getStatusName().equals(Status.DELETED)) {
                map.put(Status.DELETED + " " + obj.getKey(), obj.getOldValue());
            } else if (obj.getStatusName().equals(Status.CHANGED)) {
                map.put(Status.CHANGED + " " + obj.getKey(), "old: "
                        +
                        obj.getOldValue() + " new: " + obj.getNewValue());
            } else if (obj.getStatusName().equals(Status.UNCHANGED)) {
                map.put(Status.UNCHANGED + " " + obj.getKey(), obj.getOldValue());
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}


