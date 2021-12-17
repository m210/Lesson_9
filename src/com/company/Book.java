package com.company;

import java.util.Objects;

public class Book {

    private final String name;
    private final Author author;
    private int year;

    public Book(Author author, String name, int year) {
        this.author = author;
        this.name = name;
        this.year = year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "\"" + name + "\" by " + author.getFirstName() + " " + author.getLastName() + " was published in " + year;

//        return "Book {" +
//                "name = '" + name + '\'' +
//                ", author = " + author.toString() +
//                ", year = " + year +
//                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && name.equals(book.name) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year);
    }
}
