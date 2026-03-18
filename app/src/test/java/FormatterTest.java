import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    @Test
    void testStylishConversion() {
        String pathOne = "src/test/resources/JsonOne.json";
        String pathTwo = "src/test/resources/JsonTwo.json";
        String trueResult = """
                  keyOne: 12
                - keyThree: 13
                + keyThree: [a, b]
                  keyTwo: value
                """;
        try {
            assertEquals(trueResult, Differ.generate(pathOne, pathTwo));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testPlainConversion() {
        String pathOne = "src/test/resources/OneJson.json";
        String pathTwo = "src/test/resources/TwoJson.json";
        String trueResult = """
                Property 'keyOne' was updated. From '12' to [complex value]
                Property 'keyThree' was updated. From '13' to null
                Property 'obj1' was removed
                Property 'yach' was added with value: [complex value]
                """;

        try {
            assertEquals(trueResult, Differ.generate(pathOne, pathTwo, "plain"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testJsonFormater() {
        String pathOne = "src/test/resources/OneJson.json";
        String pathTwo = "src/test/resources/TwoJson.json";
        String trueResult = """
                {
                 "All replace": [
                  {
                   "operation": "add",
                   "name": "yach",
                   "value": ["one", "two"]
                  },
                  {
                   "operation": "remove",
                   "name": "obj1",
                   "value": null
                  },
                  {
                   "operation": "replace",
                   "name": "keyOne",
                   "value": ["1", "3", "5"]
                  },
                  {
                   "operation": "replace",
                   "name": "keyThree",
                   "value": null
                  }
                 ]
                }
                 """;
        try {
            assertEquals(trueResult.stripTrailing().replace("\r\n", "\n")
                    .trim(),
                    Differ.generate(pathOne, pathTwo, "json").replace("\r\n", "\n"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
