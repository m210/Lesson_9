package com.company;

public class Book {

    private String name;
    private Author author;
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
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author.toString() +
                ", year=" + year +
                '}';
    }
}
