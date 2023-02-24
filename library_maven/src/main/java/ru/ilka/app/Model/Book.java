package ru.ilka.app.Model;

import java.util.Objects;

/**
 * Класс книга, в котором содержатся
 * поля имя, автор и год.
 * Есть три контсруктора.
 * Конструктор по умолчанию дает возможность создать книгу
 * и присвоить значение другой книги в цикле (для сторонних методов).
 * Переопределен equals и hashCode для сравнения книг.
 * Для красивого вывода переоппределили toString.
 */
public class Book {
    String name;
    String author;
    public int year;

    /**
     *
     * @param name
     * @param author
     * @param year
     */
    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
    public Book() {

    }

    /**
     *
     * @param name
     */
    public Book(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name + "\n" + author + "\n" + year + "\n";
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year
                && Objects.equals(getName(), book.getName())
                && Objects.equals(author, book.author);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), author, year);
    }

    public int getYear() {
        return year;
    }
}
