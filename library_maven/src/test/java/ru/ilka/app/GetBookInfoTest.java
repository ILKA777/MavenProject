package ru.ilka.app;

import org.junit.jupiter.api.Test;
import ru.ilka.app.Model.Book;
import ru.ilka.app.Utils.GetBookInfo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetBookInfoTest {

    @Test
    void testGetBookInfo() {
        String input = "The Great Gatsby\nF. Scott Fitzgerald\n1925\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Book expected = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book actual = GetBookInfo.getBookInfo();

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getYear(), actual.getYear());
    }
}
