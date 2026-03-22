package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true,
        versionProvider = VersionProvider.class)

public final class App implements Runnable, Callable<Integer> {

    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @Override
    public Integer call() {
        try {
            String formattedDiff = Differ.generate(filePath1, filePath2, stylish);
            System.out.println(formattedDiff);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }

        return SUCCESS_EXIT_CODE;
    }

    @Parameters(index = "0", paramLabel =  "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(index = "1", paramLabel =  "filepath2", description = "path to second file")
    private String filePath2;
    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]",
            defaultValue = "standart"
    )
    private String stylish;
    @Override
    public  void run() {
        try {
            int exitCode = call();
            System.exit(exitCode);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(ERROR_EXIT_CODE);
        }
    }


    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
