package TestStandartConversion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import hexlet.code.FilterList;

import java.io.IOException;

public class TestOne {

    @Test
    void indenticalTest() throws IOException {
        String indenticalJsonFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src\\test\\resources"
                + "\\jsonTestFiles\\IndenticalFile.json";
            String trueString = """
                    follow: false
                    host: hexlet.io
                    proxy: 123.234.53.22
                    timeout: 50
                  """;
        assertEquals(trueString, FilterList.sorted(indenticalJsonFile, indenticalJsonFile,"standart"));
    }

    @Test
    void nullValuesTest() throws IOException {
        String jsonTwoFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src\\test\\resources\\jsonTestFiles\\falseJsonFile.json";
        String jsonOneFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src\\test\\resources\\jsonTestFiles\\trueJsonFile.json";
        String trueString = """
                  keyOne: 12
                - keyThree: \n+ keyThree: 13
                  keyTwo: value
                """;
        assertEquals(trueString, FilterList.sorted(jsonOneFile, jsonTwoFile, "standart"));
    }

    @Test
    void correctWorkTest() throws IOException {
        String jsonOneFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src\\test\\resources"
                + "\\jsonTestFiles\\testCorrectWork\\fileOne.json";
        String jsonTwoFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src\\test\\resources"
                + "\\jsonTestFiles\\testCorrectWork\\fileTwo.json";
        String trueString = """
          chars1: [a, b, c]
        - chars2: [d, e, f]
        + chars2: false
        - checked: false
        + checked: true
        - default: null
        + default: [value1, value2]
        - id: 45
        + id: null
        - key1: value1
        + key2: value2
          numbers1: [1, 2, 3, 4]
        - numbers2: [2, 3, 4, 5]
        + numbers2: [22, 33, 44, 55]
        - numbers3: [3, 4, 5]
        + numbers4: [4, 5, 6]
        + obj1: {nestedKey=value, isNested=true}
        - setting1: Some value
        + setting1: Another value
        - setting2: 200
        + setting2: 300
        - setting3: true
        + setting3: none
        """;
        assertEquals(trueString, FilterList.sorted(jsonOneFile, jsonTwoFile, "standart"));
    }

}