package com.company;

import java.util.Arrays;

public class Library {

    private final Book[] bookList;

    public Library(int capacity, Book... initialBooks) {
        this.bookList = new Book[capacity];
        System.arraycopy(initialBooks, 0, bookList, 0, initialBooks.length);
    }

    public boolean addBook(Book book) {
        int i = 0;
        while(i < bookList.length) {
            if(bookList[i] == null)
                break;

            if(bookList[i++].equals(book))
                return false;
        }

        if(i < bookList.length) {
            bookList[i] = book;
            return true;
        }
        return false;
    }

    public void printBookInfo(String name) {
        Book book = findBook(name);
        if(book != null)
            printBookInfo(book);
        else
            System.out.println("The book is not found!");
    }

    public void changeBookPublish(String name, int year) {
        Book book = findBook(name);
        if(book != null) {
            book.setYear(year);
        } else
            System.out.println("The book is not found!");
    }
    public void printAllInfos() {
        for(Book b : bookList) {
            printBookInfo(b);
        }
    }

    private Book findBook(String name) {
        for(Book book : bookList) {
            if(book == null)
                continue;

            if(book.getName().equalsIgnoreCase(name))
                return book;
        }
        return null;
    }

    private void printBookInfo(Book book) {
        if(book == null)
            return;

        System.out.println(book.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library: \n");

        int i = 1;
        for(Book book : bookList) {
            if(book == null)
                continue;

            sb.append("\tКнига ");
            sb.append(i++);
            sb.append(": ");
            sb.append(book.toString());
            sb.append("\n");
        }

       return sb.toString();
    }
}
