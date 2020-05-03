package wordChecker;

import java.util.stream.*;
import java.util.Map;
import java.util.*;
import java.util.ArrayList;
import java.util.Map.Entry;
import javafx.util.Pair;

public class wordChecker {

    public static List<Pair<String, Integer>> getAllLongestWords(String sentence) {

        List<String> longestWords = getStream(sentence).max(Map.Entry.comparingByKey()).map(Map.Entry::getValue)
                .orElse(null);

        return ((longestWords == null) || longestWords.get(0).length() == 0) ? new ArrayList<Pair<String, Integer>>() : getListOfWords(longestWords);
    }

    public static List<Pair<String, Integer>> getAllShortestWords(String sentence) {

        List<String> shortestWords = getStream(sentence).min(Map.Entry.comparingByKey()).map(Map.Entry::getValue)
                .orElse(null);

        return ((shortestWords == null) || shortestWords.get(0).length() == 0) ? new ArrayList<Pair<String, Integer>>() : getListOfWords(shortestWords);
    }

    private static Integer getWordLength(String word) {
        return word.length();
    }

    private static Stream<Entry<Integer, List<String>>> getStream(String sentence) {
        System.out.println("Input string is: [" + "\"" + sentence + "\"" + "]\n");
        String[] words = sentence.split("\\s+");
        return Stream.of(words).collect(Collectors.groupingBy(String::length)).entrySet().stream();
    }

    private static List<Pair<String, Integer>> getListOfWords(List<String> words) {
        List<Pair<String, Integer>> list = new ArrayList<>();

        Integer len = getWordLength(words.get(0)); 

        words.forEach(item -> {
            list.add(new Pair<>("\"" + item + "\"",len));
        });
        
        return list;
    }

    public static void write(String message, List<Pair<String, Integer>> words) {
        System.out.println(message);
        words.forEach(pair -> {
            System.out.println(pair.getKey() + "," + pair.getValue());
        });
    }
}
