import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    @Test
    void testStylishConversion() {
        String pathOne = "src/test/resources/JsonOne.json";
        String pathTwo = "src/test/resources/JsonTwo.json";
        String pathOneYML = "src/test/resources/YamlOne.yaml";
        String pathTwoYML = "src/test/resources/YamlTwo.yaml";
        String patchResult = "src/test/resources/true.formaters/StandartFormat";
        try {
            String trueResult = Files.readString(Paths.get(patchResult), StandardCharsets.UTF_8);
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOne, pathTwo, "standart"));
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOneYML, pathTwoYML, "standart"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testPlainConversion() {
        String pathOne = "src/test/resources/OneJson.json";
        String pathTwo = "src/test/resources/TwoJson.json";
        String patchResult = "src/test/resources/true.formaters/PlainFormat";
        String pathOneYML = "src/test/resources/OneYaml.yaml";
        String pathTwoYML = "src/test/resources/TwoYaml.yaml";
        try {
            String trueResult = Files.readString(Paths.get(patchResult), StandardCharsets.UTF_8);
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOne, pathTwo, "plain"));
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOneYML, pathTwoYML, "plain"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testJsonFormater() {
        String pathOne = "src/test/resources/OneJson.json";
        String pathTwo = "src/test/resources/TwoJson.json";
        String patchResult = "src/test/resources/true.formaters/JsonFormat";
        String pathOneYML = "src/test/resources/OneYaml.yaml";
        String pathTwoYML = "src/test/resources/TwoYaml.yaml";
        try {
            String trueResult = Files.readString(Paths.get(patchResult), StandardCharsets.UTF_8);
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOne, pathTwo, "json"));
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOneYML, pathTwoYML, "json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void  testDefoultFormater() {
        String pathOne = "src/test/resources/JsonOne.json";
        String pathTwo = "src/test/resources/JsonTwo.json";
        String pathOneYML = "src/test/resources/YamlOne.yaml";
        String pathTwoYML = "src/test/resources/YamlTwo.yaml";
        String patchResult = "src/test/resources/true.formaters/StandartFormat";
        try {
            String trueResult = Files.readString(Paths.get(patchResult), StandardCharsets.UTF_8);
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOne, pathTwo, ""));
            assertEquals(trueResult.stripTrailing(),
                    Differ.generate(pathOneYML, pathTwoYML, ""));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
