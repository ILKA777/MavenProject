package ru.ilka.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.ilka.app.DataBase.BookBase;
import ru.ilka.app.Model.Book;
import ru.ilka.app.Utils.GetBook;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static org.testng.AssertJUnit.*;

public class GetBookTest {
    private static final String INPUT = "/get Crime and Punishment\nDostoevsky\n";
    private static final String NON_EXISTENT_BOOK_INPUT = "/get Non-existent Book\n";
    private static final String INCORRECT_INPUT = "/get\n";
    private static final String MULTIPLE_BOOKS_INPUT = "/get Anna Karenina\nTolstoy\n";
    private static final Book TEST_BOOK = new Book("Crime and Punishment", "Dostoevsky", 1866);

    @BeforeAll
    static void setup() {
        // Инициализируйте мапы библиотеки и книги пользователя тестовыми данными
        Map<Book, Integer> libraryBooks = BookBase.getLibraryBooks();
        Map<Book, Integer> userBooks = BookBase.getUserBooks();
        libraryBooks.put(TEST_BOOK, 2);
        libraryBooks.put(new Book("War and Peace", "Tolstoy", 1869), 1);
        libraryBooks.put(new Book("Anna Karenina", "Tolstoy", 1878), 3);
        userBooks.put(new Book("The Idiot", "Dostoevsky", 1869), 1);
    }

    @Test
    void testGetExistingBook() {
        // Перенаправляем стандартный ввода для теста.
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(INPUT.getBytes()));

        GetBook.getBook("/get Crime and Punishment");

        Map<Book, Integer> libraryBooks = BookBase.getLibraryBooks();
        Map<Book, Integer> userBooks = BookBase.getUserBooks();
        Assertions.assertFalse(libraryBooks.containsKey(TEST_BOOK));
        Assertions.assertTrue(userBooks.containsKey(TEST_BOOK));
        Assertions.assertEquals(1, userBooks.get(TEST_BOOK));

        // Восстановливаем стандартный ввод.
        System.setIn(originalIn);
    }

    @Test
    void testGetNonExistentBook() {
        // Перенаправляем стандартный ввода для теста.
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(NON_EXISTENT_BOOK_INPUT.getBytes()));

        GetBook.getBook("/get Non-existent Book");

        Map<Book, Integer> libraryBooks = BookBase.getLibraryBooks();
        Map<Book, Integer> userBooks = BookBase.getUserBooks();
        Assertions.assertTrue(libraryBooks.containsKey(TEST_BOOK));
        Assertions.assertFalse(userBooks.containsKey(TEST_BOOK));

        // Восстановливаем стандартный ввод.
        System.setIn(originalIn);
    }

    @Test
    void testGetBookWithIncorrectInput() {
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(INCORRECT_INPUT.getBytes()));

        GetBook.getBook("/get");

        Map<Book, Integer> libraryBooks = BookBase.getLibraryBooks();
        Map<Book, Integer> userBooks = BookBase.getUserBooks();
        Assertions.assertTrue(libraryBooks.containsKey(TEST_BOOK));
        Assertions.assertFalse(userBooks.containsKey(TEST_BOOK));

        System.setIn(originalIn);
    }

    @Test
    public void testGetBookWithMultipleMatches() {
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(MULTIPLE_BOOKS_INPUT.getBytes()));

        GetBook.getBook("/get Anna Karenina");

        Map<Book, Integer> libraryBooks = BookBase.getLibraryBooks();
        Map<Book, Integer> userBooks = BookBase.getUserBooks();

        // Проверяем, что 1 книга добавленя к пользователю.
        assertEquals(1, userBooks.size());

        // Убеждаемся, что была добавлена нужная книга.
        Book expectedBook = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        assertTrue(userBooks.containsKey(expectedBook));
        assertEquals(1, userBooks.get(expectedBook).intValue());

        // Проверяем, что одна книга была удалена (взята) из библиотеки.
        assertEquals(5, libraryBooks.size());

        // Проверяем, что нужная книга была удалена из карты библиотеки.
        assertFalse(libraryBooks.containsKey(expectedBook));
    }
}