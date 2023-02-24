package ru.ilka.app.Utils;

import ru.ilka.app.Model.Book;
import ru.ilka.app.DataBase.BookBase;

/**
 * Класс PutBook -
 * отвечает за возврат книги в библиотеку.
 * Есть проверки на корректность ввода.
 */
public class PutBook {
    public static void putBook() {
        Book putBook = GetBookInfo.getBookInfo();
        while (!BookBase.getUserBooks().containsKey(putBook)) {
            System.out.println("Такой книги у вас нет, повторите ввод книги.");
            putBook = GetBookInfo.getBookInfo();
        }
        if (!BookBase.getLibraryBooks().containsKey(putBook)) {
            BookBase.getLibraryBooks().put(putBook, 1);
            BookBase.getUserBooks().remove(putBook);
        } else {
            BookBase.getLibraryBooks().put(putBook, BookBase.getLibraryBooks().get(putBook) + 1);
            BookBase.getUserBooks().remove(putBook);
        }
    }
}
