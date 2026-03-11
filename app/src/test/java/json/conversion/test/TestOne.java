package json.conversion.test;

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
                + "\\json_file\\fileTwo.json";
        String trueString = "";
        assertEquals(trueString, FilterList.sorted(indenticalJsonFile, indenticalJsonFile, "json"));
    }

    @Test
    void correctWorkTest() throws IOException {
        String oneJsonFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712"
                +
                "\\app\\src\\main\\resources"
                + "\\json_file\\fileOne.json";
        String twoJsonFile = "C:\\Users\\slei_ghoul228\\IdeaProjects\\java-project-712\\app\\src"
                +
                "\\main\\resources\\json_file\\fileTwo.json";
        String trueString = "{\n"
                +
                " \"All replace\": [\n"
                +
                "  {\n"
                +
                "   \"operation\": \"add\",\n"
                +
                "   \"name\": \"key2\",\n"
                +
                "   \"value\": \"value2\"\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"add\",\n"
                +
                "   \"name\": \"numbers4\",\n"
                +
                "   \"value\": [\"4\", \"5\", \"6\"]\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"add\",\n"
                +
                "   \"name\": \"obj1\",\n"
                +
                "   \"value\": {\"nestedKey\":\"value\",\"isNested\":true}\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"remove\",\n"
                +
                "   \"name\": \"key1\",\n"
                +
                "   \"value\": null\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"remove\",\n"
                +
                "   \"name\": \"numbers3\",\n"
                +
                "   \"value\": null\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"chars2\",\n"
                +
                "   \"value\": false\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"checked\",\n"
                +
                "   \"value\": true\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"default\",\n"
                +
                "   \"value\": [\"value1\", \"value2\"]\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"id\",\n"
                +
                "   \"value\": \"null\"\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"numbers2\",\n"
                +
                "   \"value\": [\"22\", \"33\", \"44\", \"55\"]\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"setting1\",\n"
                +
                "   \"value\": \"Another value\"\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"setting2\",\n"
                +
                "   \"value\": 300\n"
                +
                "  },\n"
                +
                "  {\n"
                +
                "   \"operation\": \"replace\",\n"
                +
                "   \"name\": \"setting3\",\n"
                +
                "   \"value\": \"none\"\n"
                +
                "  }\n"
                +
                " ]\n"
                +
                "}";
        assertEquals(trueString, FilterList.sorted(oneJsonFile, twoJsonFile));
    }
}
