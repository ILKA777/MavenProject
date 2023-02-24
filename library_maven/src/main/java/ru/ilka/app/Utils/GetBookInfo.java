package ru.ilka.app.Utils;

import ru.ilka.app.Model.Book;

import java.util.Scanner;

/**
 * Класс для создания книги из свойств,
 * введенных пользователем с клавиатуры.
 */
public class GetBookInfo {
    /**
     *
     * @return
     */
    public static Book getBookInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги:");
        String name = scanner.nextLine();
        System.out.println("Введите автора книги:");
        String author = scanner.nextLine();
        System.out.println("Введите год издания книги:");
        Integer year = 0;
        try {
            year = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Это не число");
        }
        return new Book(name, author, year);
    }
}
