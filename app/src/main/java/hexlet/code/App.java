package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.Map;

import java.io.File;
import java.io.IOException;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true,
        versionProvider = VersionProvider.class)

public class App implements Runnable {
    @Parameters(index = "0", paramLabel =  "filepath1", description = "path to first file")
    private File filePath1;
    @Parameters(index = "1", paramLabel =  "filepath2", description = "path to second file")
    private File filePath2;
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private File inputFile;
    @Override
    public void run() {
        System.out.println("Running with input file");
    }

    public static void main(String[] args) throws IOException {
       // Map<String, Object> newFile = FileCheck.checkFile("app/src/main/java/json_file/file1.json");
        //newFile.forEach((key, value) -> System.out.println(key + ":" + value));
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
