package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FilterList {
    public static String sorted(String stringOne, String stringTwo, String style) throws IOException {
    String result = "";
    List<String> newList = new ArrayList<>(StringConversionFiles.comparing(stringOne, stringTwo, style));
    Collections.sort(newList, (s1, s2) -> {
        String cleanOne = s1.replaceAll("^[^a-zA-Z]+", "");
        String cleanTwo = s2.replaceAll("^[^a-zA-Z]+", "");
        return cleanOne.compareToIgnoreCase(cleanTwo);
    });

    for (String i : newList) {
        result += i + "\n";
    }
    return  result.replaceAll("\"", "").replaceAll("/abc1", "");
}
    public static String sorted(String stringOne, String stringTwo) throws IOException {
        String result = "";
        List<String> newList = new ArrayList<>(StringConversionFiles.comparing(stringOne, stringTwo, "json"));
        Collections.sort(newList, (s1, s2) -> {
            String cleanOne = s1.replaceAll("^[^a-zA-Z]+", "");
            String cleanTwo = s2.replaceAll("^[^a-zA-Z]+", "");
            return cleanOne.compareToIgnoreCase(cleanTwo);
        });
        for (int i = 0; i < newList.size(); i++) {
            if(i != newList.size() - 1) {
                result += "  {\n" + newList.get(i) + "\n  },\n";
            } else {
                result += "  {\n" + newList.get(i) + "\n  }\n";
            }
        }
        return "{\n \"All replace\": [\n" + result + " ]\n}" ;
    }
}
