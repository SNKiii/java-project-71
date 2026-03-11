package test.plain.conversion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import hexlet.code.FilterList;

import java.io.IOException;

public class TestOne {
    @Test
    void indenticalTest() throws IOException {
        String indenticalJsonFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712"
                +
                "\\app\\src\\main\\resources"
                +
                "\\json_file\\fileTwo.json";
        String trueString = "";
        assertEquals(trueString, FilterList.sorted(indenticalJsonFile, indenticalJsonFile, "plain"));
    }

    @Test
    void correctWorkTest() throws  IOException {
        String oneJsonFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src\\main\\resources"
                +
                "\\json_file\\fileOne.json";
        String twoJsonFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src\\main\\resources"
                +
                "\\json_file\\fileTwo.json";
        String trueString = "Property 'chars2' was updated. From [complex value] to false\n"
                +
                "Property 'checked' was updated. From false to true\n"
                +
                "Property 'default' was updated. From 'null' to [complex value]\n"
                +
                "Property 'id' was updated. From 45 to null\n"
                +
                "Property 'key1' was removed\n"
                +
                "Property 'key2' was added with value: 'value2'\n"
                +
                "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                +
                "Property 'numbers3' was removed\n"
                +
                "Property 'numbers4' was added with value: [complex value]\n"
                +
                "Property 'obj1' was added with value: [complex value]\n"
                +
                "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                +
                "Property 'setting2' was updated. From 200 to 300\n"
                +
                "Property 'setting3' was updated. From 'true' to 'none'\n";
        assertEquals(trueString, FilterList.sorted(oneJsonFile, twoJsonFile, "plain"));
    }
}
