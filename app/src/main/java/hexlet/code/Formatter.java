package hexlet.code;

import java.io.IOException;

public class Formatter {
    public static void selectFormat(String fileOne, String fileTwo, String format) {
        if (format == null) {
            format = "standart";
        }
            switch (format) {
                case "plain":
                    try {
                        System.out.println(FilterList.sorted(fileOne, fileTwo, format));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "json":
                    try {
                        System.out.println(FilterList.sorted(fileOne, fileTwo));
                    } catch (IOException e) {
                        throw  new RuntimeException(e);
                    }
                    break;
                default:
                    try {
                        System.out.println(FilterList.sorted(fileOne, fileTwo, format));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
    }
}
