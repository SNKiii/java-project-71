import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import hexlet.code.*;

public class TestOne {

    @Test
    void indenticalTest() throws IOException{
        String indenticalJsonFile = "C:\\Users\\Lenovo\\IdeaProjects\\java-project-7170\\app\\src\\test" +
                "\\jsonTestFiles\\IndenticalFile.json";
            String TrueString = """
                    follow: false
                    host: hexlet.io
                    proxy: 123.234.53.22
                    timeout: 50;
                  """;
        assertEquals(TrueString, FilterList.sorted(indenticalJsonFile, indenticalJsonFile));
    }


    void EmptyFiletest() throws IOException {
        String emprtyJsonFile = "C:\\Users\\Lenovo\\IdeaProjects\\java-project-7170\\app\\src\\test" +
                "\\jsonTestFiles\\empty.json";
        String jsonFile = "C:\\Users\\Lenovo\\IdeaProjects\\java-project-7170\\app\\src\\test" +
                "\\jsonTestFiles\\IndenticalFile.json";
        String TrueStringOne = """
                follow: false\n" +
                "  host: hexlet.io\n" +
                "  proxy: 123.234.53.22\n" +
                "  timeout: 50
                """;
        String TrueStringTwo = "";
        assertEquals(TrueStringOne, FilterList.sorted(emprtyJsonFile, jsonFile));
        assertEquals(TrueStringTwo, FilterList.sorted(emprtyJsonFile, emprtyJsonFile));
    }
}