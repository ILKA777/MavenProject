package ru.ilka.app.Utils;

import ru.ilka.app.Model.Book;
import ru.ilka.app.DataBase.BookBase;

import java.util.Map;
import java.util.Scanner;

/**
 * Класс GetBook - отвечает за получение книги
 * из библиотеки.
 * Есть проверки на корректность ввода.
 */
public class GetBook {
    /**
     *
     * @param command
     */
    public static void getBook(String command) {
        Scanner scanner = new Scanner(System.in);
        while (command.length() <= 5) {
            System.out.println("Введите комманду в виде /get имя книги");
            command = scanner.nextLine();
        }
        // Получаем имя книги из команды.
        String name = command.substring(5, command.length());
        int k = 0;

        // Проверяем есть ли такая книга, если есть одна,
        // то сразу кладем в мапу юзера и удаляем из библиотеки,
        // если несколько книг с разными авторами,
        // то просим ввести автора книги и кладем ее в мапу юзера.
        Book tempBook = new Book();
        for (Map.Entry<Book, Integer> entry : BookBase.getLibraryBooks().entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                k++;
                tempBook = entry.getKey();
                System.out.println(entry.getKey() + "\n" + "Кол-во " + entry.getValue());
            }
        }
        if (k == 0) {
            System.out.println("Такой книги нет.");
        } else if (k == 1) {
            if (!BookBase.getUserBooks().containsKey(tempBook)) {
                BookBase.getUserBooks().put(tempBook, 1);
                BookBase.getLibraryBooks().remove(tempBook);
            } else {
                BookBase.getUserBooks().put(tempBook, BookBase.getUserBooks().get(tempBook) + 1);
                BookBase.getLibraryBooks().remove(tempBook);
            }
        } else {
            System.out.println("Введите автора книги");
            String author = scanner.nextLine();
            int l = 0;
            for (Map.Entry<Book, Integer> entry : BookBase.getLibraryBooks().entrySet()) {
                if (entry.getKey().getName().equals(name) && entry.getKey().getAuthor().equals(author)) {
                    tempBook = entry.getKey();
                    if (!BookBase.getUserBooks().containsKey(tempBook)) {
                        BookBase.getUserBooks().put(tempBook, 1);
                        BookBase.getLibraryBooks().remove(tempBook);
                        l++;
                    } else {
                        BookBase.getUserBooks().put(tempBook, BookBase.getUserBooks().get(tempBook) + 1);
                        BookBase.getLibraryBooks().remove(tempBook);
                        l++;
                    }
                }
            }
            if (l == 0) {
                System.out.println("Такого автора нет.");
            }
        }
    }
}
