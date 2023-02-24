package ru.ilka.app;

import org.testng.annotations.Test;
import ru.ilka.app.DataBase.BookBase;
import ru.ilka.app.Model.Book;

import java.util.Map;

import static org.junit.Assert.*;

public class BookBaseTest {

    @Test
    public void testGetLibraryBooks() {
        assertNotNull(BookBase.getLibraryBooks());
    }

    @Test
    public void testGetUserBooks() {
        assertNotNull(BookBase.getUserBooks());
    }

    @Test
    public void testLibraryBooksNotEmpty() {
        assertFalse(BookBase.getLibraryBooks().isEmpty());
    }

    @Test
    public void testUserBooksEmptyInitially() {
        assertTrue(BookBase.getUserBooks().isEmpty());
    }

    @Test
    public void testGetLibraryBooksReturnsSameMap() {
        Map<Book, Integer> libraryBooks1 = BookBase.getLibraryBooks();
        Map<Book, Integer> libraryBooks2 = BookBase.getLibraryBooks();
        assertSame(libraryBooks1, libraryBooks2);
    }

    @Test
    public void testGetUserBooksReturnsSameMap() {
        Map<Book, Integer> userBooks1 = BookBase.getUserBooks();
        Map<Book, Integer> userBooks2 = BookBase.getUserBooks();
        assertSame(userBooks1, userBooks2);
    }
}

