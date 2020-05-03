package wordChecker;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import javafx.util.Pair;
import org.hamcrest.collection.IsEmptyCollection;

public class wordCheckerTest {

    @Test
    public void assertLongestWord() throws Exception {
        String sentence = "This test asserts the longest word in a given sentence";
        List<Pair<String, Integer>> longestWords = wordChecker.getAllLongestWords(sentence);
        
        assertEquals("\"sentence\"", longestWords.get(0).getKey());
        wordChecker.write("Longest word in the sentence is:", longestWords);
    }

    @Test
    public void assertShortestWord() throws Exception {
        String sentence = "This test asserts the shortest word in a given sentence";
        List<Pair<String, Integer>> shortestWords = wordChecker.getAllShortestWords(sentence);
        
        assertEquals("\"a\"", shortestWords.get(0).getKey());
        wordChecker.write("Shortest word in the sentence is:", shortestWords);
    }

    @Test
    public void assertMultipleLongestWords() throws Exception {
        String sentence = "This test asserts multiple longest words in a given sentence";
        List<Pair<String, Integer>> longestWords = wordChecker.getAllLongestWords(sentence);
        
        assertEquals(2, longestWords.size());
        assertEquals("\"multiple\"", longestWords.get(0).getKey());
        assertEquals("\"sentence\"", longestWords.get(1).getKey());
        wordChecker.write("Longest words in the sentence are:", longestWords);
    }

    @Test
    public void assertMultipleShortestWords() throws Exception {
        String sentence = "This test asserts multiple shortest words from given sentence";
        List<Pair<String, Integer>> shortestWords = wordChecker.getAllShortestWords(sentence);
        
        assertEquals(3, shortestWords.size());
        assertEquals("\"This\"", shortestWords.get(0).getKey());
        assertEquals("\"test\"", shortestWords.get(1).getKey());
        assertEquals("\"from\"", shortestWords.get(2).getKey());
        wordChecker.write("Shortest words in the sentence are:", shortestWords);
    }

    @Test
    public void assertLongestWordInStringWithWhiteSpaces() throws Exception {
        String sentence = "Test                           with      whitespaces";
        List<Pair<String, Integer>> longestWords = wordChecker.getAllLongestWords(sentence);
        
        assertEquals("\"whitespaces\"", longestWords.get(0).getKey());
        wordChecker.write("Longest word in the sentence is:", longestWords);
    }

    @Test
    public void assertNoErrorOnBlankString() throws Exception {
        String sentence = "     ";
        List<Pair<String, Integer>> longestWords = wordChecker.getAllLongestWords(sentence);
        List<Pair<String, Integer>> shortestWords = wordChecker.getAllShortestWords(sentence);
        assertThat(longestWords, IsEmptyCollection.empty());
        assertThat(shortestWords, IsEmptyCollection.empty());
    }

    @Test
    public void assertNoErrorOnEmptyString() throws Exception {
        String sentence = "";
        List<Pair<String, Integer>> longestWords = wordChecker.getAllLongestWords(sentence);
        List<Pair<String, Integer>> shortestWords = wordChecker.getAllShortestWords(sentence);
        assertThat(longestWords, IsEmptyCollection.empty());
        assertThat(shortestWords, IsEmptyCollection.empty());
    }
}