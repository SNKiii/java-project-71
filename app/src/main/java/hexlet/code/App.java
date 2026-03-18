package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true,
        versionProvider = VersionProvider.class)

public class App implements Runnable {
    @Parameters(index = "0", paramLabel =  "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(index = "1", paramLabel =  "filepath2", description = "path to second file")
    private String filePath2;
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String stylish;
    @Override
    public final void run() {
        if (stylish == null || stylish.isEmpty()) {
            try {
                System.out.println(Differ.generate(filePath1, filePath2));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                System.out.println(Differ.generate(filePath1, filePath2, stylish));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
