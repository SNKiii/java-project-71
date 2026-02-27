package hexlet.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ComparingJsFiles {
    public static List<String> comparing(String jsonOne, String jsonTwo) throws IOException {
            List<String> comparList = new ArrayList<>();
            var mapJsonOne = FileCheck.checkFile(jsonOne);
            var mapJsonTwo = FileCheck.checkFile(jsonTwo);

        if (mapJsonOne != null) {
            mapJsonOne.forEach((key, value) -> {
                String valueStr = value.toString();
                if (valueStr == null || valueStr.trim().isEmpty() || key == null || key.trim().isEmpty()) {
                    return;
                }
                if (mapJsonTwo != null && mapJsonTwo.containsKey(key)) {
                      if (mapJsonOne.get(key).equals(mapJsonTwo.get(key))) {
                          comparList.add("  " + key + ": " + value);
                          mapJsonTwo.remove(key);
                      } else {
                          // /abc1 - an abbreviation that indicates that the string refers to the first json file.
                          comparList.add("- " + key + "/abc1: " + value);
                          comparList.add("+ " + key + ": " + mapJsonTwo.get(key));
                          mapJsonTwo.remove(key);
                      }
                  } else {
                      comparList.add("- " + key + ": " + value);
                  }
                });
        }
        if (mapJsonTwo != null) {
            mapJsonTwo.forEach((key, value) -> {
                comparList.add("+ " + key + ": " +  value);
                });
        }
        return comparList;
    }
}
