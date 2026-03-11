package formatters;

public class StylishConversion {

    public static <T, Y> String defaultConvers(boolean check, String key, T valueOne, Y valueTwo) {
        if (valueTwo == null && valueOne == null) {
            return "";
        }
        if (check) {
            return "  " + key + ": " + valueOne;
        } else {
            return "- " + key + "/abc1: " + valueOne + " @#R!Z " + "+ " + key + ": " + valueTwo;
        }
    }

    public static <T> String defaultConvers(String key, T valueOne) {
        return "- " + key + ": " + valueOne;
    }

    public static <T> String defaultConvers(String key, T value, int stub) {
        return "+ " + key + ": " + value;
    }
}
