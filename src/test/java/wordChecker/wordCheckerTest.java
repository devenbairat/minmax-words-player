package wordChecker;

import org.junit.Test;
import java.util.List;

public class wordCheckerTest {

    String sentence = "Social-distancing at airports is 'impossible', says Heathrow boss";
    @Test
    public void printLongestWords() throws Exception {
        List<String> longestWords = wordChecker.getAllLongestWords(sentence);
        System.out.print("Longest word/s in the sentence is/are:\n");
        longestWords.forEach(System.out::println);
    }

    @Test
    public void printShortestWords() throws Exception {
        List<String> shortestWords = wordChecker.getAllShortestWords(sentence);
        System.out.print("Shortest word/s in the sentence is/are:\n");
        shortestWords.forEach(System.out::println);
    }
}