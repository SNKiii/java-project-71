package hexlet.code;


import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

public class Differ {

    private static String getDataFormat(String filePath) throws IOException {
        if (filePath.endsWith(".json")) {
            return "json";
        } else if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            return "yaml";
        } else {
            System.err.println("Поддерживается только JSON или YAML");
            return null;
        }
    }
    public static String generate(String filePath1, String filePath2, String nameFormat) throws IOException {
        String contentOne = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath1));
        String contentTwo = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath2));
        String formatOne;
        String formatTwo;
        Map<String, Object> mapJsonOne =  Parser.parseContent(contentOne, getDataFormat(filePath1));
        Map<String, Object> mapJsonTwo =  Parser.parseContent(contentTwo, getDataFormat(filePath2));
        var list = Unterschied.unterschied(mapJsonOne, mapJsonTwo);
        if (list.isEmpty()) {
            return "";
        }
        list.sort(Comparator.comparing(Status::getKey));
        return Formatter.selectFormat(Map.of(nameFormat, list));
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }
}
