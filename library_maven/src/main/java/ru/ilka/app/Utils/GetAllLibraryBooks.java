package ru.ilka.app.Utils;

import ru.ilka.app.Model.Book;
import ru.ilka.app.DataBase.BookBase;

import java.util.Map;

/**
 * Класс getAllLibraryBooks -
 * просто выводит все книги из мапы библиотеки,
 * а также их кол-во.
 */
public class GetAllLibraryBooks {
    public static void getAllLibraryBooks() {
        for (Map.Entry<Book, Integer> entry : BookBase.getLibraryBooks().entrySet()) {
            System.out.println(entry.getKey() + "\n" + "Кол-во " + entry.getValue());
            System.out.println();
        }
        System.out.println();
        System.out.println("Всего книг: " + BookBase.getLibraryBooks().size());
    }
}
