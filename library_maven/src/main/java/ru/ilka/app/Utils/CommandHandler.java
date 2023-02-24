package ru.ilka.app.Utils;

import java.util.Scanner;

import static ru.ilka.app.Utils.GetBook.getBook;
import static ru.ilka.app.Utils.PutBook.putBook;
import static ru.ilka.app.Utils.GetAllLibraryBooks.getAllLibraryBooks;
import static ru.ilka.app.Utils.GetAllUserBooks.getAllUserBooks;

/**
 * Класс CommandHandler -
 * отвечает за обработку комманд,
 * вводимых пользователем, в соответсвии с
 * коммандой вызывает необходимый метод.
 */

public class CommandHandler {
    public static void commandHandler() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("/q")) {
            if (command.startsWith("/all")) {
                getAllLibraryBooks();
                System.out.println("Введите следующую команду или введите /q для выхода");
                command = scanner.nextLine();

            } else if (command.startsWith("/list")) {
                getAllUserBooks();
                System.out.println("Введите следующую команду или введите /q для выхода");
                command = scanner.nextLine();

            } else if (command.startsWith("/put")) {
                putBook();
                System.out.println("Введите следующую команду или введите /q для выхода");
                command = scanner.nextLine();
            } else if (command.startsWith("/get")) {
                getBook(command);
                System.out.println("Введите следующую команду или введите /q для выхода");
                command = scanner.nextLine();

            } else {
                System.out.println("Вы ввели неверную команду!");
                System.out.println("Повторите ввод или введите /q для выхода");
                command = scanner.nextLine();
            }
        }
    }
}
