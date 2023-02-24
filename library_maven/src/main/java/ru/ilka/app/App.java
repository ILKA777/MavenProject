package ru.ilka.app;

import ru.ilka.app.Utils.CommandHandler;
import ru.ilka.app.Utils.Welcome;

/**
 * Точка входа в приложение.
 */
public class App {
    public static void main(String[] args) {
        Welcome.welcome();
        CommandHandler.commandHandler();
    }
}
