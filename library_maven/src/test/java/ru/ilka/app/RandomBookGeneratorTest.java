package ru.ilka.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ilka.app.Model.Book;
import ru.ilka.app.Utils.RandomBookGenerator;

import java.util.Map;
import java.util.Objects;

public class RandomBookGeneratorTest {

    @Test
    public void testGetBookMap() {
        Map<Book, Integer> booksMap = RandomBookGenerator.getBookMap();
        Assertions.assertNotNull(booksMap, "The book map should not be null");
        Assertions.assertFalse(booksMap.isEmpty(), "The book map should not be empty");
        Assertions.assertTrue(booksMap.keySet().stream().allMatch(Objects::nonNull), "All books should not be null");
        Assertions.assertTrue(booksMap.values().stream().allMatch(v -> v > 0), "All book counts should be positive");
    }

    @Test
    public void testGetRandomNumberUsingNextInt() {
        int min = 1;
        int max = 5;
        int randomNumber = RandomBookGenerator.getRandomNumberUsingNextInt(min, max);
        Assertions.assertTrue(randomNumber >= min && randomNumber < max, "The random number should be within the range of min and max");
    }
}
