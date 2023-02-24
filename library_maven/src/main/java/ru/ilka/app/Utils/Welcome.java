package ru.ilka.app.Utils;

/**
 * Приветсвтие пользователя, просто выводим
 * список доступных команд.
 */
public class Welcome {
    public static void welcome() {
        System.out.println("Для работы с программой введите одну из следующих комманд:");
        System.out.println("/get имя книги - для того, чтобы взять книгу из библиотеки.");
        System.out.println("/list - для того, чтобы узнать какие книги вы взяли.");
        System.out.println("/put имя книги - для того, чтобы вернуть книгу в библиотеку.");
        System.out.println("/all - для того, чтобы получить список книг в библиотеки и их кол-во.");
    }
}
