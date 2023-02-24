package ru.ilka.app.Utils;

import ru.ilka.app.Model.Book;

import java.util.*;

/**
 * Класс RandomBookGenerator -
 * отвечает за генерацию списка книг (для библиотеки).
 * Генерация происходит с помощью случайного выбора
 * имени, автора и года из уже созданных списков.
 */
public class RandomBookGenerator {
    /**
     *
     * @return
     */
    public static Map<Book, Integer> getBookMap() {
        Map<Book, Integer> booksMap = new HashMap<Book, Integer>();

        List<Book> books = new ArrayList<Book>();

        String[] names = {"Как стать сеньором с нуля", "Java или C#? Битва Века.", "Как забить гол на матче века онлайн ?",
                "Паттерн абстрактная фабрика - мейнстрим или старая классика?", "Быть программистом ? За деньги - да!"};
        String[] authors = {"Александр Кучук", "Леонид Недзельницкий", "Илья Морин", "Андрей Стародубцев",
                "Дарья Баханкова", "Русский Народ"};

        int x = getRandomNumberUsingNextInt(8, 15);

        for (int i = 0; i < x; i++) {
            books.add(new Book(
                    names[getRandomNumberUsingNextInt(0, 4)],
                    authors[getRandomNumberUsingNextInt(0, 5)],
                    getRandomNumberUsingNextInt(2020, 2023)));
        }

        for (int i = 0; i < books.size(); i++) {
            Book tempBook = books.get(i);

            if (!booksMap.containsKey(tempBook)) {
                booksMap.put(tempBook, 1);
            } else {
                booksMap.put(tempBook, booksMap.get(tempBook) + 1);
            }
        }
        return booksMap;
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
