package ru.ilka.app;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.ilka.app.Model.Book;

public class BookTest {
    @Test
    public void testBookConstructor() {
        Book book = new Book("title", "author", 2021);
        Assertions.assertEquals("title", book.getName());
        Assertions.assertEquals("author", book.getAuthor());
        Assertions.assertEquals(2021, book.year);
    }

    @Test
    public void testToString() {
        Book book = new Book("title", "author", 2021);
        String expectedString = "title\nauthor\n2021\n";
        Assertions.assertEquals(expectedString, book.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Book book1 = new Book("title", "author", 2021);
        Book book2 = new Book("title", "author", 2021);
        Assertions.assertEquals(book1, book2);
        Assertions.assertEquals(book1.hashCode(), book2.hashCode());

        Book book3 = new Book("different title", "author", 2021);
        Assertions.assertNotEquals(book1, book3);
        Assertions.assertNotEquals(book1.hashCode(), book3.hashCode());

        Book book4 = new Book("title", "different author", 2021);
        Assertions.assertNotEquals(book1, book4);
        Assertions.assertNotEquals(book1.hashCode(), book4.hashCode());

        Book book5 = new Book("title", "author", 2022);
        Assertions.assertNotEquals(book1, book5);
        Assertions.assertNotEquals(book1.hashCode(), book5.hashCode());
    }
}
