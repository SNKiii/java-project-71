import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import hexlet.code.FilterList;

import java.io.IOException;

public class TestOne {

    @Test
    void indenticalTest() throws IOException {
        String indenticalJsonFile = "C:\\Users\\Lenovo\\IdeaProjects\\java-project-7170\\app\\src\\test\\resources"
                + "\\jsonTestFiles\\IndenticalFile.json";
            String trueString = """
                    follow: false
                    host: hexlet.io
                    proxy: 123.234.53.22
                    timeout: 50
                  """;
        assertEquals(trueString, FilterList.sorted(indenticalJsonFile, indenticalJsonFile));
    }

    @Test
    void nullValuesTest() throws IOException {
        String jsonOneFile = "C:\\Users\\Lenovo\\IdeaProjects\\java-project-7170\\app\\src\\test\\resources"
                + "\\jsonTestFiles\\trueJsonFile.json";
        String jsonTwoFile = "C:\\Users\\Lenovo\\IdeaProjects\\java-project-7170\\app\\src\\test\\resources"
                + "\\jsonTestFiles\\falseJsonFile.json";
        String trueString = """
                  keyOne: 12
                + keyThree: 13
                  keyTwo: value
                """;
        assertEquals(trueString, FilterList.sorted(jsonOneFile, jsonTwoFile));
    }


}