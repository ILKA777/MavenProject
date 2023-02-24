package ru.ilka.app.DataBase;

import ru.ilka.app.Model.Book;

import java.util.HashMap;
import java.util.Map;

import static ru.ilka.app.Utils.RandomBookGenerator.getBookMap;

/**
 * Класс BookBase
 * В нем храниться мапа книг из библиотеки (мапа нужна для того чтобы
 * помимо самой книги хранить и их кол-во), а также мапа книг юзера.
 */
public class BookBase {
    static Map<Book, Integer> libraryBooks = getBookMap();
    static Map<Book, Integer> userBooks = new HashMap<Book, Integer>();

    public static Map<Book, Integer> getLibraryBooks() {
        return libraryBooks;
    }

    public static Map<Book, Integer> getUserBooks() {
        return userBooks;
    }
}
