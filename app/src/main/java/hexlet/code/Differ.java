package hexlet.code;


import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2, String nameFormat) throws IOException {

        String formatName = switch (nameFormat) {
            case "plain", "json" -> nameFormat;
            default -> "standart";
        };
        String contentOne = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath1));
            String formatOne;
            String formatTwo;
            if (filePath1.endsWith(".json")) {
                formatOne = "json";
            } else if (filePath1.endsWith(".yaml") || filePath1.endsWith(".yml")) {
                formatOne = "yaml";
            } else {
                System.err.println("Поддерживается только JSON или YAML");
                return null;
            }
            String contentTwo = java.nio.file.Files.readString(java.nio.file.Paths.get(filePath2));
            if (filePath2.endsWith(".json")) {
            formatTwo = "json";
            } else if (filePath2.endsWith(".yaml") || filePath2.endsWith(".yml")) {
            formatTwo = "yaml";
            } else {
            System.err.println("Поддерживается только JSON или YAML");
            return null;
            }
        Map<String, Object> mapJsonOne =  Parser.parseContent(contentOne, formatOne);
        Map<String, Object> mapJsonTwo =  Parser.parseContent(contentTwo, formatTwo);
        var list = Unterschied.unterschied(mapJsonOne, mapJsonTwo);
        if (list.isEmpty()) {
            return "";
        }
        list.sort(Comparator.comparing(Status::getKey));
        return Formatter.selectFormat(Map.of(formatName, list));
    }
}
