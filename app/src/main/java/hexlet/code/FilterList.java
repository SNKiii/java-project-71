package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FilterList {
public static String sorted(String jsonOne, String jsonTwo) throws IOException {
    String result = "";
    List<String> newList = new ArrayList<>(ComparingJsFiles.comparing(jsonOne, jsonTwo));
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
}
