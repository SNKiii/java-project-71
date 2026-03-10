package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import formatters.JsonFormat;
import formatters.PlainConversionFiles;
import formatters.StylishConversion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringConversionFiles {
    public static List<String> comparing(String fileOne, String fikeTwo, String style) throws IOException {
        List<String> comparList = new ArrayList<>();
        Map<String, ?> mapJsonOne = (Map<String, ?>) Parser.checkFormatFile(fileOne);
        Map<String, ?> mapJsonTwo = (Map<String, ?>) Parser.checkFormatFile(fikeTwo);

        mapJsonOne.forEach((key, value) -> {
            int outcomes = 0;
            boolean checkTrue = false;
            if (!mapJsonTwo.containsKey(key)) {
                outcomes = 1;
            }
            if (value != null && mapJsonTwo.get(key) != null) {
                if (mapJsonOne.get(key).equals(mapJsonTwo.get(key))) {
                    checkTrue = ComparingFiles.comparing(value, mapJsonTwo.get(key));
                }
            }
                if (style.equals("plain")) {
                    if (outcomes == 1) {
                        comparList.add(PlainConversionFiles.plainFormater(key));
                    } else {
                        comparList.add(PlainConversionFiles.plainFormater(checkTrue, key, value, mapJsonTwo.get(key)));
                        mapJsonTwo.remove(key);
                    }
                } else if(style.equals("json")) {
                    if(outcomes == 1) {
                        comparList.add(JsonFormat.jsonFormater(key));
                    } else {
                        try {
                            comparList.add(JsonFormat.jsonFormater(checkTrue, key, mapJsonTwo.get(key), value));
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                        mapJsonTwo.remove(key);
                    }
                } else {
                    if (outcomes == 1) {
                        comparList.add(StylishConversion.defaultConvers(key, value));
                    } else {
                        String stConString = StylishConversion.defaultConvers(checkTrue, key, value, mapJsonTwo.get(key));
                        String[] twoString = stConString.split(" @#R!Z ");
                        mapJsonTwo.remove(key);
                        for (String i : twoString) {
                            comparList.add(i);
                        }
                    }
                }
        });
        if (mapJsonTwo != null) {
            mapJsonTwo.forEach((key, value) -> {
                switch (style) {
                    case "plain":
                        comparList.add(PlainConversionFiles.plainFormater(key, value));
                        break;
                    case  "json":
                        try {
                            comparList.add(JsonFormat.jsonFormater(key, value));
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    default:
                        int stub = 0;
                        comparList.add(StylishConversion.defaultConvers(key, value, stub));
                }
            });
        }
        comparList.removeIf(String::isEmpty);
        return comparList;
    }
    }
