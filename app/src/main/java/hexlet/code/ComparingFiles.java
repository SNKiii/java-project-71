package hexlet.code;


import java.util.List;
import java.util.Map;

public class ComparingFiles {

    public static  boolean comparing(List<?> listOne, List<?> listTwo) {
        return listOne.equals(listTwo);
    }

    public  static  boolean comparing(Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        return mapOne.equals(mapTwo);
    }

    public  static  boolean comparing(Object objOne, Object objTwo) {
        return objOne.equals(objTwo);
    }
    }

