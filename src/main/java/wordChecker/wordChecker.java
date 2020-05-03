package wordChecker;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;

public class wordChecker {

    public static List<String> getAllLongestWords(String sentence) {

        List<String> longestWords = getStream(sentence)
                                    .max(Map.Entry.comparingByKey())
                                    .map(Map.Entry::getValue)
                                    .orElse(null);

        return getListOfWords(longestWords);
    }

    public static List<String> getAllShortestWords(String sentence) {

        List<String> shortestWords = getStream(sentence)
                                    .min(Map.Entry.comparingByKey())
                                    .map(Map.Entry::getValue)
                                    .orElse(null);

        return getListOfWords(shortestWords);
    }

    private static Integer getWordLength(String word) {
        return word.length();
    }

    private static Stream<Entry<Integer, List<String>>> getStream(String sentence) {
        String[] matches = sentence.split(" ");
        return Stream.of(matches).collect(Collectors.groupingBy(String::length)).entrySet().stream();
    }

    private static List<String> getListOfWords(List<String> words) {
        List<String> list = new ArrayList<String>();

        Integer len = getWordLength(words.get(0));

        words.forEach(item -> {
            list.add("\"" + item + "\"" + "," + len);
        });

        return list;
    }
}
