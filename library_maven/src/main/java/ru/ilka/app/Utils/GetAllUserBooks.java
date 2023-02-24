package ru.ilka.app.Utils;

import ru.ilka.app.Model.Book;
import ru.ilka.app.DataBase.BookBase;

import java.util.Map;

/**
 * Класс getAllUserBooks -
 * просто выводит все книги из мапы пользователя.
 */
public class GetAllUserBooks {
    public static void getAllUserBooks() {
        for (Map.Entry<Book, Integer> entry : BookBase.getUserBooks().entrySet()) {
            System.out.println(entry.getKey() + "\n" + "Кол-во " + entry.getValue());
            System.out.println();
        }
    }
}
