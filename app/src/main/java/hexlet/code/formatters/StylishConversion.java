package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class StylishConversion {

    public static String defaultConvers(Map<String, Object> map) {
        String standartFormat = "";
        List<String> list = new ArrayList<>();
        AtomicReference<Integer> count = new AtomicReference<>(0);
        map.forEach((key, value) -> {
            String[] arrKey = key.split(" #RAZDEL# ");
            if (arrKey[0].equals("inchanges")) {
                list.add("  " + arrKey[1] + ": " + value);
            } else if (arrKey[0].equals("remote")) {
                list.add("- " + arrKey[1] + ": " + value);
            } else if (arrKey[0].equals("add")) {
                list.add("+ " + arrKey[1] + ": " + value);
            } else if (arrKey[0].equals("unfaithful one") && count.get() == 0) {
                list.add("- " + arrKey[1] + ": " + value);
                count.updateAndGet(v -> v + 1);
            } else {
                list.add("+ " + arrKey[1] + ": " + value);
                count.updateAndGet(v -> v - 1);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            standartFormat += list.get(i) + "\n";
        }
        return standartFormat;
    }
}
